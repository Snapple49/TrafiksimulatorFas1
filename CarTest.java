import static org.junit.Assert.*;
import org.junit.Test;

//import Car.BadDestination;


public class CarTest {

	@Test
	public void testNewCar() {
		new Car(1,2);
		new Car(1,1);
	}
	
	@Test
	public void testGetBornTime() {
		Car tester = new Car(5,1);
		assertEquals(5, tester.getBornTime());
	}
		
	@Test
	public void testGetDest() {
		Car tester = new Car(5,1);
		assertEquals(1, tester.getDest());
	}
	
	@Test
	public void testToString() {
		Car tester = new Car(5,1);
		assertEquals("Car(bornTime=5, dest=1)", tester.toString());
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
	}

}
