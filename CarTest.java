import static org.junit.Assert.*;

import org.junit.Test;


public class CarTest {

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
		assertFalse("Car(bornTime=5, dest=1)" == tester.toString());
	}

}
