
abstract class Calendar {
	public int correctedByYear(int year, int parameter) { return 0; }
	public boolean isLeapYearOftheCommonEra(int year) { return false; };
	
	public int getParameterForYearCorrection(boolean istheCommonEra, int month) {
			int parameter = 0;
			if (!istheCommonEra) parameter++;
			if (month == 1 || month == 2) parameter++;
			return parameter;
	}
	
	public int correctedByMonth(int month) {
			if (month == 5) {
					return 1;
			} else if (month == 8) {
					return 2;
			} else if (month == 2 || month == 3 || month == 11) {
					return 3;
			} else if (month == 6) {
					return 4;
			} else if (month == 9 || month == 12) {
					return 5;
			} else if (month == 4 || month == 7) {
					return 6;
			} else {
					return 0;
			}
	}
	
	public int correctedByDay(int day) {
			return day;
	}
	
	public int correctedBytheCommonEra(int year, int month, int day, int correctedByCalendar) {
			int c = correctedByMonth(month)
							+ correctedByDay(day)
							+ correctedByYear(year, getParameterForYearCorrection(true, month))
							+ correctedByCalendar
							+ correctedByOctober1582(true, year, month, day);
			c %= 7;
			return c < 0 ? c + 7 : c;
	}
	
	public int correctedByBeforetheCommonEra(int year, int month, int day, int correctedByCalendar) {
			int c = correctedByMonth(month) 
							+ correctedByDay(day)
							+ correctedByYear(year, getParameterForYearCorrection(false, month))
							+ correctedByCalendar;
			c %= 7;
			return c < 0 ? c + 7 : c;
	}
	
	public int correction(boolean istheCommonEra, int year, int month, int day, int correctedByCalendar) {
			return istheCommonEra ? correctedBytheCommonEra(year, month, day, correctedByCalendar) : correctedByBeforetheCommonEra(year, month, day, correctedByCalendar);
	}
	
	//check
	public boolean isYear(int year) {
			return year > 0 ? true : false;
	}
	
	public boolean isLeapYear(boolean istheCommonEra, int year) {
			return istheCommonEra ? isLeapYearOftheCommonEra(year) : isLeapYearOfBeforetheCommonEra(year);
	}
	
	public boolean isLeapYearOfBeforetheCommonEra(int year) {
			return isLeapYearOftheCommonEra(year - 1);
	}
	
	public boolean isMonth(int month) {
			return month > 0 && month < 13 ? true : false;
	}
	
	public boolean isDay(boolean isLeapYear, int month, int day) {
			return day > 0
					? month == 4 || month == 6 || month == 9 || month == 11 
							? day < 31
									? true : false 
							: month == 2
									? isLeapYear 
											? day < 30 ? true : false
									    : day < 29 ? true : false
									: day < 32 ? true : false
					: false;
	}
	
	public boolean istheCommonEra(int year, int month, int day) {
			return isYear(year) && isMonth(month) && isDay(isLeapYear(true, year), month, day) && !isOctober1582(true, year, month, day);
	}
	
	public boolean isBeforetheCommonEra(int year, int month, int day) {
			return isYear(year) && isMonth(month) && isDay(isLeapYear(false, year), month, day);
	}
	
	public boolean isCalendar(boolean istheCommonEra, int year, int month, int day) {
			return istheCommonEra ? istheCommonEra(year, month, day) : isBeforetheCommonEra(year, month, day);
	}
	
	public int correctedByOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return isAfterOctober1582(istheCommonEra, year, month, day) ? -10 : 0; 
	}
	
	public boolean isOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return istheCommonEra && year == 1582 && month == 10 && day > 4 && day < 15 ? true : false;
	}
	
	public boolean isAfterOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return istheCommonEra && (year > 1582 || year == 1582 && (month > 10 || month == 10 && day > 14));
	}
	
	public boolean isAfter46CE(boolean istheCommonEra, int year) {
		return istheCommonEra ? true : year < 46 ? true : false;
	}
}
