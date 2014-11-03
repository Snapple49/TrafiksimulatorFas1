

public class Car {
	
	public class BadDestination extends IndexOutOfBoundsException{
		public BadDestination(String errormsg){
			System.err.println(errormsg);
		}
	}
	
    private int bornTime;
    private int dest; // 1 for forward, 2 for left turn

    
    public Car(int bornTime, int dest) {
    	if(dest > 0 && dest <3){
    		this.bornTime = bornTime;
    		this.dest = dest;
    	}
    	else 
    		throw new BadDestination("Car destination is out of bounds! Has to be 1 or 2");
    		
    	
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
	Car x = new Car(5, 2);
	Car y = new Car(4, 1);
	System.out.println(x.toString() + "\n" + y.toString() + "\n" + x.getBornTime() + "\n" + x.getDest());
	
    }
}
