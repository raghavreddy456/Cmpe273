package org.gradle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.validation.constraints.NotNull;

public class poll {

	@NotNull
	public long id;

	@NotNull
	private String question;
	private Date started_at;
	private Date expired_at;
	private ArrayList<String> choice;


	public long getId() {
		//return Integer.toString((int)id, 36);
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
	public String getStarted_at() {

		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

		return ft.format(started_at);
		//return started_at.toString();
	}
	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}
	public String getExpired_at() {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");

		//return created_at.toString("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		return ft.format(expired_at);
		//return expired_at.toString();
	}
	public void setExpired_at(Date expired_at) {

		this.expired_at = expired_at;
	}
	public ArrayList getChoice() {
		return choice;
	}
	public void setChoice(ArrayList<String> choice) {
		this.choice = choice;
	}

}

