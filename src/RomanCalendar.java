
public class RomanCalendar {
	static int correction(boolean istheCommonEra, int year, int month, int day) {
		return Calendar.isAfterOctober1582(istheCommonEra, year, month, day) 
			? GregorianCalendar.correction(istheCommonEra, year, month, day)
			: JulianCalendar.correction(istheCommonEra, year, month, day);
	}
	
	static boolean isCalendar(boolean istheCommonEra, int year, int month, int day) {
		return CE45.isAfter46CE(istheCommonEra, year)
			? Calendar.isOctober1582(istheCommonEra, year, month, day)
				? false
				: Calendar.isAfterOctober1582(istheCommonEra, year, month, day)
					?GregorianCalendar.isCalendar(istheCommonEra, year, month, day)
					:JulianCalendar.isCalendar(istheCommonEra, year, month, day)
			: false;
	}
}
