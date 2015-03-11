package org.gradle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class votingcontroller {

	   private final AtomicLong counter = new AtomicLong();
	   private final AtomicLong counter2 = new AtomicLong();
	   List<moderator> l = new ArrayList<moderator>();
	   List<poll> p = new ArrayList<poll>();
	   List<PollResult> pr = new ArrayList<PollResult>();
	   HashMap Mod_Polls = new HashMap();

	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators",  method = RequestMethod.POST)
	    public ResponseEntity<moderator> setmoderator(@Valid @RequestBody moderator m1) {
	    //public moderator getmoderator() {
	    	/*moderator m = new moderator();
	    	m.setId(counter.incrementAndGet());
	    	m.setName("Raghav");
	    	m.setEmail("rrsony22@gmail.com");
	    	m.setPassword("test123");
	    	m.setCreated_at(date); */
	        //return m;
	    	/*moderatorWrapper w = new moderatorWrapper(); */
	    	
	    	m1.setId(counter.incrementAndGet());
	        m1.setCreated_at(new Date());
	    	
	    	l.add(m1);
	    	
	        return new ResponseEntity<moderator>(m1, HttpStatus.CREATED);
	    }
	    
	    /*
	     * Method to view moderator based on given id
	     */
	   // @Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{id1}",  method = RequestMethod.GET)
	    public ResponseEntity<moderator> getmoderator(@PathVariable long id1) {

	    	moderator m2 = new moderator();
	    	for (int i = 0; i < l.size(); i++)
	    	    if (l.get(i).id == id1) {
	    	    	m2 = l.get(i);
	    	    }
	    	
	    	System.out.println("m2 Object: " + m2);
	    	
	    	//moderator m2 = l.get(0);
	    	return new ResponseEntity<moderator>(m2, HttpStatus.OK);
	    }
	    
	    /*
	     * Method to update moderator
	     */
	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{moderator_id}",  method = RequestMethod.PUT)
	    public ResponseEntity<moderator> updatemoderator(@PathVariable long moderator_id, @RequestBody moderator m1) {
			
	    	moderator m_temp = new moderator();
	    	for(int i=0; i< l.size(); i++)
	    	{
	    		if(l.get(i).id == moderator_id)
	    		{
	    			m_temp = l.get(i);
	    			System.out.println("updatemoderator: inside if ");
	    			if(m1.getName() != null){
	    			  m_temp.setName(m1.getName());
	    			  System.out.println("updatemoderator: m1.getName" + m_temp.getName());
	    			}
	    			if(m1.getEmail() != null)
	    			{
	    			  m_temp.setEmail(m1.getEmail());
	    			  System.out.println("updatemoderator: m1.getEmail" + m_temp.getEmail());
	    			}
	    			
	    			if(m1.getPassword() != null)
	    			{
	    			  m_temp.setPassword(m1.getPassword());
	    			  System.out.println("updatemoderator: m1.getPassword" + m_temp.getPassword());
	    			}
	    			
	    			l.set(i, m_temp);
	    		}
	    	}
	    	
	    	return new ResponseEntity<moderator>(m_temp, HttpStatus.CREATED);
	    	
	    }
	    
	    
	    
	    //poll Handling Methods
	    /*
	     * Method to Create Poll
	     */
	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{id}/polls",  method = RequestMethod.POST)
	    public ResponseEntity<poll> createPoll(@PathVariable long id, @Valid @RequestBody poll p1) throws ParseException {
	    	
	    	for(moderator m5: l )
	    	{
	    		if(m5.getId() == id)
	    		{
	    			System.out.println("Inside if createPoll POST");
	    			p1.setId(counter2.incrementAndGet());
	    	        p1.setStarted_at(new Date());
	    	        p1.setExpired_at(new Date());
	    	        
	    	        ArrayList al = new ArrayList();
	    	        //al.add(0);
	    	        /*al.add("iOS");
	    	        p1.setChoice(al); */
	    	        
	    	    	p.add(p1);
	    	    	m5.addModerator_poll(p1);
	    	    	
	    	    	int choiceItem_count = p1.getChoice().size();
	    	    	for(int i =0; i<choiceItem_count; i++)
	    	    	{
	    	    		al.add(0);
	    	    	}
	    	    	
	    	    	PollResult prTemp = new PollResult();
	    	    	prTemp.setP(p1);
	    	    	prTemp.setResults(al);
	    	    	
	    	    	pr.add(prTemp);	    	    	
	    		}
	    	    	
	    	}
	    	        return new ResponseEntity<poll>(p1, HttpStatus.CREATED);
	    			//p1.setId(counter2.incrementAndGet());
	    	        //p1.setStarted_at(new Date());
                    //Calendar cal = Calendar.getInstance();
                    //cal.setTime(new SimpleDateFormat().parse(p1.getStarted_at()));
                    //cal.add(Calendar.DATE, 20);
	    	        //p1.setExpired_at(cal.getTime());
	    	        //ArrayList al = new ArrayList();
	    	        /*al.add("Android");
	    	        al.add("iOS");
	    	        p1.setHm(al);
	    	    	p.add(p1); */
	    			
	    			
	    }
	    
	    /*
	     * Method to view Poll without Results
	     */
	    @RequestMapping(value = "/api/v1/polls/{poll_id}",  method = RequestMethod.GET)
	    public ResponseEntity<poll> getPoll(@PathVariable long poll_id) {

	    	poll p2 = new poll();
	    	for (int i = 0; i < p.size(); i++)
	    	    if (p.get(i).id == poll_id) {
	    	    	p2 = p.get(i);
	    	    }
	    	
	    	System.out.println("m2 Object: " + p2);

	    	return new ResponseEntity<poll>(p2, HttpStatus.OK);
	    }
	    
	    /*
	     * Method to view Poll with Results
	     */
	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{moderator_id}/polls/{poll_id}",  method = RequestMethod.GET)
	    public ResponseEntity<PollResult> getPollResult(@PathVariable long moderator_id, @PathVariable long poll_id) {
	    	
	    	
	    	poll p3 = new poll();
	    	PollResult p4 = new PollResult();
	    	for (int i = 0; i < l.size(); i++)
	    	    if (l.get(i).id == moderator_id) {
	    	    	moderator mTemp = l.get(i);
	    	    	for (int j = 0; j < mTemp.giveModerator_poll().size(); j++)
	    	    	    if (mTemp.giveModerator_poll().get(j).id == poll_id) {
	    	    	    	p3 = mTemp.giveModerator_poll().get(j);
	    	    	    	int nTemp = -1;
	    	    	    	for(int k=0; k< p.size(); k++)
	    	    	    	{
	    	    	    		if(p.get(k).id == p3.getId())
	    	    	    		{
	    	    	    			nTemp = k;
	    	    	    		}
	    	    	    	}
	    	    	    	
	    	    	    	p4 = pr.get(nTemp);
	    	    	    	
	    	    	
	    	    	
	    	    	/*for (int j = 0; j < p.size(); j++)
	    	    	    if (p.get(j).id == poll_id) {
	    	    	    	p3 = p.get(j);
	    	    	    	
	    	    	    	ArrayList al2 = new ArrayList();
	    	    	        al2.add(500);
	    	    	        al2.add(600);
	    	    	        
	    	    	        p4.setP(p3);
	    	    	        p4.setResults(al2); */
	    	    	    	
	    	    	    }
	    	    }

	    	return new ResponseEntity<PollResult>(p4, HttpStatus.OK);
	    }
	    
	    
	    /*
	     * Method to view all Poll
	     */
	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{moderator_id}/polls",  method = RequestMethod.GET)
	    public ResponseEntity<ArrayList> getAllPolls(@PathVariable long moderator_id) {
	    	
	    	ArrayList<PollResult> allPollsResult = new ArrayList<PollResult>();
	    	for (int i = 0; i < l.size(); i++)
	    	    if (l.get(i).id == moderator_id) {  
	    	    	
	              moderator mTemp1 = l.get(i);
	              
	            	 for(int k=0; k <p.size(); k++)
	            	 {
	            		 if(p.get(k).id == mTemp1.giveModerator_poll().get(k).getId())
	            		 {
	            			 allPollsResult.add(pr.get(k));
	            		 }
	            	 }
	    
	    	    }
	    	
	    	return new ResponseEntity<ArrayList>(allPollsResult, HttpStatus.OK);
	    }
	    
	    
	    /*
	     * Method to delete a Poll
	     */
	    //@Secured(value = { "ROLE_USER" })
	    @RequestMapping(value = "/api/v1/moderators/{moderator_id}/polls/{poll_id}",  method = RequestMethod.DELETE)
	    public ResponseEntity removePoll(@PathVariable long moderator_id, @PathVariable long poll_id) {
	    	
	    	
	    	ArrayList<PollResult> temp = new ArrayList<PollResult>();
	    	for (int i = 0; i < l.size(); i++)
	    	{
	    	    if (l.get(i).id == moderator_id) {  
	    	    	moderator mTemp = l.get(i);
	    	    	for (int j = 0; j < p.size(); j++)
	    	    	    if (p.get(j).id == poll_id) {
	                       p.remove(j);
	                       pr.remove(j);
	                       mTemp.removeModerator(j);
	    	    	    }
	    	    }
	    	} 	
	    	return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	    
	    
	    /*
	     * Method to vote a Poll
	     */
	    @RequestMapping(value = "/api/v1/polls/{poll_id}",  method = RequestMethod.PUT)
	    public ResponseEntity votePoll(@PathVariable long poll_id, @RequestParam(value="choice", defaultValue="0") int choice) {
	    	for (int j = 0; j < pr.size(); j++)
	    	{
	    	    if (pr.get(j).getId() == poll_id) {
	    	       ArrayList temp = pr.get(j).getResults();
	    	       int n = (Integer.parseInt(temp.get(choice).toString())) + 1;
	    	       temp.set(choice, n);
	    	       PollResult la = pr.get(j);
	    	       la.setResults(temp);
	    	       pr.set(j, la);
	    	    }
	    	}
	    	return new ResponseEntity(HttpStatus.NO_CONTENT);
	    }
	    
	   
	    
}
