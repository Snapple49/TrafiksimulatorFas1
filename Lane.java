
// TODO: Auto-generated Javadoc
/**
 * The Class Lane.
 */
public class Lane {

    /**
     * The Class OverflowException.
     */
    public static class OverflowException extends RuntimeException {
        // Undantag som kastas nar det inte gick att lagga 
        // in en ny bil pa vagen
    	/**
         * Instantiates a new overflow exception.
         *
         * @param errormsg the errormsg
         */
        public OverflowException(String errormsg){
    		System.err.println(errormsg);
    	}
    }

    /** The lane. */
    private Car[] theLane;

    /**
     * Instantiates a new lane.
     *
     * @param n the n
     */
    public Lane(int n) {
    	// Konstruerar ett Lane-objekt med plats for n fordon
    	this.theLane = new Car[n];
    }

    /**
     * Step.
     */
    public void step() {
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det gar). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    	this.getFirst();
    	for (int i = 1; i < theLane.length; i++) {
    		theLane[i-1] = theLane[i]; 
    	}
		theLane[theLane.length-1] = null;
		
    }
	
	/**
	 * Step.
	 *
	 * @param isGreen the green
	 */
	public void step(boolean isGreen) {
		if (isGreen) {
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
    
    /**
     * First car.
     *
     * @return the car
     */
    public Car firstCar() {
	// Returnera bilen som står först utan att ta bort den
	return theLane[0];
    }

    /**
     * Pos free.
     *
     * @param pos the pos
     * @return true, if successful
     */
    public boolean posFree(int pos) {
    	return (theLane[pos] == null);
    }

    /**
     * Last free.
     *
     * @return true, if successful
     */
    public boolean lastFree() {
	// Returnera true om sista platsen ledig, annars false
	return (theLane[theLane.length - 1] == null);
    }

    /**
     * Put last.
     *
     * @param c the c
     * @throws OverflowException the overflow exception
     */
    public void putLast(Car c) throws OverflowException {
	// Stall en bil pa sista platsen pa vagen
	// (om det gar).    	
    	if (theLane[theLane.length - 1] == null) {
    		theLane[theLane.length - 1] = c;
    	}else 
    		throw new OverflowException("Could not put a car in lane");    	
    }

    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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


}
