/**
 * 
 */
package com.guide.process;

import java.util.List;

/**
 * @author Sanket Gupta
 * This interface contains method for post-processing.
 */
public interface PostProcessor {

	/**
	 * This method will evaluate the output.
	 * @param input
	 */
	public String evaluteResult(final List<String> input);
	
}
