
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    	public OverflowException(String errormsg){
    		System.err.println(errormsg);
    	}
    }

    private Car[] theLane;

    public Lane(int n) {
    	// Konstruerar ett Lane-objekt med plats for n fordon
    	this.theLane = new Car[n];
    }

    public void step() {
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det gar). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    	//this.getFirst();
    	for (int i = 1; i < theLane.length; i++) {
    		theLane[i-1] = theLane[i]; 
    	}
		theLane[theLane.length-1] = null;
		
    }
	public void step(boolean green) {
		if (green) {
			this.step();
		}
		else {
			for (int j = 0; j < this.theLane.length-1; j++) {
				if (this.posFree(j)) {
					this.theLane[j] = this.theLane[j+1];
					this.theLane[j+1] = null;
				}		
			}	
		}
	}
    
    public Car getFirst() {
	// Returnera och tag bort bilen som står först
    	Car temp = this.theLane[0];
    	this.theLane[0] = null;
    	return temp;
    }
    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
	return theLane[0];
    }

    public boolean posFree(int pos) {
    	return (theLane[pos] == null);
    }

    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
	return (theLane[theLane.length - 1] == null);
    }

    public void putLast(Car c) throws OverflowException {
	// Stall en bil pa sista platsen pa vagen
	// (om det gar).    	
    	if (theLane[theLane.length - 1] == null) {
    		theLane[theLane.length - 1] = c;
    	}else 
    		throw new OverflowException("Could not put a car in lane");    	
    }

    
    public String toString() {
    	String returnString = "Lane:\n";
    	for (int i = 0; i < theLane.length; i++) {
    		if(theLane[i] != null){
    			returnString += "theLane[" + i + "] = " + theLane[i].toString() + "\n"; 
		    }else{
		    	returnString += "theLane[" + i + "] = empty\n";
		    }
		}
		
		return returnString;
    }

    public static void main(String [] args) {
	Lane newLane = new Lane(10);
	System.out.println("1: " + newLane.toString());
	Car car1 = new Car(5, 1);
	newLane.putLast(car1);
	newLane.step();
	Car car2 = new Car(4, 2);
	newLane.putLast(car2);
	newLane.step();
	newLane.step();
	newLane.step();
	newLane.step();
	newLane.step();
	newLane.step();
	newLane.step();
	newLane.step();
	System.out.println("3: " + newLane.toString());
	newLane.step();
	System.out.println("4: " + newLane.toString());
	newLane.step();
	System.out.println("5: " + newLane.toString());
	
	Lane anotherLane = new Lane(1);
	anotherLane.putLast(car1);
	System.out.println("6: " + anotherLane.toString());
	anotherLane.putLast(anotherLane.getFirst());
	System.out.println("7: " + anotherLane.toString());
	
    }
}
