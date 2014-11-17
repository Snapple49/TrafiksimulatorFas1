import static org.junit.Assert.*;

import org.junit.Test;


public class LightTest {

	@Test
	public void testGetTime() {
		Light tester = new Light(5,5);
		assertEquals(0, tester.getTime());
		
	}
	
	@Test
	public void testStep() {
		Light tester = new Light(150,120);
		tester.step();
		assertEquals(1, tester.getTime());
		for (int i = 0; i < 99; i++ ) {
			tester.step();
		}
		
		assertEquals(100, tester.getTime());
		fail("step() not working correctly.");
	}
	@Test
	public void testPeriodStep() {
		Light tester = new Light(2,1);
		tester.step();
		tester.step();
		assertEquals(0, tester.getTime());
		fail("Internal time not resetting correctly.");
		
	}
	@Test
	public void testIsGreen() {
		Light tester = new Light(2, 1); 
		assertEquals("isGreen = True", true, tester.isGreen());
		tester.step();
		assertEquals("isGreen = False", false, tester.isGreen());
		fail("isGreen not working correctly.");
	}
	@Test
	public void testToString() {
		Light tester = new Light(1,1);
		assertEquals("Light(period=1, time=0, green=1)", tester.toString());
		fail("toString() not working correctly.");
	}

}
