

// TODO: Auto-generated Javadoc
/**
 * The Class Car provides two ints, one with the time when the car was born and another with the destination for the Car.
 */
public class Car {
	
	/**
	 * The Class BadDestination extends extends IndexOutOfBoundsException (@see java.lang.IndexOutOfBoundsException()) and is used when trying to create a Car with a non-legitimate destination. 
	 */
	public class BadDestination extends IndexOutOfBoundsException{
		
		/**
		 * Instantiates a new bad destination.
		 *
		 * @param errormsg the errormsg
		 */
		public BadDestination(String errormsg){
			System.err.println(errormsg);
		}
	}
	
    /** The born time. */
    private int bornTime;
    
    /** The destination. 1 for forward, 2 for left turn. */
    private int dest; 

    
    /**
     * Instantiates a new car.
     *
     * @param bornTime the born time
     * @param dest the destination
     */
    public Car(int bornTime, int dest) {
    	if(dest > 0 && dest <3){
    		this.bornTime = bornTime;
    		this.dest = dest;
    	}
    	else 
    		throw new BadDestination("Car destination is out of bounds! Has to be 1 or 2");
    		
    	
    }

    /**
     * Gets the born time of Car.
     *
     * @return the born time
     */
    public int getBornTime() {
	return this.bornTime;
    }

    /**
     * Gets the destination of Car.
     *
     * @return the destination
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
