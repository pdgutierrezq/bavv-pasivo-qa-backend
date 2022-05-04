/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class EnrollmentPage {

  private EnrollmentPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target PASSWORD_INPUT =
      Target.the("Campos de ingreso para clave")
          .located(xpath("//input[@type='password']"));

  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar enrolamiento")
          .locatedBy("#ChannelEnrollmentButton");

  public static final Target POPUP_BUTTON =
      Target.the("Boton entendido pop up enrolamiento")
          .located(By.buttonText("ENTENDIDO"));

}
