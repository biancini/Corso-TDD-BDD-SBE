package bnsit.twclient.model;

import java.util.ArrayList;
import java.util.List;

import bnsit.twclient.console.model.Status;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class BaseTwitterService implements TwitterService {

	private final static String ACCESS_TOKEN = "3772080154-8sLVzUUXO8d2PaFKP5K9pV9UPjm3gfkAH7k47XI";
	private final static String ACCESS_TOKEN_SECRET = "djdjWZC1Ks2NMaxDzSdRIHjBc8iIhVACY0MsNwn59HPzV";

	private final static String CONSUMER_KEY = "5NeejYtgJdibpRzIHsGT0AoQ1";
	private final static String CONSUMER_KEY_SECRET = "zoUQx9pNEwcFLnUZyUEsMyeePUwaqZK5ZrlmsfstwuvbCHJMD1";
	private Twitter twitter;

	@Override
	public void setCredentials() {
		try {
			twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

			String accessToken = getSavedAccessToken();
			String accessTokenSecret = getSavedAccessTokenSecret();
			AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);

			twitter.setOAuthAccessToken(oathAccessToken);
		} catch (Exception exception) {
			throw new TwitterServiceException(exception);
		}
	}

	private String getSavedAccessTokenSecret() {
		return ACCESS_TOKEN_SECRET;
	}

	private String getSavedAccessToken() {
		return ACCESS_TOKEN;
	}

	@Override
	public List<Status> getTimeline() {
		try {
			List<Status> statuses = new ArrayList<Status>();
		    ResponseList<twitter4j.Status> timeline = twitter.getHomeTimeline();
		    for (twitter4j.Status status : timeline) {
				statuses.add(new Status(
						status.getUser().getName(),
						status.getUser().getScreenName(),
						status.getText()));
			}
			return statuses;
		} catch (TwitterException e) {
			throw new TwitterServiceException(e);
		}
	}

	@Override
	public boolean hasConnection() {
		try {
			twitter.getUserTimeline(new Paging(1,1));
		} catch (TwitterException e) {
			// no connection
			if (e.getExceptionCode().equals("4be80492-0c7a8414 d7e149ce-82d5fa33")) {
				return false;
			}
			throw new TwitterServiceException(e);
		}
		return true;
	}
}
