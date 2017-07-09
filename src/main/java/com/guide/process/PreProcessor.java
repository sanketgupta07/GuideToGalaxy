/**
 * 
 */
package com.guide.process;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sanket Gupta
 * This interface contains method for pre-processing.
 */
public interface PreProcessor {
	
	static Map<String, String> currencyMap = new HashMap<String, String>();
	static Map<String, Float> metalValueMap = new HashMap<String, Float>();

	/**
	 * This method will assign values to currencies(ex. glob, pork, pish etc)
	 * @param input
	 */
	public void assigingCurrency (final List<String> input);
	
	/**
	 * This method will evaluate the metal price from the inputs
	 * @param input
	 */
	public void evaluateMetalPrice (final List<String> input);
	
}
