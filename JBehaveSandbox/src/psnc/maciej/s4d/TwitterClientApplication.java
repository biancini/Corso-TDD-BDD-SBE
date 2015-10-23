package psnc.maciej.s4d;

import scala.Console;
import twitter4j.TwitterException;

public class TwitterClientApplication {

    private TwitterService twitterService;
    private ConsoleDriver console;

    public TwitterClientApplication(ConsoleDriver console, TwitterService twitterService) {
        this.console = console;
        this.twitterService = twitterService;
    }

    public void start(String[] args) throws TwitterException {

        this.console.println("Connecting to twitter..");
        try {
            twitterService.connect();
            this.console.println("Connected.");
        } catch (TwitterConnectionErrorException e) {
            this.console.println("Connection failed.");
        }

        serveCommands(twitterService);

    }

    private void serveCommands(TwitterService twitterService) throws TwitterException {
        String command = "";
        while (!command.equalsIgnoreCase("exitapp")) {
            console.print("> ");
            command = console.readLine();
            switch (command) {
                case "timeline":
                    String result = twitterService.getTimeline();
                    Console.println("\n" + result);
                    break;
                default:
            }
        }
    }

    static public void main(String[] args) {
        try {
            new TwitterClientApplication(new RealConsoleDriver(), new TwitterServiceImpl()).start(args);
        } catch (TwitterException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}