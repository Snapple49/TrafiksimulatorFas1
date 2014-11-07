import java.util.Scanner;
/**Simulation program for gathering test data from a traffic situation. Enter data yourself, use standard data or read data for a file for your traffic system. 
 * 
 *  
 * @author Oliver & Alex
 *
 */
public class Simulation {


private	static int maxTime = 0;
	
private static void enterMaxTime() {
	Scanner sc = new Scanner(System.in);
	do{
		try {

			System.out.println("Please enter time for how long you want to simulate (in seconds) (must be larger than 0). \n");
			maxTime = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		System.out.println("Not a number!");
		sc.nextLine();
		maxTime = 0;
		}
	} while (maxTime <= 0);
	sc.close();
	
}
	


	
public static void testSimulate(TrafficSystem ts) {
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
		ts.step();
		System.out.print(ts.toString());
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
			testSimulate(ts1);
			int time = 10;
			while(ts1.getTime() < time)
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
