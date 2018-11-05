/*
 * This is a abstract class that stores all information about each trainer and member.
 * @version 1
 * @author Marcel Kowalik
 */

public abstract class Person {

	private String name;
	private String email;
	private String address;
	private String gender;

	//Constructor
	public Person(String email, String name, String address, String gender){
		if (name.length() <= 30){
			this.name=name;
		}
		else{
			name = name.substring(0, 30);
			this.name=name;
		}
		this.email = email;
		this.address = address;
		setGender(gender);
	}
	
	/*
	 * Setters and Getters.
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() <= 30){
			this.name = name;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if(gender.charAt(0) == 'm' || gender.charAt(0) == 'M' || gender.charAt(0) == 'f' || gender.charAt(0) == 'F'){
			this.gender = gender.charAt(0)+"";
		}
	}
	/*
	 * toString of all the information of the Person.
	 */
	public String toString() {
		return     			"StudentMember [" +
				"Email: " + email + 
				", Name:" + name + 
				 " ("+gender+")" + 
				", Address:" + address +"." + 
				"]";
	}
}
