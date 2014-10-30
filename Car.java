

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

    public static void main(String [] args) {
	Car x = new Car(5, 1);
	Car y = new Car(4, 1);
	System.out.println(x.toString() + "\n" + y.toString() + "\n" + x.getBornTime() + "\n" + x.getDest());
	
    }
}
