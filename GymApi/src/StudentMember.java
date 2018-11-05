/*
 * This is a class which is a subclass of member and stores additional data.
 * @version 1
 * @author Marcel Kowalik
 */

import java.util.Date;
import java.util.HashMap;

public class StudentMember extends Member {
	
	private String studentId;
	private String collegeName;
	
	//Constructor
	public StudentMember(String email, String name, String address, String gender, double height, double startingWeight, 
			 String studentId, String collegeName, String chosenPackage) 
	{
		super(email, name, address, gender, height, startingWeight, chosenPackage);
		if(studentId.length() <= 6){
			this.studentId = studentId;
		}
		else { 
			studentId = studentId.substring(0, 6);
			this.studentId = studentId;
			
		}
		this.collegeName = collegeName;
	
		
	/*
	* 	Setters and Getters.
	*/
		
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		if(studentId.length() <= 6){
			this.studentId = studentId;
		}
		else{
			this.studentId = studentId.substring(0, 6);
		}
	}
	
	
	/**
	 * 	Provides the concrete implementation for this method. The chosenPackage is set to the
	 *  package associated with their collegeName. If there is no package associated with their
	 *  college, default to “Package 3”
	 */
	public void chosenPackage(){
		if(MenuController.collegesAndAssociations.containsKey(collegeName)){
			setChosenPackage(MenuController.collegesAndAssociations.get(collegeName));
		}
		else{
			setChosenPackage("Package 3");
		}

	}

	public HashMap<Date, Assessment> setAssessments(HashMap<Date, Assessment> assessments) {
		return assessments;
	}
	
	/*
	 * toString of all the information of the Student Member.
	 */
	public String toString() {
		return     			"StudentMember [" +
				"Email: " + getEmail() + 
				", Name:" + getName() + 
				 " ("+getGender()+")" + 
				", Address:" + getAddress() +"." + 
				"\n\tHeight: "+ getHeight() + " metres" +
	            ",  Starting Weight: " + getStartingWeight() + " kgs" +
	            ", StudentId=" + getStudentId() + 
	            " , College Name=" + collegeName + 
	            ", Chosen Package=" + getChosenPackage()
	            + "]";
	}
}
