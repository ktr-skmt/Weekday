
public class TestForWeekday extends Weekday {
/*
	static void testForWeekday(boolean istheCommonEra, int year, int month, int day) {
		System.out.println("istheCommonEra: "+istheCommonEra+", year: "+year+", month: "+month+", day: "+day);
		System.out.println("parameter: "+getParameterForYear(istheCommonEra, month));
		if (isGregorianCalendar(istheCommonEra, year, month, day)) {
			System.out.println("This is Gregorian Calendar.");
		} else {
			System.out.println("This is NOT Gregorian Calendar");
			if (istheCommonEra) {
				if (istheCommonEra(year, month, day)) {
					System.out.println("This is exactly the Common Era.");
				} else {
					System.out.println("This is NOT the Common Era, although istheCommonEra value is true.");
				}
			} else {
				if (isBeforetheCommonEra(year, month, day)) {
					System.out.println("This is exactly Before the Common Era.");
				} else {
					System.out.println("This is NOT Before the Common Era, although istheCommonEra value is false.");
				}
			}
			test2(istheCommonEra, year, month, day);
		}
		testForCorrection(istheCommonEra, year, month, day);
	}
	static void test2(boolean istheCommonEra, int year, int month, int day) {
		if (isYear(year)) {
			System.out.println("This year is exactly year.");
		} else {
			System.out.println("This year is NOT year, because this is less than 1.");
		}
		if (isMonth(month)) {
			System.out.println("This month is exactly month.");
		} else {
			System.out.println("This month is NOT month, because this is less than 1 or more than 12.");
		}
		if (isDay(isLeapYear(istheCommonEra, year), month, day)) {
			System.out.println("This day is exactly day.");
		} else {
			System.out.println("This is NOT day.");
		}
	}
	static void testForCorrection(boolean istheCommonEra, int year, int month, int day) {
		if (isLeapYear(istheCommonEra, year)) {
			System.out.println("This year is leap year.");
		} else {
			System.out.println("This year is not leap year.");
		}
		System.out.println("correction: "+correction(istheCommonEra, year, month, day));
		if (istheCommonEra) {
			System.out.println("correctedBytheCommonEra: "+correctedBytheCommonEra(year, month, day));
		} else {
			System.out.println("correctedByBeforetheCommonEra: "+correctedByBeforetheCommonEra(year, month, day));
		}
		System.out.println("correctedByYear: "+correctedByYear(year, getParameterForYear(istheCommonEra, month)));
		System.out.println("correctedByMonth: "+correctedByMonth(month));
		System.out.println("correctedByDay: "+correctedByDay(day));
		
	}
	
	
*/	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean istheCommonEra = true;
		int year = 1, month = 1, day = 1;
		String weekday = "error";
		//if (isGregorianCalendar(istheCommonEra, year, month, day))
			weekday = weekday(correction(istheCommonEra, year, month, day));
		testForWeekday(istheCommonEra, year, month, day);
		System.out.println(weekday);
	}
*/
}
