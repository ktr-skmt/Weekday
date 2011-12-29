
public interface CalendarInterface {
	boolean isCalendar(boolean istheCommonEra, int year, int month, int day);
	boolean istheCommonEra(int year, int month, int day);
	boolean isBeforetheCommonEra(int year, int month, int day);
	boolean isYear(int year);
	boolean isLeapYear(boolean istheCommonEra, int year);
	boolean isLeapYearOftheCommonEra(int year);
	boolean isLeapYearOfBeforetheCommonEra(int year);
	boolean isMonth(int month);
	boolean isDay(boolean isLeapYear, int month, int day);
	int getParameterForYearCorrection(boolean istheCommonEra, int month);
	int correctedByYear(int year, int parameter);
	int correctedByMonth(int month);
	int correctedByDay(int day);
	int correctedBytheCommonEra(int year, int month, int day);
	int correctedByBeforetheCommonEra(int year, int month, int day);
	int correctedByCalendar = 0;
	int correction(boolean istheCommonEra, int year, int month, int day);
}
