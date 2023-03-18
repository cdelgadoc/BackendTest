package com.applydigital.challenge.utils;

public enum Months {
	JANUARY(1, "january"),
	FEBRUARY(2, "february"),
	MARCH(3, "march"),
	APRIL(4, "april"),
	MAY(5, "may"),
	JUNE(6, "june"),
	JULY(7, "july"),
	AUGUST(8, "august"),
	SEPTEMBER(9, "september"),
	OCTOBER(10, "october"),
	NOVEMBER(11, "november"),
	DECEMBER(12, "december");
	
    private final int position;
    private final String name;

    Months(int position, String name) {
        this.position = position;
        this.name = name;
    }

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

}
