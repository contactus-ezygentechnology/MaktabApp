package com.ezygentechnology.makhtab.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UTCDateUtility {

	private static Logger LOGGER = LoggerFactory.getLogger(UTCDateUtility.class);

	public static String getDateTime(String timeZone) {
		String currentDateTime = "";
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date datetime = new Date();

			LOGGER.info("Date Long>>>>" + datetime.getTime());

			LOGGER.info("date " + sdf.format(datetime));

			sdf.setTimeZone(TimeZone.getTimeZone("GMT+13"));

			LOGGER.info("GMT+13 " + sdf.format(datetime));

			if (timeZone.equalsIgnoreCase("UTC")) {

				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

				// System.out.println("utc "+sdf.format(datetime));

				currentDateTime = sdf.format(datetime);
			}
			if (timeZone.equalsIgnoreCase("GMT")) {

				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

				LOGGER.info("GMT " + sdf.format(datetime));

				currentDateTime = sdf.format(datetime);
			}

			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

			DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
			formatter.setTimeZone(TimeZone.getTimeZone("GMT+13"));

			String newZealandTime = formatter.format(calendar.getTime());

			// System.out.println("using calendar "+newZealandTime);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception " + e.getMessage());

		}

		return currentDateTime;
	}
	
	public static String getDateTime(String timeZone,String date) {
		String currentDateTime = "";
		try {
			
			

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date datetime = sdf.parse(date);

			LOGGER.info("Date Long>>>>" + datetime.getTime());

			LOGGER.info("date " + sdf.format(datetime));

			sdf.setTimeZone(TimeZone.getTimeZone("GMT+13"));

			LOGGER.info("GMT+13 " + sdf.format(datetime));

			if (timeZone.equalsIgnoreCase("UTC")) {

				sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

				// System.out.println("utc "+sdf.format(datetime));

				currentDateTime = sdf.format(datetime);
			}
			if (timeZone.equalsIgnoreCase("GMT")) {

				sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

				LOGGER.info("GMT " + sdf.format(datetime));

				currentDateTime = sdf.format(datetime);
			}

			Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

			DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
			formatter.setTimeZone(TimeZone.getTimeZone("GMT+13"));

			String newZealandTime = formatter.format(calendar.getTime());

			// System.out.println("using calendar "+newZealandTime);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception " + e.getMessage());

		}

		return currentDateTime;
	}

	public static Long getDateTime() {

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date datetime = new Date();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime.getTime();
	}

	public static Long convert2Long(String s) {

		Long lastupdated = 0L;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = simpleDateFormat.parse(s);
			lastupdated = date.getTime();
			// System.out.println("date :
			// "+simpleDateFormat.format(date)+">>>"+date.getTime());

		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.info("Exception " + ex);
		}

		return lastupdated;
	}

	public static Date convert2Date(Long s) {
		Date dt = new Date(s);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
		return sqlDate;
	}

	public static Long ddMMyyyy2Long(String s) {

		Long lastupdated = 0L;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = simpleDateFormat.parse(s);
			lastupdated = date.getTime();
			// System.out.println("date :
			// "+simpleDateFormat.format(date)+">>>"+date.getTime());

		} catch (ParseException ex) {
			LOGGER.error("Exception " + ex);
		}

		return lastupdated;
	}

	public static Long endDateddMMyyyy2Long(String s) {

		Long lastupdated = 0L;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		try {
			Date date = simpleDateFormat.parse(s);
			lastupdated = date.getTime();
			// System.out.println("date :
			// "+simpleDateFormat.format(date)+">>>"+date.getTime());

		} catch (ParseException ex) {
			LOGGER.error("Exception " + ex);
		}

		return lastupdated;
	}

}
