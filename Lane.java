/**
 * The Lane class represents a lane in the Traffic System. The lane consists of an array of Cars of specified length. The class provides methods for moving the cars in, to or from the lane.  
 */
public class Lane {

    /**
     * Thrown to indicate attempt to put a car into a Lane which already has a car in last spot. Extends RuntimeException.
     */
	protected class LaneOverflowException extends RuntimeException {
    	/**
         * Instantiates a new overflow exception with error message errormsg.
         *
         * @param errormsg the errormsg to be printed to error stream.
         */
        public LaneOverflowException(String errormsg){
    		System.err.println(errormsg);
    	}
    }

    /** The array of Car objects. Forward means decreasing index. */
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
     * Step moves all Cars in Lane one step forward (except the Car at position 0). If there is a car at position 0, it is removed.  
     */
    public void step() {
    	this.getFirst();
    	for (int i = 1; i < theLane.length; i++) {
    		theLane[i-1] = theLane[i]; 
    	}
		theLane[theLane.length-1] = null;
		
    }
	
	/**
	 * Step with boolean behaves like step without parameters if isGreen is true. If isGreen is false, it does not remove the Car at position 0 (if there is one) and moves Cars forward where there is space. 
	 *
	 * @param isGreen is a boolean. If true, the light is green. 
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
     * Checks whether the given position in Lane is null or not. 
     *
     * @param pos the position.
     * @return true, if pos is free, else false. 
     */
    public boolean posFree(int pos) {
    	return (theLane[pos] == null);
    }

    /**
     * Last free checks whether the last position of Lane is null.
     *
     * @return true, if the last index of Lane is null, else false. 
     */
    public boolean lastFree() {
	return (theLane[theLane.length - 1] == null);
    }

    /**
     * Put a Car in the last place of Lane (if possible).  
     *
     * @param c the Car to be put in the Lane.
     * @throws LaneOverflowException the overflow exception is thrown when the last position of Lane is not empty. 
     */
    public void putLast(Car c) throws LaneOverflowException {
    	if (theLane[theLane.length - 1] == null) {
    		theLane[theLane.length - 1] = c;
    	}else 
    		throw new LaneOverflowException("Could not put a car in lane");    	
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
}
