/**
 * 
 */
package com.dg.daterange;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import com.dg.daterange.model.DateRange;

/**
 * @author johnver
 * 
 */
public class DateRangeTaskMain {

	private static final Logger logger = Logger
			.getLogger(DateRangeTaskMain.class.getName());

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Calendar startDateCalendar = new GregorianCalendar(2010, 8, 1);
		final Calendar endDateCalendar = new GregorianCalendar(2010, 9, 1);
		final Calendar inRangeDate = new GregorianCalendar(2010, 8, 20);
		final DateRange dateRange = new DateRange(startDateCalendar.getTime(),
				endDateCalendar.getTime());
		logger.info("startDate: " + dateRange.getStartDate());
		logger.info("endDate: " + dateRange.getEndDate());
		logger.info("dateRange.getDaysBetween: " + dateRange.getDaysBetween());
		logger.info("dateRange.getMonthsBetween: "
				+ dateRange.getMonthsBetween());
		logger.info("dateRange.isInRange: "
				+ dateRange.isInRange(inRangeDate.getTime()));
	}

}
