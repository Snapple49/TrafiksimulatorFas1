
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
        // (om det g�r). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }

    public Car getFirst() {
	// Returnera och tag bort bilen som står först
    	Car temp = this.theLane[0];
    	this.theLane[0] = null;
    	return temp;
    }

    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
    }


    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
    }

    public void putLast(Car c) throws OverflowException {
	// Ställ en bil på sista platsen på vägen
	// (om det går).
    }

    
    public String toString() {
	return "Lane(theLane=" + this.theLane + ")";
    }
}
