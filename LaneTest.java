import static org.junit.Assert.*;

import org.junit.Test;


public class LaneTest {
	
	@Test
	public void testStep() {
		Lane tester = new Lane(2);
		Car car1 = new Car(1, 1);
		tester.putLast(car1);
		tester.step();
		assertTrue(tester.firstCar() == car1);
	}

	@Test
	public void testGetFirst() {
		Lane tester = new Lane(5);
		Car car1 = new Car(1, 1);
		tester.putLast(car1);
		tester.step();
		tester.step();
		tester.step();
		tester.step();
		Car car2 = tester.getFirst();
		assertTrue(car1 == car2);
		assertTrue(tester.getFirst() == null);
	}
	
	@Test
	public void testLastFree() {
		Lane tester10 = new Lane(10);
		
		
		
		
	}
	
	@Test
	public void test4() {
		Lane tester = new Lane(2);
		Car car1 = new Car(1, 1);
		tester.putLast(car1);
		tester.step();
		assertTrue(tester.getFirst() == car1);
	}

}
