



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
    

    public void readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
    // Standardklassen Properties är användbar för detta. 
    	
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
