/**
 * The Class Light represents the traffic lights in the system. It includes methods for stepping the light forwards in timeline, getting the time and checking if it is green.
 * 
 * @author Oliver Stein & Alexander Lind
 * 
 */
public class Light {

	/**
	 * Thrown to indicate that specified values for Light are invalid.
	 */
	private class InvalidValueException extends IndexOutOfBoundsException{		
		
		/**
		 * Instantiates a new invalid value exception with error message errormsg.
		 *
		 * @param errormsg the message to be printed to standard error stream.
		 */
		private InvalidValueException(String errormsg) {
			super(errormsg);
		}
		
	}

	/** The period of the traffic system, determines length of internal timecycle. */
	private int period;

	/** The internal time of the traffic light, should reset when reaching period. */
	private int time;  

	/** The threshold for when traffic signal is green. */
	private int greenThreshold;

	/**
	 * Instantiates a new Light with specified period and greenThreshold.
	 *
	 * @param period specify the period.
	 * @param greenThreshold specify the greenThreshold.
	 */
	public Light(int period, int greenThreshold) { 
		if (greenThreshold < 0) {
			throw new InvalidValueException("greenThreshold must be bigger than 0.");
		}
		if (period < 0) {
			throw new InvalidValueException("period must be bigger than 0.");
		}
		else {
		this.period = period;
		this.greenThreshold = greenThreshold;
		}
	}


	/**
	 * Gets the internal time of Light.
	 *
	 * @return int time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Increases internal timer of Light and resets it as it reaches end of time cycle.
	 */
	public void step() {
		if(this.time < this.period - 1){
			this.time++;
		}else{
			this.time = 0;
		}	
	}

	/**
	 * Checks if Light signal is green.
	 *
	 * @return true if signal is green, else false.
	 */
	public boolean isGreen()   {
		return (this.time < this.greenThreshold);
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Light(period=" + this.period + ", time=" + this.time + ", green=" + this.greenThreshold + ")";
	}
}
