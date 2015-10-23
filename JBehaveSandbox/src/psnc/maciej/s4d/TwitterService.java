package psnc.maciej.s4d;

import twitter4j.TwitterException;

/**
 * Created by Maciej Łabędzki
 * Date: 21.10.15
 */
public interface TwitterService {

    void connect() throws TwitterException, TwitterConnectionErrorException;

    String getTimeline() throws TwitterException;
}
