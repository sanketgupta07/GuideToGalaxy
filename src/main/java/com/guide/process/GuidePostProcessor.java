/**
 * 
 */
package com.guide.process;

import java.util.List;

import com.guide.utils.GuideUtils;

/**
 * @author Sanket Gupta
 *
 */
public class GuidePostProcessor implements PostProcessor{
	/*
	 * (non-Javadoc)
	 * @see com.guide.process.PostProcessor#evaluteResult(java.util.List)
	 */
	@Override
	public String evaluteResult(final List<String> input){
		final List<String> lines = GuideUtils.stringListTrimmer(input);
		StringBuilder combineResult = new StringBuilder();
		for (String line : lines) {
			if (line.endsWith("?")) {// Its a question to evaluate an answer.
				if(line.startsWith("how much is ")){	
					handleHowMuch(line, combineResult);
				}else if(line.startsWith("how many Credits is ")){
					handleHowMany(line, combineResult);
				}else{
					combineResult.append("I have no idea what you are talking about\n");
				}
			}
		}
		return combineResult.toString().trim();	
	}

	/**
	 * This method will handle the "how much" questions 
	 * @param line
	 * @param combineResult
	 * @return {@link StringBuilder}
	 */
	private StringBuilder handleHowMuch(String line, StringBuilder combineResult){
		StringBuilder numralResult;
		StringBuilder litralResult;
		if(line.startsWith("how much is ")){			
			numralResult = new StringBuilder();
			litralResult = new StringBuilder();
			String [] words = line.split(" ");					
			for (int i = 3; i < words.length -1; i++) {
				numralResult.append(PreProcessor.currencyMap.get(words[i]));
				litralResult.append(" "+words[i]);
			}
			int value = GuideUtils.romanToNum(numralResult.toString());
			combineResult.append(litralResult.toString().trim()+" is "+value+"\n");

		}
		return combineResult;
	}

	/**
	 * this method will handle "how many" questions
	 * @param line
	 * @param combineResult
	 * @return {@link StringBuilder}
	 */
	private StringBuilder handleHowMany(String line, StringBuilder combineResult){
		StringBuilder numralResult;
		StringBuilder litralResult;
		if(line.startsWith("how many Credits is ")){
			numralResult = new StringBuilder();
			litralResult = new StringBuilder();
			String [] words = line.split(" ");					
			for (int i = 4; i < words.length -2; i++) {
				numralResult.append(PreProcessor.currencyMap.get(words[i]));
				litralResult.append(" "+words[i]);
			}
			int value =(int)( GuideUtils.romanToNum(numralResult.toString())* PreProcessor.metalValueMap.get(words[words.length-2]));
			combineResult.append(litralResult.toString().trim()+" "+words[words.length-2]+" is "+value+" Credits"+"\n");
		}
		return combineResult;
	}
}