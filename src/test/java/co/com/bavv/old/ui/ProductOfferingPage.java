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

public class ProductOfferingPage {
  private ProductOfferingPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target TITLE_PRODUCT_OFFERING =
      Target.the("Titulo Card cuentas").located(By.xpath("//p[contains(text(),'la Cuenta')]"));
  public static final Target FIRST_CARD =
      Target.the("Primera Card en pantalla").located(By.xpath("(//mat-radio-button)[1]"));
  public static final Target RADIO_SIMPLE =
      Target.the("Card cuenta simple")
          .located(By.xpath("//mat-radio-button[contains(*,'SIMPLE')]"));
  public static final Target RADIO_CIRCLE_PRO =
      Target.the("Radio Button cuenta pro").located(By.xpath("//input[@value='CUENTA_PRO']"));
  public static final Target RADIO_CIRCLE_SIMPLE =
      Target.the("Radio Button cuenta simple").located(By.xpath("//input[@value='CUENTA_SIMPLE']"));
  public static final Target RADIO_PRO =
      Target.the("Card cuenta Digital").located(By.xpath("//mat-radio-button[contains(*,'Digital')]"));
  public static final Target BOTON_CONTINUAR_PRODUCTOS =
      Target.the("Boton continuar oferta de productos")
          .located(By.xpath("//button[contains(text(),'Continuar')]"));
}
