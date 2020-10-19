package com.guiabolso.MockTransaction.helpers;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class DateHelper {

	public LocalDate stringToLocalDate(String value, String pattern) {
		LocalDate date = null;

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			date =  LocalDate.from(formatter.parse((String)value));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public LocalDate dateToLocalDate(Date date) {
		return date.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
	}

	public static String localDateToString(LocalDate value, String pattern) {
		String date = null;

		try {
			date = DateTimeFormatter.ofPattern(pattern).format(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public String localDateTimeToString(LocalDateTime value, String pattern) {
		String date = null;

		try {
			date = DateTimeFormatter.ofPattern(pattern).format(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public String dateToString(Date value, String pattern) {
		String date = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			date = sdf.format(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}

	public static Long diffMinutes(LocalDateTime startDate, LocalDateTime endDate) {
		Duration dur = Duration.between(startDate, endDate);

		return TimeUnit.MILLISECONDS.toMinutes(dur.toMillis());
	}

}
