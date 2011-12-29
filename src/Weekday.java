
public class Weekday {
	static String num2week(int correction) {
		switch (correction) {
			case 0: return "Sunday";
			case 1: return "Monday";
			case 2: return "Tuesday";
			case 3: return "Wednesday";
			case 4: return "Thursday";
			case 5: return "Friday";
			case 6: return "Saturday";
			default : return "This day does NOT exist.";
		}
	}
	
	public static void main(String[] args) {	
		boolean istheCommonEra = false;
		int year = 1, month = 2, day = 30;
		String weekday = num2week(RomanCalendar.correction(istheCommonEra, year, month, day));
		System.out.println(weekday);
	}
}
