package com.ubs.opsit.interviews.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TimeUtilTest extends TimeUtil{
	
	
	@Test
	public void validateInputTimeFormatTest() {
		String aTime = "20:00:00";
		assertTrue(validateInputTimeFormat(aTime));
	}
	
	@Test
	public void invalidateInputTimeFormatTest() {
		String aTime = "000:00:00";
		assertFalse(validateInputTimeFormat(aTime));
	}
	
	@Test
	public void invalidateInputTimeFormatWithCharacterTest() {
		String aTime = "aa:bb:00";
		assertFalse(validateInputTimeFormat(aTime));
	}
	
	@Test
	public void validateHoursTest() {
		assertTrue(validateHours(23));
		assertFalse(validateHours(40));
	}
	
	@Test
	public void validateMinutesTest() {
		assertTrue(validateHours(23));
		assertFalse(validateHours(79));
	}
	
	
	@Test
	public void validateSecondsTest() {
		assertTrue(validateHours(23));
		assertFalse(validateHours(78));
	}
	
	@Test
	public void stringFormatTest() {
		assertTrue(stringFormat('Y',3,4 ).equals("YYYO") );
	}
	
	@Test
	public void invalidStringFormatTest() {
		assertTrue(stringFormat('Y',5,4 ).equals("") );
	}
	
	@Test
	public void changeToRedIfYellowTest() {
		char[] str ="YYYYYYYY".toCharArray();
		int[] index = {2,3,4};
		String ssss =  changeToRedIfYellow(str, index);
		assertTrue(changeToRedIfYellow(str, index).equals("YYRRRYYY"));
	}
}

