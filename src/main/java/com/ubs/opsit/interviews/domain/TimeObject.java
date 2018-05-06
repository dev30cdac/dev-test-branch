package com.ubs.opsit.interviews.domain;

import com.ubs.opsit.interviews.util.TimeConstants;

public class TimeObject {

	private  int hours;
	private  int minutes;
	private  int seconds;
	private boolean isActive = true;
	
	public TimeObject(int hours,int minutes,int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getHours() {
		return hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//String status = this.isActive?"On":"Off";
		return TimeConstants.TIME +
				+ this.getHours() + TimeConstants.COLON
				+ this.getMinutes() + TimeConstants.COLON
				+ this.getSeconds() ;
	}
}
