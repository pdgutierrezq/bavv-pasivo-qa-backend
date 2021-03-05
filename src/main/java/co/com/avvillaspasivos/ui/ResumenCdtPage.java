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

public class ResumenCdtPage {
  private ResumenCdtPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target RENEWAL_TEXT =
      Target.the("Texto renovación")
          .located(By.xpath("//*[@id='Account']//*[contains(text(),'Con renovación automática')]"));

  public static final Target RESUMEN_TITLE =
      Target.the("Titulo de resumen").located(By.xpath("//h1"));

  public static final Target TEXT_AMOUNT = Target.the("Texto monto").located(By.className("money"));

  public static final Target TEXT_RATE = Target.the("Texto tasa").located(By.className("percent"));

  public static final Target TEXT_TERM =
      Target.the("Texto plazo").located(By.xpath("(//*[@class='description-value'])[1]"));

  public static final Target TEXT_INCOME =
      Target.the("Texto rendimientos").located(By.xpath("(//*[contains(@class,'description-value')])[3]"));
}
