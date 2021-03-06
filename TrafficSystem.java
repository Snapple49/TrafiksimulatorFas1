import java.util.Scanner;
import java.util.Properties;
import java.util.InputMismatchException;


/**
 * The Class TrafficSystem represents the actual traffic system with all components. It contains methods for stepping the whole system forward in time, different ways of creating a TrafficSystem object and gathering and printing statistics for cars in the system.
 * 
 * @author Oliver Stein & Alexander Lind
 * 
 */
	
public class TrafficSystem {


	/** The first lane. */
	private Lane  firstLane;

	/** The straight lane. */
	private Lane  straightLane;

	/** The left lane. */
	private Lane  leftLane;

	/** The straight light. */
	private Light straightLight;

	/** The left light. */
	private Light leftLight;

	/** The intensity. New car should arrive when time % intensity = 0 */
	private int intensity;

	/** The left intensity is the statistical chance of a car having the destination left. Negative leftIntensity is the reciprocal, so every n:th car goes straight instead with negative leftIntensity*/
	private int leftIntensity;

	/** The total cars in. */
	private int totalCarsIn;
	
	/** The total cars out. */
	private float totalCarsOut;

	/** The sum of total time all cars have spent in system. */
	private float totalTime;


	/** The maximal time a car spent in system.  */
	private int maxTime;

	/** The time of the TrafficSystem. */
	private int time = 0;

	/**
	 * Instantiates a new traffic system with preset default values.
	 */
	public TrafficSystem() { 
		firstLane = new Lane(20);
		straightLane = new Lane(5);
		leftLane = new Lane(5);
		straightLight = new Light(10, 3);
		leftLight = new Light(10, 5);
		intensity = 2;
		leftIntensity = 3;
	}

	/**
	 * Instantiates a new traffic system with values from an integer array.
	 *
	 * @param arr the integer array with values for TrafficSystem 
	 */
	public TrafficSystem(int[] arr) {
		intensity = arr[0];
		leftIntensity = arr[1];
		straightLight = new Light(arr[2], arr[3]);
		leftLight = new Light(arr[2], arr[4]);
		firstLane = new Lane(arr[5]);
		straightLane = new Lane(arr[6]);
		leftLane = new Lane(arr[6]);
	}

	/**
	 * Reads parameters for a simulation from standard input stream, and sets the TrafficSystem object's values to these parameters.
	 */
	public void enterValues() {
		int intensity = 0;
		int leftIntensity = 0;
		int leftIntensityNumerical = 0;
		int period = 0;
		int greenPeriodStraight = 0;
		int greenPeriodTurn = 0;
		int longLane = 0;
		int shortLane = 0;

		Scanner sc = new Scanner(System.in);

		do{
			try {

				System.out.println("Please enter intensity (must be between 0 and 11). \n");
				intensity = sc.nextInt();
			}
			catch (InputMismatchException e) {
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
			catch (InputMismatchException e) {
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
			catch (InputMismatchException e) {
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
			catch (InputMismatchException e) {
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
			catch (InputMismatchException e) {
				System.out.println("Not a number!");
				sc.nextLine();
				greenPeriodTurn = 0;
			}
		} while (greenPeriodTurn <= 0 || greenPeriodTurn >= period);

		do{
			try {

				System.out.println("Please enter length of first part of lane (must be larger than 0). \n");
				longLane = sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Not a number!");
				sc.nextLine();
				longLane = 0;
			}
		} while (longLane <= 0);

		do{
			try {

				System.out.println("Please enter length of second part of lane (must be larger than 0). \n");
				shortLane = sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Not a number!");
				sc.nextLine();
				shortLane = 0;
			}
		} while (shortLane <= 0);

		this.intensity = intensity;
		this.leftIntensity = leftIntensity;
		this.straightLight = new Light(period, greenPeriodStraight);
		this.leftLight = new Light(period, greenPeriodTurn);
		this.firstLane = new Lane(longLane);
		this.straightLane = new Lane(shortLane);
		this.leftLane = new Lane(shortLane);

	}

	/**
	 * Creates a new TrafficSystem object. Depending on the input, the values of the object's fields are determined either with enterValues method or reading the config.properties file with getPropValues method, or just with the constructor default values.
	 *
	 * @param input the input determines how to construct the TrafficSystem: 1 for entering values, 2 for reading from file, otherwise default constructor.
	 * @return TrafficSystem object created by using specified method.
	 */
	public static TrafficSystem readParameters(int input) {

		switch (input) {
		case 1:
			TrafficSystem ts = new  TrafficSystem();
			ts.enterValues();
			return ts;

		case 3:
			GetPropertyValues property = new GetPropertyValues();
			int[] propArray = property.getPropValues();
			return new TrafficSystem(propArray);


		default:
			return new TrafficSystem();
		}
	}


	/**
	 * Gets the time of the TrafficSystem.
	 *
	 * @return the time in integer form.
	 */
	public int getTime(){
		return this.time;
	}

	/**
	 * Steps all components of the system forwards in timeline, adds new Car objects to the system as specified and creates statistical data. Uses components' native step methods.
	 */
	public void step() {
		Car statCar1 = null;
		Car statCar2 = null;

		time++;
		straightLight.step();
		leftLight.step();
		boolean green1 = straightLight.isGreen();
		boolean green2 = leftLight.isGreen();

		if (green1) {
			statCar1 = straightLane.getFirst();
		}
		straightLane.step(green1);

		if (green2) {
			statCar2 = leftLane.getFirst();
		}
		leftLane.step(green2);

		if(!(firstLane.posFree(0))){
			switch (firstLane.firstCar().getDest()) {
			case 1: 
				if(straightLane.lastFree()){
					straightLane.putLast(firstLane.getFirst());
					firstLane.step();
				}else{
					firstLane.step(false);
				}
				break;

			case 2:
				if(leftLane.lastFree()){
					leftLane.putLast(firstLane.getFirst());
					firstLane.step();
				}else{
					firstLane.step(false);
				}
				break;

			}

		}else{    		
			firstLane.step();
		}    	
		if(time % intensity == 0){
			totalCarsIn++;
			try{
				int nextDest = (int ) (Math.random()*leftIntensity) + 1;
				if(leftIntensity > 0){
					if(nextDest == leftIntensity){
						Car nextCar = new Car(this.time, 2);    				
						firstLane.putLast(nextCar);
					}else{
						Car nextCar = new Car(this.time, 1);    				    				
						firstLane.putLast(nextCar);
					}
				}else if(leftIntensity == 0){
					Car nextCar = new Car(this.time, 1);    				    				
					firstLane.putLast(nextCar);
				}else{
					if(nextDest == leftIntensity){
						Car nextCar = new Car(this.time, 1);    				
						firstLane.putLast(nextCar);
					}else{
						Car nextCar = new Car(this.time, 2);    				    				
						firstLane.putLast(nextCar);
					}
				}
			}
			catch (Lane.LaneOverflowException e){
				throw new RuntimeException("Long lane overloaded, cars cannot enter");
			}
		}
		updateStatsCar(statCar1);
		updateStatsCar(statCar2);
	}

	private void updateStatsCar(Car statCar) {
		if (statCar != null) {
			this.writeStatistics(statCar);
			this.totalCarsOut++;
		}
	}

	/**
	 * Updates the total time cars has spent in the current TrafficSystem object.
	 *
	 * @param car the Car object whose time spent in the system is checked.
	 */
	public void writeStatistics(Car car) {

		int carTime = this.time - car.getBornTime();
		this.totalTime += carTime;
		if (this.maxTime < carTime) {
			this.maxTime = carTime;
		}
	}
	
	/**
	 * Gets the statistics of the traffic system as a Number array. Indexes 0-3;
	 * 0 is totalCarsIn, 
	 * 1 is totalCarsOut, 
	 * 2 is maxTime,
	 * 3 is totalTime
	 *
	 * @return the statistics as a Number array.
	 */
	protected Number[] getStatistics() { 
		Number[] stats = new Number[4];
		stats[0] = this.totalCarsIn;
		stats[1] = (int) this.totalCarsOut;
		stats[2] = this.maxTime;
		stats[3] = this.totalTime;
		return stats;
	}

	/**
	 * Prints the statistics to standard out stream.
	 */
	public void printStatistics() {
		System.out.println("Statistics:");
		if (this.totalCarsOut == 0) {
			System.out.println("No cars have left the system.");
		}
		else {
			System.out.println("Average time: " + (this.totalTime / this.totalCarsOut));
			System.out.println("Max time spent in system: " + this.maxTime);
			System.out.println("Number of Cars that have entered the system: " + this.totalCarsIn);
			System.out.println("Number of Cars that have left the system: " + (int) this.totalCarsOut);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() { //mal = polymorfism
		return "r0 = " + this.firstLane.toString() + "\nr1= " + this.straightLane.toString() + "\nr2= " + this.leftLane.toString() + "\ns1= " + this.straightLight.toString() + "\ns2= " + this.leftLight.toString() + ")";
	}

}
