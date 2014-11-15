import static org.junit.Assert.*;

import org.junit.Test;


public class TrafficSystemTest {

	@Test
	public void testStepCreateCar() {
		int[] testValues = {1,-2,10,10,1,1,1,0};
		TrafficSystem testSystem = new TrafficSystem(testValues); 
		testSystem.step();
		testSystem.step();
		Number[] testNumberOfCars = testSystem.getStatistics();
		assertEquals((int) testNumberOfCars[0], 2);
		fail("step() not creating a car every time at intensity 1.");
	}
	
	@Test //Random included, may be unsuccessful but is succesfull most of the time.
	
	public void testLeftIntensity() {
		int[] testValues = {1,2,200,1,199,10,60}; 
		TrafficSystem testSystem = new TrafficSystem(testValues);
		int i = 0;
		while (i < 100) {
			testSystem.step();
			i++;
		}
		Number[] testerValues1 = testSystem.getStatistics(); 
		
		TrafficSystem testSystem2 = new TrafficSystem(testValues);
		i = 0;
		while (i < 100) {
			testSystem2.step();
			i++;
		}
		Number[] testerValues2 = testSystem2.getStatistics(); 
		
		TrafficSystem testSystem3 = new TrafficSystem(testValues);
		i = 0;
		while (i < 100) {
			testSystem3.step();
			i++;
		}
		Number[] testerValues3 = testSystem3.getStatistics(); 
		
		boolean bool1 = (5 < (int) testerValues1[1] && (int) testerValues1[1] < 15);
		boolean bool2 = (5 < (int) testerValues2[1] && (int) testerValues2[1] < 15);
		boolean bool3 = (5 < (int) testerValues3[1] && (int) testerValues3[1] < 15);
				
		
		assertTrue( bool1 || bool2 || bool3 );
		fail("COULD BE WORKING CORRECTLY! Randomness is included in the test, but if this is faulty, the leftintensity is not working correctly. ");
		
		
	}
	@Test(expected=RuntimeException.class)
	public void testFullStraightAndLongLane() {
		int[] testValues = {1,1,200,1,1,10,10};
		TrafficSystem testSystem = new TrafficSystem(testValues);
		int i = 0;
		while (i < 20) {
			testSystem.step();
			i++;
		}
		testSystem.step();
		fail("Not throwing Exception when long and straight lane is full.");
	}
	
	@Test(expected=RuntimeException.class)
	public void testFullLeftAndLongLane() {
		int[] testValues = {1,0,200,1,1,10,10};
		TrafficSystem testSystem = new TrafficSystem(testValues);
		int i = 0;
		while (i < 20) {
			testSystem.step();
			i++;
		}
		testSystem.step();
		fail("Not throwing Exception when long and left lane is full.");
	}
	
	@Test
	public void testAlwaysGreen() {
		int[] testValues = {1,2,200,199,199,10,10};
		TrafficSystem testSystem = new TrafficSystem(testValues);
		int i = 0;
		boolean falseIfSuccessful = false;
		try {
			while (i < 5000) {
				testSystem.step();
				i++;
			}
		}
		catch (Lane.LaneOverflowException e) {
			falseIfSuccessful = true;
		}
		assertFalse(falseIfSuccessful);
		fail("System not working for big values of seconds (5000).");
	}
}