import static org.junit.Assert.*;
import org.junit.Test;

//import Car.BadDestination;


public class CarTest {


	
	@Test
	public void testGetBornTime() {
		Car tester = new Car(5,1);
		assertEquals(5, tester.getBornTime());
		fail("Borntime not correct.");
	}
		
	@Test
	public void testGetDest() {
		Car tester = new Car(5,1);
		assertEquals(1, tester.getDest());
		fail("Destination not correct.");
	}
	
	@Test
	public void testToString() {
		Car tester = new Car(5,1);
		assertEquals("Car(bornTime=5, dest=1)", tester.toString());
		fail("ToString not correct.");
	}
	
	@Test
	public void testBadDestination() {
		int testVar = 0; 
		try {
			new Car(1,5);
		}
		catch (Car.BadDestination e) {
			testVar = 1;
		}
		assertTrue(testVar == 1); 
		fail("Exception BadDestination is not thrown when it is supposed to.");
	}

}
