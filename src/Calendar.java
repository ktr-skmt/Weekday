
abstract class Calendar{
	static int correctedByCalendar;
	static int correctedByYear(int year, int parameter){return 0;}
	static boolean isLeapYearOftheCommonEra(int year){return false;};
	
	static int getParameterForYearCorrection(boolean istheCommonEra, int month) {
			int parameter = 0;
			if (!istheCommonEra) parameter++;
			if (month == 1 || month == 2) parameter++;
			return parameter;
	}
	
	static int correctedByMonth(int month) {
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
	
	static int correctedByDay(int day) {
			return day;
	}
	
	static int correctedBytheCommonEra(int year, int month, int day) {
			int c = correctedByMonth(month)
							+ correctedByDay(day)
							+ correctedByYear(year, getParameterForYearCorrection(true, month))
							+ correctedByCalendar
							+ correctedByOctober1582(true, year, month, day);
			c %= 7;
			return c < 0 ? c + 7 : c;
	}
	
	static int correctedByBeforetheCommonEra(int year, int month, int day) {
			int c = correctedByMonth(month) 
							+ correctedByDay(day)
							+ correctedByYear(year, getParameterForYearCorrection(false, month))
							+ correctedByCalendar;
			c %= 7;
			return c < 0 ? c + 7 : c;
	}
	
	static int correction(boolean istheCommonEra, int year, int month, int day) {
			return istheCommonEra ? correctedBytheCommonEra(year, month, day) : correctedByBeforetheCommonEra(year, month, day);
	}
	
	//check
	static boolean isYear(int year) {
			return year > 0 ? true : false;
	}
	
	static boolean isLeapYear(boolean istheCommonEra, int year) {
			return istheCommonEra ? isLeapYearOftheCommonEra(year) : isLeapYearOfBeforetheCommonEra(year);
	}
	
	static boolean isLeapYearOfBeforetheCommonEra(int year) {
			return isLeapYearOftheCommonEra(year - 1);
	}
	
	static boolean isMonth(int month) {
			return month > 0 && month < 13 ? true : false;
	}
	
	static boolean isDay(boolean isLeapYear, int month, int day) {
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
	
	static boolean istheCommonEra(int year, int month, int day) {
			return isYear(year) && isMonth(month) && isDay(isLeapYear(true, year), month, day) && !isOctober1582(true, year, month, day);
	}
	
	static boolean isBeforetheCommonEra(int year, int month, int day) {
			return isYear(year) && isMonth(month) && isDay(isLeapYear(false, year), month, day);
	}
	
	static boolean isCalendar(boolean istheCommonEra, int year, int month, int day) {
			return istheCommonEra ? istheCommonEra(year, month, day) : isBeforetheCommonEra(year, month, day);
	}
	static int correctedByOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return isAfterOctober1582(istheCommonEra, year, month, day) ? -10 : 0; 
	}
	
	static boolean isOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return istheCommonEra && year == 1582 && month == 10 && day > 4 && day < 15 ? true : false;
	}
	
	static boolean isAfterOctober1582(boolean istheCommonEra, int year, int month, int day) {
		return istheCommonEra && (year > 1582 || year == 1582 && (month > 10 || month == 10 && day > 14));
	}
}
