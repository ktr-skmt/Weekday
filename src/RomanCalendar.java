
public class RomanCalendar extends Calendar {
	GregorianCalendar gc = new GregorianCalendar();
	JulianCalendar jc = new JulianCalendar();
	
	public int correction(boolean istheCommonEra, int year, int month, int day) {
		return isCalendar(istheCommonEra, year, month, day)
			? isAfterOctober1582(istheCommonEra, year, month, day) 
				? gc.correction(istheCommonEra, year, month, day, gc.correctedByCalendar)
				: jc.correction(istheCommonEra, year, month, day, jc.correctedByCalendar)
			: -1;
	}
	
	public boolean isCalendar(boolean istheCommonEra, int year, int month, int day) {
		return isAfter46CE(istheCommonEra, year)
			? isOctober1582(istheCommonEra, year, month, day)
				? false
				: isAfterOctober1582(istheCommonEra, year, month, day)
					? gc.isCalendar(istheCommonEra, year, month, day)
					: jc.isCalendar(istheCommonEra, year, month, day)
			: false;
	}
}
