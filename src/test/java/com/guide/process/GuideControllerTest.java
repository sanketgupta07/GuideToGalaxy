/**
 * 
 */
package com.guide.process;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Sanket Gupta
 *
 */
public class GuideControllerTest {

	/**
	 * Test method for {@link com.guide.process.GuideController#startGuide(java.lang.String)}.
	 */
	@Test
	public void testStartGuide() {
		String filePath = "./Input";
		Controller controller = new GuideController();
		String expectedOutput= "pish tegj glob glob is 42\n"
				+"glob prok Silver is 68 Credits\n"
				+"glob prok Gold is 57800 Credits\n"
				+"glob prok Iron is 782 Credits\n"
				+"I have no idea what you are talking about";
		String actualOutput = controller.startGuide(filePath);
		assertEquals(expectedOutput, actualOutput);
				
	}

}
