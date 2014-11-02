import java.util.concurrent.TimeUnit;

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

    // Diverse attribut för statistiksamling
      
    
    private int time = 0;

    public TrafficSystem() { //Some form of standard values here
    	r0 = new Lane(10);
    	r1 = new Lane(4);
    	r2 = new Lane(4);
    	s1 = new Light(10, 3);
    	s2 = new Light(10, 5);
    }
    

    public void readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
    // Standardklassen Properties är användbar för detta. 
    	
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    	
    	
    	
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
    	
    	int loop = 0;
    	while(loop<10){
    		System.out.println("Hej!");
    		
			try {
				TimeUnit.SECONDS.wait(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
			
    		loop++;
    	}
    }




}
>>>>>>> b8d3fb302b974c3e16c4e5e171ef5097ea70eea4
