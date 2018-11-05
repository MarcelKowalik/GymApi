/*
 * This is a class which is a Subclass of Member and it does not store additional data.
 * @version 1
 * @author Marcel Kowalik
 */

import java.util.HashMap;

public class PremiumMember extends Member {
	
	//Constructor
	public PremiumMember(String email, String name, String address, String gender, float height, double startingWeight,
			String chosenPackage)
	{
		super(email, name, address, gender, height, startingWeight, chosenPackage);
	}

	/**
	 * 	Provides the concrete implementation for this method. The chosenPackage is set to the
	 * value passed as a parameter. There is no validation on the entered data.
	 */
	public void chosenPackage(String packageChoice){
		setChosenPackage(packageChoice);
	}
}
