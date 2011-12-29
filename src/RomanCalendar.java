
public class RomanCalendar {
	static int correction(boolean istheCommonEra, int year, int month, int day) {
		return October1582.isAfterOctober1582(istheCommonEra, year, month, day) 
			? (new GregorianCalendar()).correction(istheCommonEra, year, month, day)
			: (new JulianCalendar()).correction(istheCommonEra, year, month, day);
	}
	
	static boolean isCalendar(boolean istheCommonEra, int year, int month, int day) {
		return CE45.isAfter46CE(istheCommonEra, year)
			? October1582.isOctober1582(istheCommonEra, year, month, day)
				? false
				: October1582.isAfterOctober1582(istheCommonEra, year, month, day)
					?(new GregorianCalendar()).isCalendar(istheCommonEra, year, month, day)
					:(new JulianCalendar()).isCalendar(istheCommonEra, year, month, day)
			: false;
	}
}
