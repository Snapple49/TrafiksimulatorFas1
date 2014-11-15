import java.util.Scanner;

/** Class for starting and maintaining a simulation of a traffic system with TrafficSystem objects. Has methods for handling input for starting a simulation and running the simulation.
 * 
 *  
 * @author Oliver Stein & Alexander Lind
 *
 */


abstract class Simulation {

	
/**
 * Request the user to enter maximum time to run simulation for, will retry until a number above 0 is written.  
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
 * Simulates the system by printing out the current statistics and stepping the system one step. 
 *
 * @param system the TrafficSystem to simulate. 
 */
public static void simulate(TrafficSystem system) {
		System.out.print(system.toString());
		system.step();
		System.out.print("\n-----------------------" + system.getTime() + "-----------------------\n");
	}


    /**
     * The main method. Asks the user for which method (1 = Enter them yourself, 2 = Default values, 3 = Read them from a file) of entering the values and starts the simulation.
     */
    public static void main() {
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
		}
    	ts.printStatistics();
    	sc.close();	
    }
    
    
}
