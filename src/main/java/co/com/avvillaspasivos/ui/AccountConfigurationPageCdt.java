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

public class AccountConfigurationPageCdt {
  private AccountConfigurationPageCdt() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target PSE_BUTTON =
      Target.the("Boton ir a Pse")
      .located(By.linkText("Link PSE"));

  public static final Target SENDING_CARD_LINK =
      Target.the("Link ir a Datos Tarjeta")
      .located(By.linkText("Link Datos Tarjeta"));

  public static final Target BOTON_CONTINUAR =
      Target.the("Boton continuar direccion")
          .located(By.xpath("//button[contains(text(),'Continuar')]"));

public static final Target BOTON_POPUP_SI =
      Target.the("Boton continuar direccion")
          .locatedBy(".avv-btn-primary");

  public static final Target RADIO_CUENTA_TRANSFERIR =
      Target.the("Radio de la cuenta que se va a transferir")
          .located(
              By.xpath(
                  "(//*[@formcontrolname='accountSettingFirstGroup']//mat-radio-button[contains(*,'Cuenta')])[1]"));
  public static final Target RADIO_CUENTA_RENDIMIENTOS =
      Target.the("Radio de la cuenta que se va a pagar rendimienitos")
          .located(
              By.xpath(
                  "(//*[@formcontrolname='accountSettingSecondGroup']//mat-radio-button[contains(*,'Cuenta')])[1]"));
}
