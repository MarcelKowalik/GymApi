/*
 * This is a class that stores the assessment details.
 * @version 1
 * @author Marcel Kowalik
 */

public class Assessment {

	private double weight = 35;
	private double chestMeasure = 0;
	private double thighMeasure = 0;
	private double upperArmMeasure = 0;
	private double waistMeasure = 0;
	private double hipMeasure = 35;
	private String comment;
	private Trainer trainer;
	
	//Constructor
	public Assessment(double weight, double chestMeasure, double thighMeasure, double upperArmMeasure,
			double waistMeasure, double hipMeasure, String comment, Trainer trainer) {
			setWeight(weight);
			this.chestMeasure = chestMeasure;
			this.thighMeasure = thighMeasure;
			this.upperArmMeasure = upperArmMeasure;
			this.waistMeasure = waistMeasure;
			setHipMeasure(hipMeasure);
			this.comment = comment;
			this.trainer = trainer;
	}
	
	/**
	 *	Setters and Getter
	 */
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if (weight >= 35 && weight <= 250){
			this.weight = weight;
		}
	}
	public double getChestMeasure() {
		return chestMeasure;
	}
	public void setChestMeasure(double chestMeasure) {
		this.chestMeasure = chestMeasure;
	}
	public double getThighMeasure() {
		return thighMeasure;
	}
	public void setThighMeasure(double thighMeasure) {
		this.thighMeasure = thighMeasure;
	}
	public double getUpperArmMeasure() {
		return upperArmMeasure;
	}
	public void setUpperArmMeasure(double upperArmMeasure) {
		this.upperArmMeasure = upperArmMeasure;
	}
	public double getWaistMeasure() {
		return waistMeasure;
	}
	public void setWaistMeasure(double waistMeasure) {
		this.waistMeasure = waistMeasure;
	}
	public double getHipMeasure() {
		return hipMeasure;
	}
	public void setHipMeasure(double hipMeasure) {
		if(hipMeasure >= waistMeasure)
		this.hipMeasure = hipMeasure;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/*
	 * toString of all the information of the Assessment.
	 */
	public String toString() {
		return "Assessment [weight=" + weight + ", chestMeasure=" + chestMeasure + ", thighMeasure=" + thighMeasure
				+ ", upperArmMeasure=" + upperArmMeasure + ", waistMeasure=" + waistMeasure + ", hipMeasure="
				+ hipMeasure + ", comment=" + comment + ", trainer=" + trainer + "]";
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
