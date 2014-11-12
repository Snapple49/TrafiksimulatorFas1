
// TODO: Auto-generated Javadoc
/**
 * The Class Lane provides Car array objects of specified length with methods for moving the cars in, to or from the object.  
 */
public class Lane {

    /**
     * The Class OverflowException extends RuntimeException (@see java.lang.Object#toString()) and is used when trying to add a Car into an already full Lane. 
     */
    public static class OverflowException extends RuntimeException {
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
     * Instantiates a new lane of length length.
     *
     * @param length the length of the Lane. 
     */
    public Lane(int length) {
    	this.theLane = new Car[length];
    }

    /**
     * Step moves, if possible, all Cars in Lane one step forward (except the Car at position 0). If there is a car at position 0, it is removed.  
     */
    public void step() {
    	this.getFirst();
    	for (int i = 1; i < theLane.length; i++) {
    		theLane[i-1] = theLane[i]; 
    	}
		theLane[theLane.length-1] = null;
		
    }
	
	/**
	 * Step behaves like the instance of step without parameters if green is true. If green is false, it does not remove the car at position 0 (if there is one) and moves cars forward where there is space. 
	 *
	 * @param green a boolean, if true, the light is green. 
	 */
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
   

	/**
	 * Gets the first Car in Lane and removes it from Lane. 
	 *
	 * @return the first Car in Lane
	 */
	public Car getFirst() {
    	Car temp = this.theLane[0];
    	this.theLane[0] = null;
    	return temp;
    }
    
    /**
     * Gets the first Car without removing it. 
     *
     * @return the first Car in Lane.
     */
    public Car firstCar() {
	return theLane[0];
    }

    /**
     * Checks whether the given position is free or not. 
     *
     * @param pos the position.
     * @return true, if pos is free, else false. 
     */
    public boolean posFree(int pos) {
    	return (theLane[pos] == null);
    }

    /**
     * Last free checks whether the last position of Lane is empty.
     *
     * @return true, if the last position is free, else false. 
     */
    public boolean lastFree() {
	return (theLane[theLane.length - 1] == null);
    }

    /**
     * Put a Car in the last place of Lane (if possible).  
     *
     * @param c the Car.
     * @throws OverflowException the overflow exception is used when the last position of Lane is not empty. 
     */
    public void putLast(Car c) throws OverflowException {
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
