/*
 * This is a class which is a Subclass of Member.
 * @version 1
 * @author Marcel Kowalik
 */

public class Trainer extends Person {
   private String speciality;
   
   
   //Constructor
	public  Trainer(String email, String name, String address, String gender, String speciality)
	{
		super(email, name, address, gender);
		this.setSpeciality(speciality);
	}

	/*
	 * Setters and Getters.
	 */
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	 
	/*
	 * toString of all the information of the Trainer.
	 */
	public String toString() {
		return     			"StudentMember [" +
				"Email: " + getEmail() + 
				", Name:" + getName() + 
				 " ("+getGender()+")" + 
				", Address:" + getAddress() +"." + 
				 "Speciality:" + speciality +"."+ 
				"]";
	}
}
