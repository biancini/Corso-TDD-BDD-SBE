package psnc.maciej.s4d;

import scala.Console;
import twitter4j.*;
import twitter4j.auth.AccessToken;

/**
 * Created by Maciej Łabędzki
 * Date: 21.10.15
 */
public class TwitterServiceImpl implements TwitterService {

    private final static String ACCESS_TOKEN = "3772080154-8sLVzUUXO8d2PaFKP5K9pV9UPjm3gfkAH7k47XI";
    private final static String ACCESS_TOKEN_SECRET = "djdjWZC1Ks2NMaxDzSdRIHjBc8iIhVACY0MsNwn59HPzV";

    private final static String CONSUMER_KEY = "5NeejYtgJdibpRzIHsGT0AoQ1";
    private final static String CONSUMER_KEY_SECRET = "zoUQx9pNEwcFLnUZyUEsMyeePUwaqZK5ZrlmsfstwuvbCHJMD1";
    private Twitter twitter;

    public TwitterServiceImpl() {
    }

    @Override
    public void connect() throws TwitterConnectionErrorException {

        try {
            twitter = new TwitterFactory().getInstance();
            twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

            String accessToken = getSavedAccessToken();
            String accessTokenSecret = getSavedAccessTokenSecret();
            AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);

            twitter.setOAuthAccessToken(oathAccessToken);
        } catch (Exception exception) {
            throw new TwitterConnectionErrorException(exception);
        }

    }

    @Override
    public String getTimeline() throws TwitterException {
        ResponseList<Status> responseList = twitter.getHomeTimeline();
        StringBuffer sb = new StringBuffer();
        for (Status s : responseList) {
            sb.append(s.getText());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getSavedAccessToken() {
        return ACCESS_TOKEN;
    }

    public String getSavedAccessTokenSecret() {
        return ACCESS_TOKEN_SECRET;
    }

}
