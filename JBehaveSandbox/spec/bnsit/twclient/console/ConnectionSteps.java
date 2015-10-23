package bnsit.twclient.console;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ConnectionSteps {

	private ConsoleTwitterClient twitterClient;
	private FakeConsoleOutput output;
	private FakeConsoleInput input;

	@Given("there is a connection to twitter service")
	public void thereIsAConnectionToTwitterService() {
		output = new FakeConsoleOutput();
		input = new FakeConsoleInput();
		boolean thereIsConnection = true;
		twitterClient = new ConsoleTwitterClient(
				output, input, new FakeTwitterService(thereIsConnection));
	}
	
	@Given("there is no connection to twitter service")
	public void thereIsNoConnectionToTwitterService() {
		output = new FakeConsoleOutput();
		input = new FakeConsoleInput();
		boolean noConnection = false;
		twitterClient = new ConsoleTwitterClient(
				output, input, new FakeTwitterService(noConnection));
	}
	
	@When("I start an application")
	public void applicationHasStarted() {
		input.enterText("");
		twitterClient.run();		
	}
	
	@Then("I can see \"$message\" message")
	public void seeingConnectedMessage(String message) {
		output.assertLastLineEquals(message);
	}
}
