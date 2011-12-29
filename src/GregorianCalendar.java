
public class GregorianCalendar extends Calendar {
	@Override static int correctedByCalendar = 2;
	
	@Override static int correctedByYear(int year, int parameter) {
		//year -= year / 10000 * 10000;
		year -= parameter;
		return year + year / 4 - year / 100 + year / 400 + parameter;
	}
	
	@Override static boolean isLeapYearOftheCommonEra(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) ? true : false;
	}
}
