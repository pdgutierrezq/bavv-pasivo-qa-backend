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

public class ResumenPage {
  private ResumenPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target GO_NOW_BUTTON =
      Target.the("Boton ir ahora resumen").located(By.xpath("//*[contains(text(),'IR AHORA')]"));
  public static final Target ARTICLE_ACCOUNT =
      Target.the("Seccion de cuenta ").located(By.id("Account"));
  public static final Target ARTICLE_INSURANCE =
      Target.the("Seccion de seguro ").located(By.id("Insurance"));
  public static final Target ARTICLE_DEBIT =
      Target.the("Seccion de seguro ").located(By.id("debitTotal"));
  public static final Target RESUMEN_TITLE =
      Target.the("Titulo de resumen").located(By.xpath("//h1"));
  public static final Target INFO_ACCOUNT =
      Target.the("Informacion de cuenta")
          .locatedBy("#Account > div > ul > li:nth-child(1) > h3");
}
