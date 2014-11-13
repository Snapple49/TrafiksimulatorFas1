import java.util.Scanner;
import java.util.Properties;
import java.util.InputMismatchException;


public class TrafficSystem {

	// Definierar de vägar och signaler som ingår i det 
	// system som skall studeras.
	// Samlar statistik

	// Attribut som beskriver beståndsdelarna i systemet
	private Lane  longLane;
	private Lane  straightLane;
	private Lane  leftLane;
	private Light straightLight;
	private Light leftLight;

	// Diverse attribut för simuleringsparametrar (ankomstintensiteter,
	// destinationer...)

	private int intensity;
	private int leftIntensity;
	//private int carCounter = 0;

	private int totalCarsIn;
	private float totalCarsOut;
	private float totalTime;
	private int maxTime;


	//L�gg till statistik om antal bilar in och ut (in = intensity?)
	// Diverse attribut för statistiksamling


	private int time = 0;

	public TrafficSystem() { 
		longLane = new Lane(20);
		straightLane = new Lane(5);
		leftLane = new Lane(5);
		straightLight = new Light(10, 3);
		leftLight = new Light(10, 5);
		intensity = 1;
		leftIntensity = 0;
	}

	public TrafficSystem(int[] arr) {
		intensity = arr[0];
		leftIntensity = arr[1];
		straightLight = new Light(arr[2], arr[3]);
		leftLight = new Light(arr[2], arr[4]);
		longLane = new Lane(arr[5]);
		straightLane = new Lane(arr[6]);
		leftLane = new Lane(arr[6]);
	}

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
		this.longLane = new Lane(longLane);
		this.straightLane = new Lane(shortLane);
		this.leftLane = new Lane(shortLane);

	}

	public static TrafficSystem readParameters(int input) {
		// Läser in parametrar för simuleringen
		// Metoden kan läsa från terminalfönster, dialogrutor
		// eller från en parameterfil. Det sista alternativet
		// är att föredra vid uttestning av programmet eftersom
		// man inte då behöver mata in värdena vid varje körning.
		// Standardklassen Properties är användbar för detta. 
		switch (input) {
		case 1:
			TrafficSystem ts = new  TrafficSystem();
			ts.enterValues();
			return ts;

		case 2:
			GetPropertyValues property = new GetPropertyValues();
			int[] propArray = property.getPropValues();
			return new TrafficSystem(propArray);


		default:
			return new TrafficSystem();
		}
	}


	public int getTime(){
		return this.time;
	}

	public void step() {
		// Stega systemet ett tidssteg m h a komponenternas step-metoder
		// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
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

		if(!(longLane.posFree(0))){
			switch (longLane.firstCar().getDest()) {
			case 1: 
				if(straightLane.lastFree()){
					straightLane.putLast(longLane.getFirst());
					longLane.step();
				}else{
					longLane.step(false);
				}
				break;

			case 2:
				if(leftLane.lastFree()){
					leftLane.putLast(longLane.getFirst());
					longLane.step();
				}else{
					longLane.step(false);
				}
				break;

			}

		}else{    		
			longLane.step();
		}    	
		if(time % intensity == 0){
			totalCarsIn++;
			try{
				int nextDest = (int ) (Math.random()*leftIntensity) + 1;
				if(leftIntensity > 0){
					if(nextDest % leftIntensity == 0){
						Car nextCar = new Car(this.time, 2);    				
						longLane.putLast(nextCar);
					}else{
						Car nextCar = new Car(this.time, 1);    				    				
						longLane.putLast(nextCar);
					}
				}else if(leftIntensity == 0){
					Car nextCar = new Car(this.time, 1);    				    				
					longLane.putLast(nextCar);
				}else{
					if(nextDest % leftIntensity == 0){
						Car nextCar = new Car(this.time, 1);    				
						longLane.putLast(nextCar);
					}else{
						Car nextCar = new Car(this.time, 2);    				    				
						longLane.putLast(nextCar);
					}
				}
			}
			catch (Lane.OverflowException e){
				throw new RuntimeException("Long lane overloaded, cars cannot enter");
			}
		}
		if (statCar1 != null) {
			this.writeStatistics(statCar1);
			this.totalCarsOut++;
		}
		if (statCar2 != null) {
			this.writeStatistics(statCar2);
			this.totalCarsOut++;
		}
	}

	public void writeStatistics(Car car) {
		int carTime = this.time - car.getBornTime();
		this.totalTime += carTime;
		if (this.maxTime < carTime) {
			this.maxTime = carTime;
		}

	}
	
	public Number[] getStatistics() { 
		Number[] stats = {0, 0, 0, 0};
		stats[0] = this.totalCarsIn;
		stats[1] = (int) this.totalCarsOut;
		stats[2] = this.maxTime;
		stats[3] = this.totalTime;
		return stats;
	}

	public void printStatistics() {
		System.out.println("Statistics:");
		if (this.totalCarsOut == 0) {
			System.out.println("No cars have left the system.");
		}
		else {
			System.out.println("Average time: " + (this.totalTime / this.totalCarsOut));
			System.out.println("Max time: " + this.maxTime);
			System.out.println("Number of Cars that have been inserted in the system: " + this.totalCarsIn);
			System.out.println("Number of Cars that have left the system: " + (int) this.totalCarsOut);
		}
	}

	public void print() {
		// Skriv ut en grafisk representation av kösituationen
		// med hjälp av klassernas toString-metoder
	}

	public String toString() { //mal = polymorfism
		return "r0 = " + this.longLane.toString() + "\nr1= " + this.straightLane.toString() + "\nr2= " + this.leftLane.toString() + "\ns1= " + this.straightLight.toString() + "\ns2= " + this.leftLight.toString() + ")";
	}


	public static void main(String []args){

	}

}
