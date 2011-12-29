
public class JulianCalendar extends Calendar {	
	static int correctedByCalendar = 4;
	
	static int correctedByYear(int year, int parameter) {
		//year -= year / 10000 * 10000;
		year -= parameter;
		return year + year / 4 + parameter;
	}
	
	static boolean isLeapYearOftheCommonEra(int year) {
		return year % 4 == 0 ? true : false;
	}
}
