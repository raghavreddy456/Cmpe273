package org.gradle;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.constraints.NotNull;

public class moderator {

	@NotNull
    public long id;
	
	@NotNull
    private String name;
    private String email;
    private String password;
    private Date created_at;
    private ArrayList<poll> moderator_poll = new ArrayList<poll>();
    
    public void setModerator_poll(ArrayList<poll> p){
    	moderator_poll = p;
    }
    
    public void addModerator_poll(poll p)
    {
    	moderator_poll.add(p);
    }
    
    public ArrayList<poll> giveModerator_poll()
    {
    	return moderator_poll;
    }
    
    public void removeModerator(int n){
    	moderator_poll.remove(n);
    }

    /*public Moderator(long id, String name, String email, String password,Date created_at ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }*/
    
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getCreated_at() {
    	
    	//Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'");
        
        //return created_at.toString("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        
        return ft.format(created_at);
    }

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setId(long id) {
		this.id = id;
	}
}

