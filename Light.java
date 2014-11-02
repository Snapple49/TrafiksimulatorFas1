

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
	this.time++;
       // Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
	return (this.time < this.green);
	// Returnerar true om time<green, annars false
    }

    

    public String toString() {
	return "Light(period=" + this.period + ", time=" + this.time + ", green=" + this.green + ")";
    }

    public static void main(String [] args) {
	Light x = new Light(5, 5);
	Light y = new Light(1, 1);
	System.out.println(x.toString() + "\n" + y.toString() + "\n" + y.isGreen());
	y.step();
	System.out.println(y.isGreen());
	
    }
	

}
