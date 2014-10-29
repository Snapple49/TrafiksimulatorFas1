

public class Car {

    private int bornTime;
    private int dest; // 1 för rakt fram, 2 för vänstersväng

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
    
    // konstruktor och get-metoder
    

    public String toString() {
	return "Car(bornTime=" + this.bornTime + ", dest=" + this.dest + ")";
    }

    public static void main(String [] args) {
	Car x = new Car(5, 2);
	Car y = new Car(4, 1);
	System.out.println(x.toString() + "\n" + y.toString() + "\n" + x.getBornTime() + "\n" + x.getDest());
	
    }
}
