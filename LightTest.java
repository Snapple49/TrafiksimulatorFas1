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
		Light tester = new Light(5,5);
		tester.step();
		assertEquals(1, tester.getTime());
		for (int i = 0; i < 99; i++ ) {
			tester.step();
		}
		assertEquals(100, tester.getTime());
	}
	@Test
	public void testIsGreen() {
		Light tester = new Light(1, 1); 
		assertEquals("isGreen = True", true, tester.isGreen());
		tester.step();
		assertEquals("isGreen = False", false, tester.isGreen());
	}

}
