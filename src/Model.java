/**
 * Model Class
 * @author Francisco Igor <franciscoigor@gmail.com>
 *
 */
public class Model {
	
	public static final int INCHES_PER_FOOT = 12;
	public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
	public static final int TALL_INCHES = 67;
	public static final double THIN_POUNDS = 140.0;
	public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
	public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
	public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;
	
	public static final double INCHES_TO_CENTIMETERS=2.54d;
	public static final double POUNDS_TO_KILOGRAMS=0.453592d;
	
	
	private String firstName;
	private String lastName;
	private int height;
	private double weight;
	private boolean canTravel;
	private boolean smokes;
	private static String occupation="modeling"; 
	

	/**
	 * Default constructor.
	 * Does not initialize any attribute.
	 */
	public Model(){
		
	}
	
	
	/**
	 * Model constructor with all parameters
	 * @param firstName First name of model
	 * @param lastName Last name of model
	 * @param height Height of model in inches
	 * @param weight Weight of model in pounds
	 * @param canTravel Indicator if the model can travel
	 * @param smokes Indicator if the model smokes
	 */
	public Model(String firstName,String lastName,int height,double weight,boolean canTravel,boolean smokes){
		
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setHeight(height);
		this.setWeight(weight);
		this.setCanTravel(canTravel);
		this.setSmokes(smokes);
	}
	
	/**
	 * Model constructor with all parameters except <code>canTravel</code> and <code>smoke</code> (<code>true</code> and <code>false</code> by default).
	 * @param firstName First name of model
	 * @param lastName Last name of model
	 * @param height Height of model in inches
	 * @param weight Weight of model in pounds
	 */
	public Model(String firstName,String lastName,int height,double weight){
		this(firstName,lastName,height,weight,true,false);
	}
	
	/**
	 * Sets the first name
	 * @param firstName first name of model
	 */
	public final void setFirstName(String firstName) {
		if (firstName!=null && firstName.length()>=3 && firstName.length()<=20){
			this.firstName = firstName;
		}
	}
	
	/**
	 * Gets the first name of model
	 * @return First Name of model
	 */
	public final String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the last name of model
	 * @param lastName Last name of model
	 */
	public final void setLastName(String lastName) {
		if (lastName.length()>=3 && lastName.length()<=20){
			this.lastName = lastName;
		}
		
	}
	
	/**
	 * Gets the last name of model
	 * @return Last Name of model
	 */
	public final String getLastName() {
		return lastName;
	}

	
	/**
	 * Sets the height of the model 
	 * @param height Height of model in inches
	 */
	public final void setHeight(int height){
		if (height>=24 && height<=84){
			this.height = height;
		}
	}
	
	/**
	 * Gets the height of model
	 * @return Height of the model in inches
	 */
	public final int getHeight() {
		return height;
	}
	
	/**
	 * Sets the weight of model
	 * @param weight Weight in pounds
	 */
	public final void setWeight(double weight) {
		if (weight>=80 && weight<=280){
			this.weight = weight;
		}
	}
	
	/**
	 * Gets the weight of model
	 * @return Weight of the model in pounds
	 */
	public final double getWeight() {
		return weight;
	}
	
	/**
	 * Sets if model can travel
	 * @param canTravel Indicator to enable or disable travel
	 */
	public final void setCanTravel(boolean canTravel) {
		this.canTravel = canTravel;
	}
	
	/**
	 * Gets if model can travel
	 * @return True if model can travel, otherwise false
	 */
	public final boolean isCanTravel() {
		return canTravel;
	}
	
	/**
	 * Sets if model smokes
	 * @param smokes Indicator to enable or disable smoking
	 */
	public final void setSmokes(boolean smokes) {
		this.smokes = smokes;
	}
	
	/**
	 * Gets if model is smoking
	 * @return True or false if model is smoking
	 */
	public final boolean isSmokes() {
		return smokes;
	}
	
	/**
	 * Gets the current occupation
	 * @return Occupation of model
	 */
	public static String getOccupation() {
		return occupation;
	}
	
	/**
	 * Get the height using feet and inches.
	 * Example: 27 inches shows as 2 feet and 3 inches. 
	 * @return A text with the height in feet and inches
	 */
	public String getHeightInFeetAndInches(){
		long feet=height/INCHES_PER_FOOT;
		long inches=height%INCHES_PER_FOOT;
		String result=""+feet;
		result+=" feet";
		if (inches>0){
			result+=", ";
			result+=inches;
			if (inches==1){
				result+=" inch";
			}else{
				result+=" inches";			
			}
		}
		return result;
	}
	
	/**
	 * Get the weight in kilograms
	 * @return Weight in kilograms
	 */
	public long getWeightKg(){
		return Math.round((double)weight*POUNDS_TO_KILOGRAMS);
	}
	
	public long getHeightCentimeters(){
		return Math.round((double)height*INCHES_TO_CENTIMETERS);
	}
	
	/**
	 * Set the weight in kilograms, converting to pounds
	 * @param kilograms Weight in kilograms
	 */
	public final void setWeight(long kilograms){
		setWeight((double)kilograms*2.20462d);
	}
	
	/**
	 * Sets the height using feet and inches, converting to inches
	 * Example: setHeight(2, 3) sets 2*12 + 3 = 27 inches.
	 * @param feet Height feet
	 * @param inches Height inches
	 */
	public final void setHeight(int feet, int inches){
		this.height= feet*12+inches;
	}
	
	/**
	 * Prints details from model
	 */
	public void printDetails() {
		System.out.println("Name: " + getFirstName() + " " + getLastName());
		System.out.println("Height: " + getHeight() + " inches");
		System.out.println("Weight: " + Math.round(getWeight()) + " pounds");
		if(isCanTravel()){
			System.out.println("Does travel ");
		}else{
			System.out.println("Does not travel ");
		}
		if(isSmokes()){
			System.out.println("Does smoke ");
		}else{
			System.out.println("Does not smoke ");
		}
	}
	
	/**
	 * Calculates payment in dollars by hour.
	 * Uses <code>BASE_RATE_DOLLARS_PER_HOUR</code> as base amount.
	 * @see Model#BASE_RATE_DOLLARS_PER_HOUR 
	 * @return Hourly payment in dollars
	 */
	public int calculatePayDollarsPerHour(){
		int amount=BASE_RATE_DOLLARS_PER_HOUR;
		
		if (getHeight()>TALL_INCHES && getWeight()<THIN_POUNDS){
			amount+=TALL_THIN_BONUS_DOLLARS_PER_HOUR;
		}
		
		if (isCanTravel()){
			amount+=TRAVEL_BONUS_DOLLARS_PER_HOUR;
		}
		if (isSmokes()){
			amount-=SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
		}
		
		return amount;
	}
	
	/**
	 * Prints detailed information about the model
	 */
	public void displayModelDetails() {
		System.out.println("Name: " + getFirstName() + " " + getLastName());
		System.out.println("Height: " + getHeightInFeetAndInches());
		System.out.println(" Weight: " + getWeight() + " pounds");
		if(canTravel == true){
			System.out.println("Travels: yep");
		}else{
			System.out.println("Travels: nope");
		}
		if(smokes == true){
			System.out.println("Smokes: yep");
		}else{
			System.out.println("Smokes: nope");
		}
		System.out.println("Hourly rate: "+calculatePayDollarsPerHour());
	}
	
	/**
	 * Prints detailed information about the model
	 * @param metricUnits Enable to show metric units (centimeters and kilograms)
	 */
	public void displayModelDetails(boolean metricUnits) {
		
		System.out.println("Name: " + getFirstName() + " " + getLastName());
		if (metricUnits){
			System.out.println("Height: " + getHeightCentimeters() + " cms.");
		}else{
			System.out.println("Height: " + getHeightInFeetAndInches());
		}
		if (metricUnits){
			System.out.println(" Weight: " + getWeightKg() + " kgs.");
		}else{
			System.out.println(" Weight: " + getWeight() + " pounds");
		}
		if(canTravel == true){
			System.out.println("Travels: yep");
		}else{
			System.out.println("Travels: nope");
		}
		if(smokes == true){
			System.out.println("Smokes: yep");
		}else{
			System.out.println("Smokes: nope");
		}
		System.out.println("Hourly rate: "+calculatePayDollarsPerHour());
	}

}
