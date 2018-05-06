package com.ubs.opsit.interviews.service;

import org.apache.commons.lang.Validate;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.domain.BerlinClock;
import com.ubs.opsit.interviews.domain.TimeObject;
import com.ubs.opsit.interviews.util.TimeConstants;
import com.ubs.opsit.interviews.util.TimeUtil;

public class TimeConverterService implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		String result = "";
		try {
			
			TimeObject timeObj = parseToTimeObject(aTime);
			BerlinClock bclock = convertTimeObjectToBerlinClock(timeObj);
			return bclock.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = TimeConstants.ERROR_MESSAGE;
		}

		return result;
	}

	public TimeObject parseToTimeObject(String aTime) {
		Validate.isTrue(TimeUtil.validateInputTimeFormat(aTime), "Time format is invalid");
		String[] timeSplit = aTime.split(TimeConstants.COLON);
		int hours = Integer.parseInt(timeSplit[0]);
		int minutes = Integer.parseInt(timeSplit[1]);
		int seconds = Integer.parseInt(timeSplit[2]);
		// validating the Hours, minus and seconds data
		Validate.isTrue(TimeUtil.validateHours(hours) && TimeUtil.validateMinutes(minutes)
				&& TimeUtil.validateSeconds(seconds));
		return new TimeObject(hours, minutes, seconds);
	}
	public BerlinClock convertTimeObjectToBerlinClock(TimeObject time) {

		String topRow = TimeUtil.stringFormat(TimeConstants.YELLOW_FORMAT_CHAR, (time.getSeconds() + 1) % 2, 1);
		String firstHourRow = TimeUtil.stringFormat(TimeConstants.RED_FORMAT_CHAR, (int) (time.getHours() / 5), 4);
		String secondHourRow = TimeUtil.stringFormat(TimeConstants.RED_FORMAT_CHAR, time.getHours() % 5, 4);
		String thirdMinuteRow = TimeUtil.stringFormat(TimeConstants.YELLOW_FORMAT_CHAR, (int) (time.getMinutes() / 5),
				11);
		String fourthMinuteRow = TimeUtil.stringFormat(TimeConstants.YELLOW_FORMAT_CHAR, time.getMinutes() % 5, 4);
		// In this first row of minute the 3rd, 6th and 9th lamp are red and indicate
		// the first quarter,
		// half and last quarter of an hour. The other lamps are yellow
		int[] index = { 2, 5, 8 };

		thirdMinuteRow = TimeUtil.changeToRedIfYellow(thirdMinuteRow.toCharArray(), index);

		return new BerlinClock(topRow, firstHourRow, secondHourRow, thirdMinuteRow, fourthMinuteRow);
	}
}
