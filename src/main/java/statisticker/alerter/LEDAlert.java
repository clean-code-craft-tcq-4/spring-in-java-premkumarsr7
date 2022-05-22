/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker.alerter;


/**
 * @author msp5cob
 */
public class LEDAlert implements IAlerter {

  private boolean ledGlows;


  /**
   * @return the ledGlows
   */
  public boolean isLedGlows() {
    return this.ledGlows;
  }


  /**
   * @param ledGlows the ledGlows to set
   */
  public void setLedGlows(final boolean ledGlows) {
    this.ledGlows = ledGlows;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void setAlert() {
    this.ledGlows = true;
  }

}
