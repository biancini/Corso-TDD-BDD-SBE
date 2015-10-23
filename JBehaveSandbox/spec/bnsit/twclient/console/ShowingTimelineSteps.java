package bnsit.twclient.console;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ShowingTimelineSteps {

	private FakeConsoleOutput output;
	private ConsoleTwitterClient twitterClient;
	private FakeConsoleInput input;

	@Given("I have started an application")
	public void applicationStarted() {
		output = new FakeConsoleOutput();
		input = new FakeConsoleInput();
		boolean thereIsConnection = true;
		twitterClient = new ConsoleTwitterClient(
				output, input, new FakeTwitterService(thereIsConnection));	
	}
	
	@When("I enter \"timeline\"")
	public void enteringCommand() {
		input.enterText("timeline");
		twitterClient.run();		
	}
	
	@Then("I will see first 20 statuses")
	public void seeingStatuses() {
		output.assertHasMoreEntriesThan(20);
	}
	
}
