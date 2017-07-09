/**
 * 
 */
package com.guide.process;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sanket Gupta
 *
 */
public class GuidePostProcessorTest {

	private static final String INPUT_FILE_PATH = "./Input";
	private List<String> input;
	/**
	 * To pre-process the inputs. 
	 */
	@Before
	public void init(){

		//		Load the inputs.
		try {
			input = Files.readAllLines(Paths.get(INPUT_FILE_PATH));
			//			processing the inputs
			PreProcessor preProcess = new GuidePreProcessor();
			preProcess.assigingCurrency(input);
			preProcess.evaluateMetalPrice(input);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link com.guide.process.GuidePostProcessor#evaluteResult(java.util.List)}.
	 */
	@Test
	public void testEvaluteResult() {
		String expectedOutput= "pish tegj glob glob is 42\n"
				+"glob prok Silver is 68 Credits\n"
				+"glob prok Gold is 57800 Credits\n"
				+"glob prok Iron is 782 Credits\n"
				+"I have no idea what you are talking about";
		PostProcessor postProcessor = new GuidePostProcessor();
		String actualOutput = postProcessor.evaluteResult(input);
		assertEquals(expectedOutput, actualOutput);
	}
}
