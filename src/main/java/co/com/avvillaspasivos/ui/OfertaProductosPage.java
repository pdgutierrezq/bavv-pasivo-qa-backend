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

public class OfertaProductosPage {
  private OfertaProductosPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target RADIO_SIMPLE =
      Target.the("Radio Button cuenta simple")
          .located(By.xpath("//*[@ng-reflect-value='CUENTA_SIMPLE']"));
  public static final Target RADIO_PRO =
      Target.the("Radio Button cuenta pro")
          .located(By.xpath("//*[@ng-reflect-value='CUENTA_PRO']"));
//  Target.the("Radio Button cuenta pro")
//          .located(By.id("mat-radio-3"));
  public static final Target BOTON_CONTINUAR_PRODUCTOS =
      Target.the("Boton continuar oferta de productos")
          .located(By.xpath("//button[contains(text(),'Continuar')]"));
}
