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
 * Enter max time.
 *
 * @return the int
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
 * Simulate.
 *
 * @param ts the ts
 */
public static void simulate(TrafficSystem ts) {
		System.out.print(ts.toString());
		ts.step();
		System.out.print("\n-----------------------" + ts.getTime() + "-----------------------\n");
	}


    /**
     * The main method.
     *
     * @param args the arguments
     */
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
    	
    	TrafficSystem ts;
    	int maxTime = enterMaxTime();
    	switch (choice) {
		case 1:
			ts = TrafficSystem.readParameters(1);;
			while(ts.getTime() < maxTime) {
				simulate(ts);
				ts.printStatistics();
			}
			break;

		case 2:
			ts = new TrafficSystem();			
			while(ts.getTime() < maxTime) {
				simulate(ts);
				ts.printStatistics();
			}
			break;
		case 3:
			ts = TrafficSystem.readParameters(2);
			while(ts.getTime() < maxTime) {
				simulate(ts);
				ts.printStatistics();
			}
			break;
    	}
    	
    	sc.close();	
    }
    
    
}
