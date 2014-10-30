
public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
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
	Car firstcar = this.getFirst();
	for (int i = 1; i < theLane.length; i++) {
	    theLane[i-1] = theLane[i]; 
	}
	theLane[theLane.length-1] = null;
	
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


    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
	return (theLane[theLane.length - 1] == null);
    }

    public void putLast(Car c) throws OverflowException {
	// Stall en bil pa sista platsen pa vagen
	// (om det gar).
	if (theLane[theLane.length - 1] == null) {
	    theLane[theLane.length - 1] = c;
	}
	else {
	    throw new OverflowException();
	}
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
		/*if(theLane[theLane.length - 1] != null){
			returnString += "theLane[" + (theLane.length - 1) + "] = " + theLane[theLane.length - 1].toString() + ")";
		}else{
			returnString += "theLane[" + (theLane.length - 1) + "] = empty)";
		}*/
		
		return returnString;
    }

    public static void main(String [] args) {
	Lane newLane = new Lane(10);
	System.out.println(newLane.toString());
	Car car1 = new Car(5, 5);
	newLane.putLast(car1);
	newLane.step();
	Car car2 = new Car(4, 4);
	newLane.putLast(car2);
	newLane.step();
	System.out.println(newLane.toString());
    }
}
