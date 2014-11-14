import java.util.Scanner;
// TODO: Auto-generated Javadoc
/**Simulation program for gathering test data from a traffic situation. Enter data yourself, use standard data or read data for a file for your traffic system. 
 * 
 *  
 * @author Oliver & Alex
 *
 */


public class Simulation {

	
/**
 * Request the user to enter max time, and if something that is not an int is entered, the user will have to try again.  
 *
 * @return the max time entered by the user. 
 */
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
	return time;
	
}
	


	
/**
 * Simulates the system. It prints out the current statistics before stepping the system one step. 
 *
 * @param system the traffic system. 
 */
public static void simulate(TrafficSystem system) {
		System.out.print(system.toString());
		system.step();
		System.out.print("\n-----------------------" + system.getTime() + "-----------------------\n");
	}


    /**
     * The main method. Asks the user for which method (1 = Enter them yourself, 2 = Default values, 3 = Read them from a file) of entering the values and starts the simulation. 
     *
     * @param args the arguments
     */
    public static void main(String [] args) {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	
    	do{
    		try {
    			System.out.println("Please enter how you want to enter the values for the simulation:\n1: Enter them yourself.\n2: Use standard values.\n3: Read them from a file.");
        		choice = sc.nextInt();
    		}
    		catch (java.util.InputMismatchException e) {
    		}
    		sc.nextLine();
    	} while (choice <= 0 || choice > 3);
    	
    	int maxTime = enterMaxTime();
    	TrafficSystem ts = TrafficSystem.readParameters(choice);
    	while(ts.getTime() < maxTime) {
			simulate(ts);
			ts.printStatistics();
		}
    	sc.close();	
    }
    
    
}
