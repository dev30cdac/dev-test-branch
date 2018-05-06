package com.ubs.opsit.interviews.domain;

import org.apache.commons.lang.text.StrBuilder;

public class BerlinClock {

	private String yellowLamp;
	private String firstHourRow;
	private String secondHourRow;
	private String thirdMinuteRow;
	private String fourthMinuteRow;

	public BerlinClock(String yellowLamp, String firstHourRow, String secondHourRow, String thirdMinuteRow,
			String fourthMinuteRow) {
		this.yellowLamp = yellowLamp;
		this.firstHourRow = firstHourRow;
		this.secondHourRow = secondHourRow;
		this.thirdMinuteRow = thirdMinuteRow;
		this.fourthMinuteRow = fourthMinuteRow;
	}

	public String getYellowLamp() {
		return yellowLamp;
	}

	public String getFirstHourRow() {
		return firstHourRow;
	}

	public String getSecondHourRow() {
		return secondHourRow;
	}

	public String getThirdMinuteRow() {
		return thirdMinuteRow;
	}

	public String getFourthMinuteRow() {
		return fourthMinuteRow;
	}

	public String toString() {

		return new StrBuilder().appendWithSeparators(
				new String[] { yellowLamp, firstHourRow, secondHourRow, thirdMinuteRow, fourthMinuteRow },
				System.lineSeparator()).toString();
	}

}
