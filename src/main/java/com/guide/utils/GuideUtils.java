/**
 * 
 */
package com.guide.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sanket Gupta
 * This class contains utilities methods.
 */
public class GuideUtils implements Constants{

	/**
	 * Static variables
	 */
	private static int counterV;
	private static int counterL;
	private static int counterD;
	private static int counterI;
	private static int counterX;
	private static int counterC;
	private static int counterM;

	private static Map<Character, Integer> ROMAN_TO_NUMERIC_MAPPING; 

	static{
		ROMAN_TO_NUMERIC_MAPPING = new HashMap<Character, Integer>();

		ROMAN_TO_NUMERIC_MAPPING.put('I', Constants.I);
		ROMAN_TO_NUMERIC_MAPPING.put('V', Constants.V);
		ROMAN_TO_NUMERIC_MAPPING.put('X', Constants.X);
		ROMAN_TO_NUMERIC_MAPPING.put('L', Constants.L);
		ROMAN_TO_NUMERIC_MAPPING.put('C', Constants.C);
		ROMAN_TO_NUMERIC_MAPPING.put('D', Constants.D);
		ROMAN_TO_NUMERIC_MAPPING.put('M', Constants.M);
	}

	/**
	 * This method convert any Roman number to decimal number format.
	 * @param roman
	 * @return {@link Integer}
	 */
	public static Integer romanToNum(String roman)
	{
		if(!validateInput(roman)){
			System.out.println("Invalid input");
			return 0;
		}

		String customInput = roman.trim()+" ";
		char[] inputArray= customInput.toCharArray();
		resetCounters();
		if(validateRepetition(inputArray)){
			System.out.println("Invalid input");
			return 0;
		}
		int value = 0;

		for (int i=0; i<roman.length(); i++){
			int num1 = ROMAN_TO_NUMERIC_MAPPING.get(roman.charAt(i));

			if (i+1 <roman.length()){
				int num2 = ROMAN_TO_NUMERIC_MAPPING.get(roman.charAt(i+1));

				if (num1 >= num2){
					value = value + num1;
				}else{
					value = value + num2 - num1;
					i++; 
				}
			}else{
				value = value + num1;
				i++;
			}
		}

		return value;
	}

	/**
	 * This method will trim each string in a List<String>
	 * @param list
	 * @return {@link List}
	 */
	public static List<String> stringListTrimmer (List<String> list){
		List<String> outputList = new ArrayList<String>();
		for (String line:list) {
			outputList.add(line.trim());			
		}
		return Collections.unmodifiableList(outputList);
	}

	/**
	 * To validate null or blank string.
	 * @param input
	 * @return
	 */
	private static boolean validateInput(String input) {
		if(input==null || input.equalsIgnoreCase(""))
			return false;
		if(input.trim().contains(" "))
			return false;
		if(!input.trim().matches("[IVXCDLM]*"))
			return false;
		return true;
	}

	/**
	 * This method will check the repetition of 
	 * @param a
	 * @return
	 */
	private static boolean validateRepetition(char[] a){

		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			if(a[i]=='I'){
				counterI++;
				counterX = 0;
				counterC = 0;
				counterM = 0;
			}else if(a[i]=='X'){
				counterI = 0;
				counterX++;
				counterC = 0;
				counterM = 0;
			}else if(a[i]=='C'){
				counterI = 0;
				counterX = 0;
				counterC++;
				counterM = 0;
			}else if(a[i]=='M'){
				counterI = 0;
				counterX = 0;
				counterC = 0;
				counterM++;
			}else if(a[i]=='D'){
				counterD++;
			}else if(a[i]=='L'){
				counterL++;
			}else if(a[i]=='V'){
				counterV++;
			}
			if(counterI >3 || counterX >3 || counterC >3 || counterM >3 || counterD>1 || counterL>1|| counterV>1 ){
				flag = true;
				break;
			}
			else
				flag = false;
		}

		return flag;
	}

	/**
	 * This method will help to reset all the counter variables.
	 */
	private static void resetCounters(){
		counterI = 0;
		counterX = 0;
		counterC = 0;
		counterM = 0;
		counterD = 0;
		counterL = 0;
		counterV = 0;
		//		System.out.println("Counter reseted.");
	}

}
