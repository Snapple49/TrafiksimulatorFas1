/**
 * The Class Car represents the cars in the Traffic System. The class provides methods for getting the born time and the destination of the cars. 
 */
public class Car {
	
	/**
	 * Thrown when trying to create a Car with a non-valid destination. Extends IndexOutOfBoundsException.
	 */
	protected class BadCarDestinationException extends IndexOutOfBoundsException{
		
		/**
		 * Instantiates a new BadDestination with error message errormsg.
		 *
		 * @param errormsg the errormsg is printed to the error stream.
		 */
		public BadCarDestinationException(String errormsg){
			System.err.println(errormsg);
		}
	}
	
    /** The the time Car was born. */
    private int bornTime;
    
    /** The destination. 1 for forward, 2 for left turn. */
    private int dest; 

    
    /**
     * Instantiates a new Car object with specified born time and destinaion.
     *
     * @throws BadCarDestinationException if destination is anything else than integers 1 or 2.
     * @param bornTime the born time
     * @param dest the destination
     */
    public Car(int bornTime, int dest) {
    	if(dest > 0 && dest <3){
    		this.bornTime = bornTime;
    		this.dest = dest;
    	}
    	else 
    		throw new BadCarDestinationException("Car destination is out of bounds! Has to be 1 or 2");
    		
    	
    }

    /**
     * Gets the born time of Car.
     *
     * @return the born time int.
     */
    public int getBornTime() {
	return this.bornTime;
    }

    /**
     * Gets the destination of Car.
     *
     * @return the destination int.
     */
    public int getDest() {
	return this.dest;
    }
    
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return "Car(bornTime=" + this.bornTime + ", dest=" + this.dest + ")";
    }

}
