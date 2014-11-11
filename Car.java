

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

}
