/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InsuranceOfferPage {
  private InsuranceOfferPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target RADIO_ACCEPT_INSURANCE =
      Target.the("Radio Button acepta seguro")
          .located(By.xpath("//mat-radio-button[@value='true']"));
  public static final Target RADIO_REJECT_INSURANCE =
      Target.the("Radio Button rechaza seguro")
          .located(By.xpath("//mat-radio-button[@value='false']"));
  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar oferta seguros")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
    public static final Target UNDERSTOOD_POP_UP_BUTTON =
        Target.the("Boton entendido pop up")
            .located(By.xpath("//button[contains(text(),'ENTENDIDO')]"));
  public static final Target LINK_SEE_MORE =
      Target.the("Enlace ver mas oferta seguros")
          .located(By.xpath("//span[text()='Ver más']"));
  public static final Target POP_UP_SEE_MORE =
      Target.the("Pop up ver mas oferta seguros")
          .located(By.xpath("//*[@role='dialog']"));
}
