/*
 * This is a class that is the Subclass of Person. Stores additional data and a hashMap to record all members progress.
 * @version 1
 * @author Marcel Kowalik
 */

import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;


public abstract class Member extends Person {
	
	private double height = 1;
	private double startingWeight = 35.0;
	private String chosenPackage;
	private HashMap<Date, Assessment> progressMap;
	
	//Constructor
	public  Member(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage)
	{
		super(email, name, address, gender);
		setHeight(height);
		this.startingWeight = startingWeight;
		setStartingWeight(height);
		this.chosenPackage = chosenPackage;

	}
	
	/*
	 *	Setters and Getters.
	 */
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height >= 1 && height <= 3){
			this.height = height;
		}
	}
	public double getStartingWeight() {
		return startingWeight;
	}
	public void setStartingWeight(double startingWeight) {
		if(startingWeight >= 35 && startingWeight <= 250){
			this.startingWeight = startingWeight;
		}
	}
	public String getChosenPackage() {
		return chosenPackage;
	}
	public void setChosenPackage(String chosenPackage) {
		this.chosenPackage = chosenPackage;
	}
	public HashMap<Date, Assessment> getProgressMap() {
		return progressMap;
	}
	public void setProgressMap(HashMap<Date, Assessment> progressMap) {
		this.progressMap = progressMap;
	}
	public double calculateBMI(double weight){
		return startingWeight/Math.pow(height, 2);
	}
	public String determineBMIcategroy(double bmiValue){
		if(bmiValue < 15){ return  "VERY SEVERELY UNDERWEIGHT";}
		else if(bmiValue >= 15 && bmiValue < 16){ return "SEVERELY UNDERWEIGHT" ;}
		else if(bmiValue >= 16 && bmiValue < 18.5){ return "UNDERWEIGHT" ;}
		else if(bmiValue >= 18.5 && bmiValue < 25){ return  "NORMAL" ;}
		else if(bmiValue >= 25 && bmiValue < 30){ return  "OVERWEIGHT" ;}
		else if(bmiValue >= 30 && bmiValue < 35){ return "MODERATELY OBESE" ;}
		else if(bmiValue >= 35 && bmiValue < 40){ return "SEVERELY OBESE";}
		else{ return "VERY SEVERELY OBESE"; } 
	}
	
	//Returns the latest assessment based on last entry (by calendar date).
	public Assessment latestAssessment() {
		return getAssessments().get(sortedAssessmentDates().last());
	}
	
	//Returns the assessment dates sorted in date order.
	public SortedSet<Date> sortedAssessmentDates() {
		 return new TreeSet<Date>(getAssessments().keySet());	 
	}
	private HashMap<Date, Assessment> getAssessments() {
		return progressMap;
	}

	/**
	 * 	This method returns a boolean to indicate if the member has an ideal
	 * 	body weight based on the Devine formula.
	 *
	 * 	<pre>
	 * 	For males, an ideal body weight is: 50 kg + 2.3 kg for each inch
	 * 	over 5 feet.
	 * 	For females, an ideal body weight is: 45.5 kg + 2.3 kg for each inch
	 * 	over 5 feet.
	 *
	 * 	Note: if no gender is specified, return the result of the female
	 * 	calculation.
	 *
	 * 	</pre>
	 *
	 * 	@param weight The member’s weight, measured in KGs
	 * 	@return Returns true if the result of the devine formula is within 2
	 * 	kgs (inclusive) of the starting weight;
	 * 	false if it is outside this range.
	 */
	 public boolean isIdealBodyWeight(double weight)
	 {
		 double fiveFeet = 60.0;
		 double idealBodyWeight;
		 double inches = convertMetersToInches(height); //write a method that converts weight passed as a
		 //parameter from kg to inches
	
		 if (inches <= fiveFeet){
		 if (getGender().equals("M")){
		 idealBodyWeight = 50;
		 }
		 else{ 
		 idealBodyWeight = 45.5;
		 }
		 }
		 else{
		 if (getGender().equals("M")){
		 idealBodyWeight = 50 + ((inches - fiveFeet) * 2.3);
		 }
		 else{
		 idealBodyWeight = 45.5 + ((inches - fiveFeet) * 2.3);
		 }
		 }
	
		 return ( (idealBodyWeight <= (weight + 2.0))
		 && (idealBodyWeight >= (weight - 2.0))
		 );

	 }
	 
	 /*
	  * Converts meters into inches
	  */
	 private double convertMetersToInches(double meters){
		 return meters* 39.3700787;
	 }

		/*
		 * toString of all the information of the Member.
		 */
	public String toString() {
		return     			"StudentMember [" +
				"Email: " + getEmail() + 
				", Name:" + getName() + 
				 " ("+getGender()+")" + 
				", Address:" + getAddress() +"." + 
				"\n\tHeight: "+ height + " metres" +
	            ",  Starting Weight: " + startingWeight + " kgs" +
	            ", Chosen Package=" + getChosenPackage()
	            + "]";
	}
	 
	 
}
