import static org.junit.Assert.*;

import org.junit.Test;


public class TrafficSystemTest {

	/*
	@Test	
	public void testWriteStatistics() {
		Car testerCar = new Car(1,2);
		TrafficSystem testerSystem = new TrafficSystem();
		testerSystem.writeStatistics(testerCar);
		Number[] testerValues = testerSystem.getStatistics();
		System.out.println((testerValues[3]));
		assertEquals((int) testerValues[0], 0);
		assertEquals((int) testerValues[1], 0);
		assertEquals((int) testerValues[2], 0);
		assertEquals(testerValues[3], -1.0);
			
		
		
		
	}*/
	@Test
	public void testStepCreateCar() {
		int[] testValues = {1,1,1,10,5,5,1,0};
		TrafficSystem testSystem = new TrafficSystem(testValues); 
		testSystem.step();
		testSystem.step();
		testSystem.step();
		testSystem.step();
		testSystem.step();
		Number[] testNumberOfCars = testSystem.getStatistics();
		assertEquals(testNumberOfCars[0], 5);
	}
	
	@Test
	public void testLeftIntensity() {
		
	}
	
	
}