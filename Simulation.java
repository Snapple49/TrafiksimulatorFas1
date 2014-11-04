import java.util.Scanner;
public class Simulation {

public static TrafficSystem enterValues() {
	int intensity = 0;
	int leftIntensity = 0;
	int period = 0;
	int greenPeriodStraight = 0;
	int greenPeriodTurn = 0;
	int r0 = 0;
	int r1 = 0;
	int r2 = 0;
	
	
	Scanner sc = new Scanner(System.in);
	do{
		try {
			System.out.println("Please enter intensity: \n");
			intensity = sc.nextInt();
		}
		catch (java.util.InputMismatchException e) {
		}
		sc.nextLine();
		System.out.println("Must be between 0 and 11");
		intensity = 0;
	} while (intensity < 0 || intensity > 10);

	
	System.out.println("Please enter leftIntensity: \n");
	leftIntensity = sc.nextInt();
	
	System.out.println("Please enter period: \n");
	period = sc.nextInt();
	while(0 >= period){
		System.out.println("Must be larger than 0");
		period = sc.nextInt();
	}
	
	System.out.println("Please enter green period for straight: \n");
	greenPeriodStraight = sc.nextInt();
	while(0 >= greenPeriodStraight || greenPeriodStraight >= period){
		System.out.println("Must be larger than 0 and smaller than period");
		greenPeriodStraight = sc.nextInt();
	}
	
	System.out.println("Please enter green period for turning: \n");
	greenPeriodTurn = sc.nextInt();
	while(0 >= greenPeriodTurn || greenPeriodTurn >= period){
		System.out.println("Must be larger than 0 and smaller than period");
		greenPeriodTurn = sc.nextInt();
	}
	
	System.out.println("Please enter length of first part of lane: \n");
	r0 = sc.nextInt();
	while(0 >= r0){
		System.out.println("Must be larger than 0");
		r0= sc.nextInt();
	}
	
	System.out.println("Please enter length of second part of lane: \n");
	r1 = sc.nextInt();
	while(0 >= r1){
		System.out.println("Must be larger than 0");
		r1 = sc.nextInt();
	}
	r2 = r1;
	
	return new TrafficSystem(intensity, leftIntensity, period, greenPeriodStraight, greenPeriodTurn, r0, r1);	
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
			break;
		case 2:
			TrafficSystem ts2 = new TrafficSystem();
			testSimulate(ts2);
			break;
		case 3:
			break;
    	}
    	
    
    	
    	

    }
}
