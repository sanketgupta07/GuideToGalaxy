/**
 * 
 */
package com.guide.process;

import java.util.List;

import com.guide.utils.GuideUtils;

/**
 * @author Sanket Gupta
 * This class implements the PreProcessor interface
 */
public class GuidePreProcessor implements PreProcessor {

	/*
	 * (non-Javadoc)
	 * @see com.guide.process.PreProcessor#assigingCurrency(java.util.List)
	 */
	@Override
	public void assigingCurrency(List<String> input) {
		final List<String> lines = GuideUtils.stringListTrimmer(input);
		for (String line : lines) {
			String [] words = line.split(" ");
			if(line !=null && !line.equalsIgnoreCase("") && words.length == 3){
				currencyMap.put(words[0], words[2]);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.guide.process.PreProcessor#evaluateMetalPrice(java.util.List)
	 */
	@Override
	public void evaluateMetalPrice(List<String> input) {
		final List<String> lines = GuideUtils.stringListTrimmer(input);
		for (String line : lines) {
			if(line.endsWith("Credits")){
				String [] words = line.split(" is ")[0].split(" ");
				StringBuilder romanVal = new StringBuilder();
				for (int i = 0; i < words.length-1; i++) {// converting currency to per unit
					romanVal.append(currencyMap.get(words[i]));
				}
				int quanity = GuideUtils.romanToNum(romanVal.toString());
				float value = Float.parseFloat(line.split(" is ")[1].split(" ")[0]);
				float perUnitValueOfMetal = value/quanity; 
				metalValueMap.put(words[words.length-1], perUnitValueOfMetal);
			}
		}
	}

}
