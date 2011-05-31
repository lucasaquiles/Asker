package beans;

import java.util.ArrayList;
import java.util.Date;

public class Question {

	private long id;
	ArrayList<Response> response = new ArrayList<Response>();
	
	
	Date dateCreated;
	String question;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<Response> getResponse() {
		return response;
	}
	public void setResponse(ArrayList<Response> response) {
		this.response = response;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}

	
	public String toString(){
		
		return question;
	}
}
