

// TODO: Auto-generated Javadoc
/**
 * The Class Light.
 */
public class Light {
    
    /** The period. */
    private int period;
    
    /** The time. */
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    
    /** The green. */
    private int green; // Signalen grön när time<green 

    /**
     * Instantiates a new light.
     *
     * @param period the period
     * @param green the green
     */
    public Light(int period, int green) {
	this.period = period;
	this.green = green;
    }


    /**
     * Gets the time.
     *
     * @return the time
     */
    public int getTime() {
    	return time;
    }

    /**
     * Step.
     */
    public void step() {
    	if(this.time < this.period - 1){
    		this.time++;
    	}else{
    		this.time = 0;
    	}	
    	// Stegar fram klocka ett steg
    }

    /**
     * Checks if is green.
     *
     * @return true, if is green
     */
    public boolean isGreen()   {
	return (this.time < this.green);
	// Returnerar true om time<green, annars false
    }

    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return "Light(period=" + this.period + ", time=" + this.time + ", green=" + this.green + ")";
    }
}
