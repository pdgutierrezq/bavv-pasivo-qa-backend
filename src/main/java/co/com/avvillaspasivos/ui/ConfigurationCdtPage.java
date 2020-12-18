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

public class ConfigurationCdtPage {
  private ConfigurationCdtPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target BOTON_CONTINUAR =
      Target.the("Boton continuar direccion")
          .located(By.xpath("//button[contains(text(),'CONTINUAR')]"));

  public static final Target TEXT_TASA = Target.the("Valor tasa").located(By.className("rate"));

  public static final Target TEXTBOX_MONTO = Target.the("TextBox monto").locatedBy("#Amount");

  public static final Target TEXTBOX_PLAZO = Target.the("TextBox plazo").locatedBy("#Term");

  public static final Target RADIO_NO_RENOVAR =
      Target.the("Radio button no renovar")
          .located(By.xpath("//mat-radio-button[contains(*,'No')]"));

  public static final Target RADIO_SI_RENOVAR =
      Target.the("Radio button no renovar")
          .located(By.xpath("//mat-radio-button[contains(*,'Si')]"));
}
