package statisticker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import statisticker.alerter.EmailAlert;
import statisticker.alerter.IAlerter;
import statisticker.alerter.LEDAlert;

/**
 * @author msp5cob Test class for Statistics project
 */
public class StatisticsTest {

  /**
   * Verify arithmetic operations
   */
  @Test
  public void reportsAverageMinMaxx() {
    Float[] numbers = { 1.5f, 8.9f, 3.2f, 4.5f };
    List<Float> numberList = Arrays.asList(numbers);

    Statistics.Stats s = Statistics.getStatistics(numberList);

    float epsilon = 0.001f;
    assertEquals(4.525f, s.getAverage(), epsilon);
    assertEquals(1.5f, s.getMin(), epsilon);
    assertEquals(8.9f, s.getMax(), epsilon);
  }

  /**
   * verify for NaN values
   */
  @Test
  public void reportsNaNForEmptyInput() {
    // All fields of computedStats (average, max, min) must be
    // Float.NaN (not-a-number), as described in
    // https://www.geeksforgeeks.org/nan-not-number-java/
    // Design the asserts here and implement accordingly.
    List<Float> emptyList = new ArrayList<>();

    Statistics.Stats s = Statistics.getStatistics(emptyList);

    float epsilon = 0.0f;
    assertEquals(Float.NaN, s.getAverage(), epsilon);
    assertEquals(Float.NaN, s.getMin(), epsilon);
    assertEquals(Float.NaN, s.getMax(), epsilon);

  }

  /**
   * verify Threshold limit alert
   */
  @Test
  public void reportsAlertsIfMaxIsMoreThanThreshold() {
    EmailAlert emailAlerter = new EmailAlert();
    LEDAlert ledAlerter = new LEDAlert();
    IAlerter alerters[] = { emailAlerter, ledAlerter };
    float maxThreshold = 10.2f;
    StatsChecker checker = new StatsChecker(maxThreshold, alerters);

    Float[] numbers = { 11.5f, 6.9f, 7.5f, 6.6f };
    List<Float> numberList = Arrays.asList(numbers);
    checker.checkAndAlert(numberList);

    assertTrue(emailAlerter.isEmailSent());
    assertTrue(ledAlerter.isLedGlows());
  }

  /**
   * verify when Threshold limit not reached
   */
  @Test
  public void checkAlertsIfMaxIsLessThanOrEqualToThreshold() {
    EmailAlert emailAlerter = new EmailAlert();
    LEDAlert ledAlerter = new LEDAlert();
    IAlerter alerters[] = { emailAlerter, ledAlerter };
    float maxThreshold = 11.5f;
    StatsChecker checker = new StatsChecker(maxThreshold, alerters);

    Float[] numbers = { 11.5f, 6.9f, 7.5f, 6.6f };
    List<Float> numberList = Arrays.asList(numbers);
    checker.checkAndAlert(numberList);

    assertFalse(emailAlerter.isEmailSent());
    assertFalse(ledAlerter.isLedGlows());
  }
}
