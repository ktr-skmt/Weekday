
public class October1582 {
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
