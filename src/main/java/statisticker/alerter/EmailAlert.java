/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package statisticker.alerter;


/**
 * @author msp5cob
 */
public class EmailAlert implements IAlerter {

  private boolean emailSent;


  /**
   * @return the emailSent
   */
  public boolean isEmailSent() {
    return this.emailSent;
  }


  /**
   * @param emailSent the emailSent to set
   */
  public void setEmailSent(final boolean emailSent) {
    this.emailSent = emailSent;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public void setAlert() {
    this.emailSent = true;
  }

}
