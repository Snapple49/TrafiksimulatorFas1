import java.util.Scanner;
/**Simulation program for gathering test data from a traffic situation. Enter data yourself, use standard data or read data for a file for your traffic system. 
 * 
 *  
 * @author Oliver & Alex
 *
 */


public class Simulation {


public static TrafficSystem enterValues() {
	int intensity = 0;
	int leftIntensity = 0;
	int leftIntensityNumerical = 0;
	int period = 0;
	int greenPeriodStraight = 0;
	int greenPeriodTurn = 0;
	int r0 = 0;
	int r1 = 0;
	
	Scanner sc = new Scanner(System.in);

	do{
		try {

			System.out.println("Please enter intensity (must be between 0 and 11). \n");
			intensity = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		intensity = 0;
		}
	} while (intensity <= 0 || intensity > 10);

	do{
		try {
			sc.nextLine();
			System.out.println("Please enter leftIntensity.\n");
			leftIntensity = sc.nextInt();
			leftIntensityNumerical = 1;
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		leftIntensity = 0;
		leftIntensityNumerical = 0;
		}
	} while (leftIntensityNumerical == 0);
	
	do{
		try {

			System.out.println("Please enter period (must be larger than 1). \n");
			period = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		period = 0;
		}
	} while (period <= 1);
	
	do{
		try {

			System.out.println("Please enter green period for straight (must be larger than 0 and smaller than period). \n");
			greenPeriodStraight = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		greenPeriodStraight = 0;
		}
	} while (greenPeriodStraight <= 0 || greenPeriodStraight >= period);
	
	do{
		try {

			System.out.println("Please enter green period for turning (must be larger than 0 and smaller than period). \n");
			greenPeriodTurn = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		greenPeriodTurn = 0;
		}
	} while (greenPeriodTurn <= 0 || greenPeriodTurn >= period);
	
	do{
		try {

			System.out.println("Please enter length of first part of lane (must be larger than 0). \n");
			r0 = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		r0 = 0;
		}
	} while (r0 <= 0);
	
	do{
		try {

			System.out.println("Please enter length of second part of lane (must be larger than 0). \n");
			r1 = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		r1 = 0;
		}
	} while (r1 <= 0);
	
	return new TrafficSystem(intensity, leftIntensity, period, greenPeriodStraight, greenPeriodTurn, r0, r1);	
}

	
public static int enterMaxTime() {
	Scanner sc = new Scanner(System.in);
	int time;
	do{
		try {
			
			System.out.println("Please enter time for how long you want to simulate (in seconds) (must be larger than 0). \n");
			time = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		time = 0;
		}
	} while (time <= 0);
	sc.close();
	return time;
	
}
	


	
public static void testSimulate(TrafficSystem ts) {
		System.out.print(ts.toString());
		ts.step();
		System.out.print("\n-----------------------------------------------------------\n");
	}


    public static void main(String [] args) {
	// Skapar ett TrafficSystem
	// Utför stegningen, anropar utskriftsmetoder
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	do{
    		try {
    			System.out.println("Please enter how you want to enter the values for the simulation:\n1: Enter them yourself.\n2: Randomize them\n3: Read them from a file.");
        		choice = sc.nextInt();
    		}
    		catch (java.util.InputMismatchException e) {
    		}
    		sc.nextLine();
    	} while (choice <= 0 || choice > 3);
    	
    	switch (choice) {
		case 1:
			TrafficSystem ts1 = enterValues();
			int maxTime = enterMaxTime();
			while(ts1.getTime() < maxTime) {
				testSimulate(ts1);
				ts1.printStatistics();
			}
			break;
		case 2:
			TrafficSystem ts2 = new TrafficSystem();
			testSimulate(ts2);
			break;
		case 3:
			break;
    	}
    	
    
    	
    	
    	sc.close();	
    }
    
    
}
