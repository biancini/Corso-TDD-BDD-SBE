package bnsit.twclient.model;

import java.util.List;

import bnsit.twclient.console.model.Status;

public interface TwitterService {

	void setCredentials();

	List<Status> getTimeline();

	boolean hasConnection();

}