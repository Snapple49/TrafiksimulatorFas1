
public class Car {

    private int bornTime;
    private int dest; // 1 for forward, 2 for left turn

    public Car(int bornTime, int dest) {
	this.bornTime = bornTime;
	this.dest = dest;
    }

    public int getBornTime() {
	return this.bornTime;
    }

    public int getDest() {
	return this.dest;
    }
    
    // constructor and getter-methods
    

    public String toString() {
	return "Car(bornTime=" + this.bornTime + ", dest=" + this.dest + ")";
    }
	
}
