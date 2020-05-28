/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:home.page")
public class ApplicationHomePage extends PageObject {
  public static final Target VERMAS_BUTTON =
      Target.the("Boton ver mas beneficios").located(By.xpath("//*[@class='benefit see-more']"));
  public static final Target BENEFICIOS_DIALOG =
      Target.the("Boton ver mas beneficios")
          .located(By.xpath("//*[contains(text(),'Conoce los beneficios que tenemos para ti')]"));
  public static final Target BOTON_ABRIR_MI_CUENTA =
      Target.the("Boton Abrir mi cuenta")
          .located(By.xpath("//button[contains(text(),'ABRIR MI CUENTA')]"));
}
