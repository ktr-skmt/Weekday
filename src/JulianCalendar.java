
public class JulianCalendar extends October1582 implements CalendarInterface {	
	public int correctedByCalendar = 4;
	
	public int getParameterForYearCorrection(boolean istheCommonEra, int month) {
		int parameter = 0;
		if (!istheCommonEra) parameter++;
		if (month == 1 || month == 2) parameter++;
		return parameter;
	}
	
	public int correctedByYear(int year, int parameter) {
		//year -= year / 10000 * 10000;
		year -= parameter;
		return year + year / 4 + parameter;
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
	
	public int correctedBytheCommonEra(int year, int month, int day) {
		int c = correctedByMonth(month)
				+ correctedByDay(day)
				+ correctedByYear(year, getParameterForYearCorrection(true, month))
				+ correctedByCalendar
				+ correctedByOctober1582(true, year, month, day);
		c %= 7;
		return c < 0 ? c + 7 : c;
	}
	
	public int correctedByBeforetheCommonEra(int year, int month, int day) {
		int c = correctedByMonth(month) 
				+ correctedByDay(day)
				+ correctedByYear(year, getParameterForYearCorrection(false, month))
				+ correctedByCalendar;
		c %= 7;
		return c < 0 ? c + 7 : c;
	}
	
	public int correction(boolean istheCommonEra, int year, int month, int day) {
		return istheCommonEra ? correctedBytheCommonEra(year, month, day) : correctedByBeforetheCommonEra(year, month, day);
	}
	
	//check
	public boolean isYear(int year) {
		return year > 0 ? true : false;
	}
	
	public boolean isLeapYear(boolean istheCommonEra, int year) {
		return istheCommonEra ? isLeapYearOftheCommonEra(year) : isLeapYearOfBeforetheCommonEra(year);
	}
	
	public boolean isLeapYearOftheCommonEra(int year) {
		return year % 4 == 0 ? true : false;
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
}
