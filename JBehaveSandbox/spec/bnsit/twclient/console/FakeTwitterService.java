package bnsit.twclient.console;

import java.util.ArrayList;
import java.util.List;

import bnsit.twclient.console.model.Status;
import bnsit.twclient.model.TwitterService;

public class FakeTwitterService implements TwitterService {

	private boolean isConnection;

	public FakeTwitterService(boolean isConnection) {
		this.isConnection = isConnection;
	}

	@Override
	public void setCredentials() {

	}

	@Override
	public List<Status> getTimeline() {
		ArrayList<Status> result = new ArrayList<Status>();
		result.add(new Status("ABC", "abc", "ABC says: Hello world"));
		result.add(new Status("CDE", "cde", "CDE says: Hello world"));
		result.add(new Status("EFG", "efg", "EFG says: Hello world"));
		result.add(new Status("HIJ", "hij", "HIJ says: Hello world"));
		result.add(new Status("KLM", "klm", "KLM says: Hello world"));
		result.add(new Status("ABC", "abc", "ABC says: Hello world"));
		result.add(new Status("CDE", "cde", "CDE says: Hello world"));
		result.add(new Status("EFG", "efg", "EFG says: Hello world"));
		result.add(new Status("HIJ", "hij", "HIJ says: Hello world"));
		result.add(new Status("KLM", "klm", "KLM says: Hello world"));
		result.add(new Status("ABC", "abc", "ABC says: Hello world"));
		result.add(new Status("CDE", "cde", "CDE says: Hello world"));
		result.add(new Status("EFG", "efg", "EFG says: Hello world"));
		result.add(new Status("HIJ", "hij", "HIJ says: Hello world"));
		result.add(new Status("KLM", "klm", "KLM says: Hello world"));
		result.add(new Status("ABC", "abc", "ABC says: Hello world"));
		result.add(new Status("CDE", "cde", "CDE says: Hello world"));
		result.add(new Status("EFG", "efg", "EFG says: Hello world"));
		result.add(new Status("HIJ", "hij", "HIJ says: Hello world"));
		result.add(new Status("KLM", "klm", "KLM says: Hello world"));
		// add more
		return result;
	}

	@Override
	public boolean hasConnection() {
		return isConnection;
	}

}
