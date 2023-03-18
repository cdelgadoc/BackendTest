package com.applydigital.challenge.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UtilDate {
	
	private static Logger logger = LogManager.getLogger(UtilDate.class);
	
	public static Map<Integer, String> months;

	static {
		months = new HashMap<>();
		months.put(Months.JANUARY.getPosition(), Months.JANUARY.getName());
		months.put(Months.FEBRUARY.getPosition(), Months.FEBRUARY.getName());
		months.put(Months.MARCH.getPosition(), Months.MARCH.getName());
		months.put(Months.APRIL.getPosition(), Months.APRIL.getName());
		months.put(Months.MAY.getPosition(), Months.MAY.getName());
		months.put(Months.JUNE.getPosition(), Months.JUNE.getName());
		months.put(Months.JULY.getPosition(), Months.JULY.getName());
		months.put(Months.AUGUST.getPosition(), Months.AUGUST.getName());
		months.put(Months.SEPTEMBER.getPosition(), Months.SEPTEMBER.getName());
		months.put(Months.OCTOBER.getPosition(), Months.OCTOBER.getName());
		months.put(Months.NOVEMBER.getPosition(), Months.NOVEMBER.getName());
		months.put(Months.DECEMBER.getPosition(), Months.DECEMBER.getName());
	}

	/**
	 * Return the name of the month extract from a string date ISO 8601
	 * 
	 * @param date
	 * @return name of the month
	 */
	public static String getMonthName(String date) {
		try {
			LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME);
			return months.get(localDate.getMonthValue());
		} catch (DateTimeParseException e) {
			logger.info(e.getMessage());
			return null;
		}
	}
	
}
