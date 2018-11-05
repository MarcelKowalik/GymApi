/*
 * This is a class that operates between the inheritance hierarchy classes , assessment class and menu controller.
 * @version 1
 * @author Marcel Kowalik.
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GymApi {
	
	ArrayList<Member> members = new ArrayList<Member>();
	ArrayList<Trainer> trainers = new ArrayList<Trainer>();
	
	/*
	 * Setters and Getters
	 */
    public void addMember (Member member){
    	members.add(member);
    }
    public void addTrainer (Trainer trainer){
    	trainers.add(trainer);
    }
    public int numberOfMembers(){
    	return members.size();
    }
    public int numberOfTrainers(){
    	return trainers.size();
    }
    public ArrayList<Member> getMembers() {
		return members;
	}
	public ArrayList<Trainer> getTrainers() {
		return trainers;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	public void setTrainers(ArrayList<Trainer> trainers) {
		this.trainers = trainers;
	}
	

	/**	
	 * 	Returns a boolean indicating if the index passed as a parameter is a valid index for the
	 *	member’s array list.
	 */
    public boolean isValidMemberIndex (int index){
    	if(index >= 0 && index < members.size()){
    		return true;
    	}
    	return false;
    }
    
	/**
	 * 	Returns a boolean indicating if the index passed as a parameter is a valid index for the
	 *	trainer’s array list.
	 */  
    public boolean isValidTrainerIndex (int index){
    	if(index >= 0 && index < trainers.size()){
    		return true;
    	}
    	return false;
    }
    
	/**	
	 * 	Returns the member object that matches the email entered. If no member matches, return
	 *	null
	 */
    public Member searchMembersByEmail (String emailEntered){
    	for(int i = 0; i<members.size(); i++){
    		if(members.get(i).getEmail() == emailEntered){
    			return members.get(i);
    		}
    	}
    	return null;
    	
    }
    
	/**
	 * 	Returns the trainer object that matches the email entered. If no trainer matches, return 
	 * 	null.	 	
	 */
    public Person searchTrainersByEmail (String emailEntered){

    	for(int i = 0; i<trainers.size(); i++){
    		if(trainers.get(i).getEmail() == emailEntered){
    			return trainers.get(i);
    		}
    	}
    	return null;
    }
    
	/**
	 * 	Returns a string containing all the members details in the gym. If there are no members in
	 *	the gym, return a message indicating this. 
	 */
    public String listMembers(){
    	if(!members.isEmpty()){
	    	String memberPrintout = "Members: \n";
	    	for(int i =0 ; i<members.size(); i++){
	        	memberPrintout += members.get(i)+"\n";
	    	}
	    	return memberPrintout;
    	}
    	
    	else return "There are no members!";

 	
    }
    
	/**
	 *	Returns a string containing all the members details in the gym whose latest assessment
	 *	weight is an ideal weight (based on the devine method). If there are no members in the
	 *	gym, return a message indicating this. If there are members in the gym, but none have a
	 *	current ideal body weight, return a message indicating this also.
	*/
    public String listMembersWithIdealWeight(){

    	if(!members.isEmpty()){
	    	String memberPrintout = "Members with ideal bodyweight: \n";
	    	for(Member current: members){
	    		
	    		if(current.isIdealBodyWeight(current.getStartingWeight())){
	    			memberPrintout += current+"\n";
	    		}
	    	}
	    	return memberPrintout;
    	}
    	else return "There are no members!";
    }
    
	/**	
	 *	Returns a string containing all the members details in the gym whose BMI category(based
	 * 	on the latest assessment weight) partially or entirely matches the entered category. If there
	 * 	are no members in the gym, return a message indicating this. If there are members in the
	 * 	gym, but none have a current BMI category matching the selected category, return a
	 * 	message indicating this also.
	 */
    public String listMembersBySpecificBMICategory (String category){

    	if(!members.isEmpty()){
    		String memberPrintout = "";
    		for(Member cperson: members){
    			if(cperson.determineBMIcategroy(cperson.calculateBMI(cperson.getStartingWeight())).contains(category)){
        			memberPrintout += cperson+"\n";
    			}
    		}
    		if(memberPrintout.length() > 5)
    			return memberPrintout;
    		else{
    			return "There are no members with the Specified category.";
    		}
    	}else{
    		return "No Members!"; 
    	}
    	
    }
    
    /** 
     *	List, for each member, their latest assessment weight and their height both imperially and
     * 	metrically. The format of the output is like so:
     * 	Joe Soap: xx kg (xxx lbs) x.x metres (xx inches).
     * 	Joan Soap: xx kg (xxx lbs) x.x metres (xx inches).
     * 	If there are no members in the gym, the message "There are no members in the gym" should be returned.
     */
    public String listMemberDetailsImperialAndMetric(){
    	//Not Done
     }
    
    
    /**
     *  Reads the associated XML file and pops the members and trainers into their associated array lists. 
     */
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("xml.xml"));
        members = (ArrayList<Member>) is.readObject();
        trainers = (ArrayList<Trainer>) is.readObject();
        is.close();
    }

    /**
     *  Pushes the members and trainers array lists out the associated XML file. 
     */ 
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("xml.xml"));
        out.writeObject(members);
        out.writeObject(trainers);
        out.close();    
    }
}
