package beans;

import java.util.ArrayList;

public class Response {

	private long id;
	private String response;
	private ArrayList<User> userResponse = new ArrayList<User>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ArrayList<User> getUserResponse() {
		return userResponse;
	}

	public void setUserResponse(ArrayList<User> userResponse) {
		this.userResponse = userResponse;
	}

}
