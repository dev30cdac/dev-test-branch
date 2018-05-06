package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.domain.BerlinClock;
import com.ubs.opsit.interviews.domain.TimeObject;
import com.ubs.opsit.interviews.service.TimeConverterService;
import com.ubs.opsit.interviews.util.TimeConstants;

public class TimeConverterServiceTest extends TimeConverterService {

	@Test(expected = IllegalArgumentException.class)
	public void invalidTimeObjectTest() {
		String aTime = "aa:bb:00";
		parseToTimeObject(aTime);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidTimeObjectWithTimeFormatTest() {
		String aTime = "000:34:200";
		parseToTimeObject(aTime);
	}

	@Test
	public void MidnightTest() {
		String aTime = "00:00:00";
		TimeObject time = parseToTimeObject(aTime);
		assert (time.getHours() == 0);
		assert (time.getMinutes() == 0);
		assert (time.getSeconds() == 0);

		BerlinClock berlinClock = convertTimeObjectToBerlinClock(time);
		assertEquals(berlinClock.getYellowLamp(), TimeConstants.YELLOW_FORMAT_CHAR.toString());
		assertEquals(berlinClock.getFirstHourRow(), "OOOO");
		assertEquals(berlinClock.getSecondHourRow(), "OOOO");
		assertEquals(berlinClock.getThirdMinuteRow(), "OOOOOOOOOOO");
		assertEquals(berlinClock.getFourthMinuteRow(), "OOOO");
	}

	@Test
	public void middleofAfternoonTest() {
		String aTime = "13:17:01";

		TimeObject time = parseToTimeObject(aTime);
		assert (time.getHours() == 13);
		assert (time.getMinutes() == 17);
		assert (time.getSeconds() == 1);

		BerlinClock berlinClock = convertTimeObjectToBerlinClock(time);
		assertEquals(berlinClock.getYellowLamp(), TimeConstants.DEFAULT_FORMAT_CHAR.toString());
		assertEquals(berlinClock.getFirstHourRow(), "RROO");
		assertEquals(berlinClock.getSecondHourRow(), "RRRO");
		assertEquals(berlinClock.getThirdMinuteRow(), "YYROOOOOOOO");
		assertEquals(berlinClock.getFourthMinuteRow(), "YYOO");
	}

	@Test
	public void justBeforeMidnightTest() {
		String aTime = "23:59:59";
		TimeObject time = parseToTimeObject(aTime);
		assert (time.getHours() == 23);
		assert (time.getMinutes() == 59);
		assert (time.getSeconds() == 59);

		BerlinClock berlinClock = convertTimeObjectToBerlinClock(time);
		assertEquals(berlinClock.getYellowLamp(), TimeConstants.DEFAULT_FORMAT_CHAR.toString());
		assertEquals(berlinClock.getFirstHourRow(), "RRRR");
		assertEquals(berlinClock.getSecondHourRow(), "RRRO");
		assertEquals(berlinClock.getThirdMinuteRow(), "YYRYYRYYRYY");
		assertEquals(berlinClock.getFourthMinuteRow(), "YYYY");
	}

	@Test
	public void midNightTest() {
		String aTime = "24:00:00";
		TimeObject time = parseToTimeObject(aTime);
		assert (time.getHours() == 24);
		assert (time.getMinutes() == 0);
		assert (time.getSeconds() == 0);
		
		BerlinClock berlinClock = convertTimeObjectToBerlinClock(time);
		assertEquals(berlinClock.getYellowLamp(), TimeConstants.YELLOW_FORMAT_CHAR.toString());
		assertEquals(berlinClock.getFirstHourRow(), "RRRR");
		assertEquals(berlinClock.getSecondHourRow(), "RRRR");
		assertEquals(berlinClock.getThirdMinuteRow(), "OOOOOOOOOOO");
		assertEquals(berlinClock.getFourthMinuteRow(), "OOOO");
	}
	
	@Test
	public void invalidInputTest() {
		String aTime = "aa:66:900";
		String result = convertTime(aTime);
		assertEquals(result, TimeConstants.ERROR_MESSAGE);
		
	}

}
