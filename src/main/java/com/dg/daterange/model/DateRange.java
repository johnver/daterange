/**
 * 
 */
package com.dg.daterange.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author johnver
 * 
 */
public final class DateRange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Date startDate;
	private final Date endDate;

	/**
	 * This constructor accepts the startDate and endDate of the range.
	 * 
	 * @param startDate
	 * @param endDate
	 */
	public DateRange(final Date startDate, final Date endDate) {
		this.validate(startDate, endDate);
		this.startDate = this.truncate(startDate);
		this.endDate = this.truncate(endDate);

	}

	private void validate(final Date startDate, final Date endDate) {
		if (startDate == null || endDate == null) {
			throw new IllegalArgumentException(
					"startDate or endDate should not be null.");
		}

		if (startDate.after(endDate)) {
			throw new IllegalArgumentException(
					"startDate must be less than endDate");
		}
	}

	private Date truncate(final Date aDate) {

		final Calendar calendar = new GregorianCalendar();
		calendar.setTime(aDate);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.endDate == null) ? 0 : this.endDate.hashCode());
		result = prime * result
				+ ((this.startDate == null) ? 0 : this.startDate.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final DateRange other = (DateRange) obj;
		if (this.endDate == null) {
			if (other.endDate != null) {
				return false;
			}
		} else if (!this.endDate.equals(other.endDate)) {
			return false;
		}
		if (this.startDate == null) {
			if (other.startDate != null) {
				return false;
			}
		} else if (!this.startDate.equals(other.startDate)) {
			return false;
		}
		return true;
	}

}
