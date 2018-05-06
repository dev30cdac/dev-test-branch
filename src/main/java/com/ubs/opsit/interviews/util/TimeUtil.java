package com.ubs.opsit.interviews.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
//import org.assertj.core.util.Preconditions;

public class TimeUtil {

	public static boolean validateInputTimeFormat(String time) {
		boolean isValidate = false;
		Validate.notNull(time, TimeConstants.NULL_VALUE);
		Pattern pattern = Pattern.compile(TimeConstants.TIME_FORMAT);
		Matcher match = pattern.matcher(time);
		if (match.find()) {
			isValidate = true;
		}

		return isValidate;
	}

	public static boolean validateHours(int hours) {
		return hours >= TimeConstants.HOURS_MIN_VALUE && hours <= TimeConstants.HOURS_MAX_VALUE;
	}

	public static boolean validateMinutes(int minutes) {
		return minutes >= TimeConstants.MINUTES_MIN_VALUE && minutes <= TimeConstants.MINUTES_MAX_VALUE;
	}

	public static boolean validateSeconds(int seconds) {
		return seconds >= TimeConstants.SECONDS_MIN_VALUE && seconds <= TimeConstants.SECONDS_MAX_VALUE;
	}

	/*
	 * stringFormat("Y", 3,4) = "YYYO" Size should be getter or equal to times
	 */
	public static String stringFormat(Character formatChar, int times, int size) {
		if (size < times) {
			return "";
		}
		return StringUtils.repeat(formatChar.toString(), times)
				+ StringUtils.repeat(TimeConstants.DEFAULT_FORMAT_CHAR.toString(), size - times);
	}

	public static String changeToRedIfYellow(char[] str, int[] index) {
		for (int i = 0; i < index.length; i++) {
			if (str[index[i]] == TimeConstants.YELLOW_FORMAT_CHAR) {
				str[index[i]] = TimeConstants.RED_FORMAT_CHAR;
			}
		}

		return new String(str);
	}
}
