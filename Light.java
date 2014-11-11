

public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

    public Light(int period, int green) {
	this.period = period;
	this.green = green;
    }


    public int getTime() {
    	return time;
    }

    public void step() {
    	if(this.time < this.period - 1){
    		this.time++;
    	}else{
    		this.time = 0;
    	}	
    	// Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
	return (this.time < this.green);
	// Returnerar true om time<green, annars false
    }

    

    public String toString() {
	return "Light(period=" + this.period + ", time=" + this.time + ", green=" + this.green + ")";
    }
}
