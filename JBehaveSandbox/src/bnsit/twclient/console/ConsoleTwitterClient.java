package bnsit.twclient.console;

import java.util.List;

import bnsit.twclient.console.model.Status;
import bnsit.twclient.model.BaseTwitterService;
import bnsit.twclient.model.TwitterService;

public class ConsoleTwitterClient {

	private ConsoleOutput output = new SystemConsoleOutput();
	private ConsoleInput input = new SystemConsoleInput();
	private TwitterService twitterService;
	
	public ConsoleTwitterClient(ConsoleOutput output, ConsoleInput input, TwitterService twitterService) {
		this.output = output;
		this.input = input;
		this.twitterService = twitterService;
	}

	public static void main(String[] args) {
		new ConsoleTwitterClient(
				new SystemConsoleOutput(), new SystemConsoleInput(), new BaseTwitterService()).run();
	}

	public void run() {
		output.println("Welcome to the twitter client");
		
		twitterService.setCredentials();
		
		boolean hasConnection = twitterService.hasConnection();
		if (hasConnection) {
			output.println("Connected.");					
		} else {
			output.println("Not connected.");					
		}
		
		String enteredText = input.nextLine();
		
		if (enteredText.equals("timeline")) {
			showTimeline();
		} else {
			System.out.println("Sorry command not recognized: " + enteredText);
		}

	}

	private void showTimeline() {
		List<Status> timeline = twitterService.getTimeline();
		for (Status status : timeline) {
			output.println(status.getName() + ": " + status.getText());
		}
	}

}
