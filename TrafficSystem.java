import java.util.Scanner;
import java.util.Properties;




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


	// Diverse attribut för statistiksamling


	private int time = 0;

	public TrafficSystem() { //Some form of standard values here
		longLane = new Lane(20);
		straightLane = new Lane(5);
		leftLane = new Lane(5);
		straightLight = new Light(10, 3);
		leftLight = new Light(10, 5);
		intensity = 1;
		leftIntensity = 3;
	}

	public void enterValues() {
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



		this.intensity = intensity;
		this.leftIntensity = leftIntensity;
		this.straightLight = new Light(period, greenPeriodStraight);
		this.leftLight = new Light(period, greenPeriodTurn);
		this.longLane = new Lane(r0);
		this.straightLane = new Lane(r1);
		this.leftLane = new Lane(r1);

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
			Properties p = property.getPropValues();
			int i1 = Integer.parseInt(property.getPropValues().getProperty("intensity"));
			int i2 = Integer.parseInt(property.getPropValues().getProperty("leftIntensity"));
			int i3 = Integer.parseInt(property.getPropValues().getProperty("period"));
			int i4 = Integer.parseInt(property.getPropValues().getProperty("greenPeriodStraight"));
			int i5 = Integer.parseInt(property.getPropValues().getProperty("greenPeriodTurn"));
			int i6 = Integer.parseInt(property.getPropValues().getProperty("firstLane"));
			int i7 = Integer.parseInt(property.getPropValues().getProperty("secondLane"));

			return new TrafficSystem(i1, i2, i3, i4 ,i5 ,i6 ,i7);
			
		
		default:
			return new TrafficSystem();
		}
	}
	
	public TrafficSystem(int intensity, int leftIntensity, int period, int greenPeriodStraight, int greenPeriodTurn, int r0, int r1){
		this.longLane = new Lane(r0);
		this.straightLane = new Lane(r1);
		this.leftLane = new Lane(r1);
		this.straightLight = new Light(period, greenPeriodStraight);
		this.leftLight = new Light(period, greenPeriodTurn);
		this.intensity = intensity;
		this.leftIntensity = leftIntensity;



	}

	public int getTime(){
		return this.time;
	}

	public void step() {
		// Stega systemet ett tidssteg m h a komponenternas step-metoder
		// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna

		time++;
		straightLight.step();
		leftLight.step();
		straightLane.step();
		leftLane.step();
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

			int nextDest = (int ) (Math.random()*leftIntensity) + 1;
			if(leftIntensity > 0){
				if(nextDest % leftIntensity == 0){
					Car nextCar = new Car(this.time, 2);    				
					longLane.putLast(nextCar);
				}else{
					Car nextCar = new Car(this.time, 1);    				    				
					longLane.putLast(nextCar);
				}
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
	}

	public void printStatistics() {
		// Skriv statistiken samlad så här långt
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
