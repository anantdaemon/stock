package com.stockexample.stock.dto;

public class DateData {

	private String loadDate;
	private int dayOfWeek;
	private int weekOfMonth;
	private int weekOfYear;

	public DateData() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the loadDate
	 */
	public String getLoadDate() {
		return loadDate;
	}

	/**
	 * @param loadDate the loadDate to set
	 */
	public void setLoadDate(String loadDate) {
		this.loadDate = loadDate;
	}

	/**
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the weekOfMonth
	 */
	public int getWeekOfMonth() {
		return weekOfMonth;
	}

	/**
	 * @param weekOfMonth the weekOfMonth to set
	 */
	public void setWeekOfMonth(int weekOfMonth) {
		this.weekOfMonth = weekOfMonth;
	}

	/**
	 * @return the weekOfYear
	 */
	public int getWeekOfYear() {
		return weekOfYear;
	}

	/**
	 * @param weekOfYear the weekOfYear to set
	 */
	public void setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

}
