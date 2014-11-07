import java.util.Scanner;





public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)
    
    private int intensity;
    private int leftIntensity;
    //private int carCounter = 0;
    

    // Diverse attribut för statistiksamling
      
    
    private int time = 0;

    public TrafficSystem() { //Some form of standard values here
    	r0 = new Lane(20);
    	r1 = new Lane(5);
    	r2 = new Lane(5);
    	s1 = new Light(10, 3);
    	s2 = new Light(10, 5);
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
	this.s1 = new Light(period, greenPeriodStraight);
	this.s2 = new Light(period, greenPeriodTurn);
	this.r0 = new Lane(r0);
	this.r1 = new Lane(r1);
	this.r2 = new Lane(r1);
	
}

    public void readParameters(int input) {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
    // Standardklassen Properties är användbar för detta. 
    	switch (input) {
    	case 1:
    		this.enterValues(); 
    		break;
    	case 2:
    		//this.getProperties();
    		break;
    	}
    }

    public TrafficSystem(int intensity, int leftIntensity, int period, int greenPeriodStraight, int greenPeriodTurn, int r0, int r1){
    	this.r0 = new Lane(r0);
    	this.r1 = new Lane(r1);
    	this.r2 = new Lane(r1);
    	this.s1 = new Light(period, greenPeriodStraight);
    	this.s2 = new Light(period, greenPeriodTurn);
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
    	s1.step();
    	s2.step();
    	r1.step();
    	r2.step();
    	if(!(r0.posFree(0))){
    		switch (r0.firstCar().getDest()) {
    		case 1: 
    			if(r1.lastFree()){
    				r1.putLast(r0.getFirst());
    				r0.step();
    			}else{
    				r0.step(false);
    			}
    			break;
    			
    		case 2:
    			if(r2.lastFree()){
    				r2.putLast(r0.getFirst());
    				r0.step();
    			}else{
    				r0.step(false);
    			}
    			break;
    			
    		}
    		
    	}else{    		
    		r0.step();
    	}    	
    	if(time % intensity == 0){
    	
    		int nextDest = (int ) (Math.random()*leftIntensity) + 1;
    		if(leftIntensity > 0){
    			if(nextDest % leftIntensity == 0){
    				Car nextCar = new Car(this.time, 2);    				
					r0.putLast(nextCar);
    			}else{
    				Car nextCar = new Car(this.time, 1);    				    				
    				r0.putLast(nextCar);
    			}
    		}else{
    			if(nextDest % leftIntensity == 0){
    				Car nextCar = new Car(this.time, 1);    				
    				r0.putLast(nextCar);
    			}else{
    				Car nextCar = new Car(this.time, 2);    				    				
    				r0.putLast(nextCar);
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
	return "r0 = " + this.r0.toString() + "\nr1= " + this.r1.toString() + "\nr2= " + this.r2.toString() + "\ns1= " + this.s1.toString() + "\ns2= " + this.s2.toString() + ")";
}
    
    
    public static void main(String []args){
    	
    }




}
