/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EnrollmentPage {

  private EnrollmentPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target PASSWORD_INPUT =
      Target.the("Campos de ingreso para clave")
          .located(By.xpath("//input[@type='password']"));

  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar enrolamiento")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
