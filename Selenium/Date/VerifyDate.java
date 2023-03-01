package Date;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class VerifyDate {
	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String startDate = LocalDate.parse("20170220", DateTimeFormatter.BASIC_ISO_DATE)
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String closeDate = LocalDate.parse("20211224", DateTimeFormatter.BASIC_ISO_DATE)
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		String startDatePlus = LocalDate.parse("20170228", DateTimeFormatter.BASIC_ISO_DATE)
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		int month = Integer.parseInt(startDatePlus.substring(3, 5));
		int year = Integer.parseInt(startDatePlus.substring(7, 10));
		int nextMonth = month + 1;
		java.util.Date date1 = null;
		java.util.Date date2 = null;
		java.util.Date date = null;
		try {
			date1 = dateFormat.parse(startDate);
			date2 = dateFormat.parse(closeDate);
			date = dateFormat.parse(startDatePlus);
			long day = (date2.getTime() - date1.getTime()) / (24 * 3600 * 1000);
			System.out.println("tong so ngay cach nhau :" + day);
			int numberOfDayInTheMonth = numberDay(month, year);
			int numberOfDayInTheNextMonth = numberDay(nextMonth, year);
			int dayNum = numberOfDayInTheNextMonth - numberOfDayInTheMonth;
			Calendar c1 = Calendar.getInstance();
			c1.setTime(date);
			c1.roll(Calendar.MONTH, 1);
			c1.roll(Calendar.DAY_OF_MONTH, dayNum);
			String value = dateFormat.format(c1.getTime());
			System.out.println(
					"ngay thang tiep Theo: " + value.substring(6, 10) + value.substring(3, 5) + value.substring(0, 2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	}

	public static int numberDay(int month, int year) {
		int day = 0;
		switch (month) {
		case 1:
		case 2:
			if (checkYear(year)) {
				day = 29;
			} else {
				day = 28;
			}
			break;
		case 3:
			day = 31;
			break;
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			day = 31;
			break;
		default:
		}
		return day;
	}
}
