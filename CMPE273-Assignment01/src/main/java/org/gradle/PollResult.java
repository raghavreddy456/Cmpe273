package org.gradle;


import java.util.*;

import javax.validation.constraints.NotNull;

public class PollResult {

	private poll p;
	@NotNull
	public long id;
    private String question;
    private Date started_at;
    private Date expired_at;
    
    @NotNull
    private ArrayList<String> choice;
    
	private ArrayList<Integer> results;
	/*public poll getP() {
		return p;
	} */
	
	public void setP(poll p) {
		this.p = p;
	}
	public ArrayList<Integer> getResults() {
		return results;
	}
	public void setResults(ArrayList<Integer> results) {
		this.results = results;
		
	}
	public long getId() {
		return p.id;
	}
	public String getQuestion() {
		return p.getQuestion();
	}
	public String getStarted_at() {
		return p.getStarted_at();
	}
	public String getExpired_at() {
		return p.getExpired_at();
	}
	public ArrayList<String> getChoice() {
		return p.getChoice();
	}
	
	/*pollResult(poll p, ArrayList results)
	{
		this.p = p;
		this.results = results;
	} */
}

