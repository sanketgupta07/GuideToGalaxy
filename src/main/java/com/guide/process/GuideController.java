/**
 * 
 */
package com.guide.process;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This class is the implementation of Controller interface. 
 * It will load the input and start processing.
 * @author Sanket Gupta
 *
 */
public class GuideController implements Controller {

	/*
	 * (non-Javadoc)
	 * @see com.guide.process.Controller#startGuide(java.lang.String)
	 */
	@Override
	public String startGuide(String filePath) {

		try {
			final List<String> input = Files.readAllLines(Paths.get(filePath));
			//processing the inputs
			PreProcessor preProcess = new GuidePreProcessor();
			preProcess.assigingCurrency(input);
			preProcess.evaluateMetalPrice(input);

			//Evaluate the output
			PostProcessor postProcessor = new GuidePostProcessor();
			String result = postProcessor.evaluteResult(input);
			return result;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
