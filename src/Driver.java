
/**
 * Driver class
 * @author Francisco Igor <franciscoigor@gmail.com>
 *
 */
public class Driver {

	/**
	 * Main program
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*** Prints model1 without initialization ***");
		Model model1=new Model();
		model1.printDetails();
		
		System.out.println("*** Prints model2 with full initialization ***");
		Model model2=new Model("Susan","Smith",70,120,true,false);
		model2.printDetails();

		System.out.println("*** Prints model3 with partial initialization ***");
		Model model3=new Model("Susan","Smith",70,120);
		model3.printDetails();
		
		System.out.println("*** Set all properties of model1 manually ***");
		model1.setFirstName("Susan");
		model1.setLastName("Smith");
		model1.setHeight(70);
		model1.setWeight(120.0);
		model1.setCanTravel(true);
		model1.setSmokes(false);
		model1.printDetails();
		
		System.out.println("*** Seting invalid properties, so the model will be without changes ***");
		model1.setFirstName("Ho"); //name less than 3 characters
		model1.setFirstName("VeryLargeNameForAModel"); //name more than 20 characters 
		model1.setHeight(20); //height less than 24
		model1.setHeight(90); //height more than 84
		model1.setWeight(77.0); //weight less than 80
		model1.setWeight(299.0); //weight more than 280
		model1.printDetails();
		
		System.out.println("*** Display model details, default system");
		model2.displayModelDetails();
		System.out.println("*** Display model details, metric system disabled (same as previous one)");
		model2.displayModelDetails(false);
		System.out.println("*** Display model details, metric system enabled ");
		model2.displayModelDetails(true);
		
		System.out.println("*** Model2 gains weight, so is not thin, hourly wage decreases***");
		model2.setWeight(Model.THIN_POUNDS+1);
		model2.displayModelDetails();

		System.out.println("*** Model2 cannot travel now, hourly wage decreases***");
		model2.setCanTravel(false);
		model2.displayModelDetails();

		System.out.println("*** Model2 is smoking now, hourly wage decreases ***");
		model2.setSmokes(true);
		model2.displayModelDetails();
		
		System.out.println("*** Testing model in feet and inches ***");
		model3.setHeight(12, 0);
		System.out.println(model3.getHeight());
		System.out.println(model3.getHeightInFeetAndInches());
		
		model3.setHeight(12, 1);
		System.out.println(model3.getHeight());
		System.out.println(model3.getHeightInFeetAndInches());
		
		model3.setHeight(12, 4);
		System.out.println(model3.getHeight());
		System.out.println(model3.getHeightInFeetAndInches());
	}

}
