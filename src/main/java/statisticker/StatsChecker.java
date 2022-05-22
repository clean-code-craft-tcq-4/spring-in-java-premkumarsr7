/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker;

import java.util.List;

import statisticker.alerter.IAlerter;

/**
 * @author msp5cob
 */
public class StatsChecker {

  private final IAlerter alerters[];
  private final float maxThreshold;

  /**
   * @param alerters alerters
   * @param maxThreshold maxThreshold
   */
  public StatsChecker(final float maxThreshold, final IAlerter[] alerters) {
    this.alerters = alerters;
    this.maxThreshold = maxThreshold;
  }

  /**
   * @param numberList numbers
   */
  public void checkAndAlert(final List<Float> numberList) {
    for (Float number : numberList) {
      int compareResult = number.compareTo(this.maxThreshold);
      if (compareResult > 0) {
        for (IAlerter alerter : this.alerters) {
          alerter.setAlert();
        }
      }
    }

  }


}
