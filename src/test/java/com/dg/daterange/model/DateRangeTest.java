/**
 * 
 */
package com.dg.daterange.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author johnver
 * 
 */
public class DateRangeTest {

	/**
	 * @throws java.lang.Exception
	 */
	private DateRangeTestFixture testFixture;

	@Before
	public void setUp() {
		this.testFixture = new DateRangeTestFixture();
	}

	@Test
	public void should_accept_valid_dates() {
		this.testFixture.given_a_valid_dates();
		this.testFixture.when_the_object_is_instantiated();
		this.testFixture.then_the_result_should_be_true();
	}

	@Test
	public void should_not_accept_null_dates() {
		this.testFixture.given_a_null_dates();
		this.testFixture.when_the_object_is_instantiated();
		this.testFixture.then_the_result_should_be_false();
	}

	@Test
	public void should_not_accept_null_start_date() {
		this.testFixture.given_a_null_start_date();
		this.testFixture.when_the_object_is_instantiated();
		this.testFixture.then_the_result_should_be_false();
	}

	@Test
	public void should_not_accept_null_end_date() {
		this.testFixture.given_a_null_end_date();
		this.testFixture.when_the_object_is_instantiated();
		this.testFixture.then_the_result_should_be_false();
	}

	@Test
	public void should_not_accept_invalid_dates() {
		this.testFixture.given_an_invalid_dates();
		this.testFixture.when_the_object_is_instantiated();
		this.testFixture.then_the_result_should_be_false();
	}

	class DateRangeTestFixture {

		private Date startDate;
		private Date endDate;

		private DateRange dateRange;

		private boolean result;

		DateRangeTestFixture() {

		}

		public void given_a_valid_dates() {

			final int daysDiff = 5;

			final Calendar today = new GregorianCalendar();
			final Calendar fiveDaysAgo = new GregorianCalendar(
					today.get(Calendar.YEAR), today.get(Calendar.MONTH),
					today.get(Calendar.DAY_OF_MONTH) - daysDiff);

			this.startDate = fiveDaysAgo.getTime();
			this.endDate = today.getTime();

		}

		public void given_a_null_dates() {

			this.startDate = null;
			this.endDate = null;

		}

		public void given_a_null_start_date() {

			final Calendar today = new GregorianCalendar();
			this.startDate = null;
			this.endDate = today.getTime();

		}

		public void given_a_null_end_date() {

			final Calendar today = new GregorianCalendar();
			this.startDate = today.getTime();
			this.endDate = null;

		}

		public void given_an_invalid_dates() {

			final Calendar today = new GregorianCalendar();
			final Calendar dateYesterday = new GregorianCalendar(
					today.get(Calendar.YEAR), today.get(Calendar.MONTH),
					today.get(Calendar.DAY_OF_MONTH) - 1);
			this.startDate = today.getTime();
			this.endDate = dateYesterday.getTime();

		}

		public void when_the_object_is_instantiated() {
			try {
				this.dateRange = new DateRange(this.startDate, this.endDate);
				this.result = true;
			} catch (final Exception e) {
				this.result = false;
			}

		}

		public void then_the_result_should_be_true() {
			Assert.assertTrue(this.result == true);
		}

		public void then_the_result_should_be_false() {
			Assert.assertTrue(this.result == false);
		}
	}
}
