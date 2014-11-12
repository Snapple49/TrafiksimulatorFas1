import static org.junit.Assert.*;

import org.junit.Test;


public class LaneTest {
	
	@Test
	public void testStep() {
		Lane tester = new Lane(5);
		Car car1 = new Car(1, 1);
		tester.putLast(car1);
		for(int i = 0; i < 4; i++){
			tester.step();
		}
		assertTrue(tester.firstCar() == car1);
		Lane tester2 = new Lane(1);
		tester2.putLast(car1);
		tester2.step();
		assertTrue(tester2.firstCar() == null);
	}
	
	@Test
	public void testFalseStep() {
		Lane tester = new Lane(3);
		int testVar = 0;
		Car car1 = new Car(1, 1);
		Car car2 = new Car(1, 2);
		Car car3 = new Car(1, 1);
		tester.putLast(car1);
		tester.step(false);
		tester.putLast(car2);
		tester.step(false);
		tester.putLast(car3);
		tester.step(false);
		try {
		tester.putLast(car3);
		}
		catch (Lane.OverflowException e) {
			testVar = 1;
		}
		assertTrue(testVar == 1);		
	}
	@Test
	public void testTrueStep() {
		Lane tester = new Lane(3);
		int testVar = 0;
		Car car1 = new Car(1, 1);
		Car car2 = new Car(1, 2);
		Car car3 = new Car(1, 1);
		tester.putLast(car1);
		tester.step();
		tester.putLast(car2);
		tester.step();
		tester.putLast(car3);
		tester.step();
		tester.step(true);
		try {
			tester.putLast(car3);
			}
			catch (Lane.OverflowException e) {
				testVar = 1;
			}
		
		assertTrue(testVar == 0);
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
		Lane tester = new Lane(10);
		assertTrue(tester.lastFree());
		
	}
	 //* skriv test för toString

}
