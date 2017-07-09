/**
 * 
 */
package com.guide.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Sanket Gupta
 *
 */
public class GuideUtilsTest {

	/**
	 * Test method for {@link com.guide.utils.GuideUtils#romanToNum(java.lang.String)}.
	 */
	@Test
	public void testRomanToNum() {
		String romanValue = "MCMIII";
		assertEquals(new Integer(1903), GuideUtils.romanToNum(romanValue));
	}

	/**
	 * Test method for {@link com.guide.utils.GuideUtils#stringListTrimmer(java.util.List)}.
	 */
	@Test
	public void testStringListTrimmer() {
		List<String> list = new ArrayList<String>();
		list.add("  Test string     ");
		list.add("Guide to galaxy");
		
		final List<String> testList = GuideUtils.stringListTrimmer(list);
		String [] expected = {"Test string","Guide to galaxy"};
		assertArrayEquals(testList.toArray(), expected);
	}

}
