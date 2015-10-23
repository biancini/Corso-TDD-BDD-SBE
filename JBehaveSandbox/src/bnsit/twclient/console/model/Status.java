package bnsit.twclient.console.model;

public class Status {

	private String name;
	private String screenName;
	private String text;

	public Status(String name, String screenName, String text) {
		this.name = name;
		this.screenName = screenName;
		this.text = text;
	}
	
	public String getName() {
		return name;
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public String getText() {
		return text;
	}
}
