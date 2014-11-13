/**
 * The Class Light represents the traffic lights in the system. It includes methods for stepping the light forwards in timeline, getting the time and checking if it is green.
 * 
 * @author Oliver Stein & Alexander Lind
 * 
 */
public class Light {

	/** The period of the traffic system, determines length of internal timecycle. */
	private int period;

	/** The internal time of the traffic light, should reset when reaching period. */
	private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...

	/** The threshold for when traffic signal is green. */
	private int greenThreshold; // Signalen grön när time<green 

	/**
	 * Instantiates a new Light with specified period and green threshold.
	 *
	 * @param period specify the period
	 * @param greenThreshold specify the greenThreshold
	 */
	public Light(int period, int greenThreshold) {
		this.period = period;
		this.greenThreshold = greenThreshold;
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
		// Stegar fram klocka ett steg
	}

	/**
	 * Checks if time is below greenThreshold to see if Light signal is green.
	 *
	 * @return true if signal is green, else false.
	 */
	public boolean isGreen()   {
		return (this.time < this.greenThreshold);
		// Returnerar true om time<green, annars false
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Light(period=" + this.period + ", time=" + this.time + ", green=" + this.greenThreshold + ")";
	}
}
