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

public class PepPage {
  private PepPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target TEXT_PEP =
      Target.the("Texto pregunta PEP").located(By.xpath("//*[@class='pep-question']"));
  public static final Target RADIO_NO_PEP =
      Target.the("Radio button no PEP").located(By.xpath("//mat-radio-button[contains(*,'No')]"));
  public static final Target BOTON_CONTINUAR =
      Target.the("Boton continuar PEP")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
