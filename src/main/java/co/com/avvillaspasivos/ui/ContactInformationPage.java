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

public class ContactInformationPage {
  private ContactInformationPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target BUTTON_CONTINUE =
      Target.the("Boton continuar direccion")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));

  public static final Target TEXTBOX_MAIL = Target.the("Textbox correo").located(By.id("Email"));

  public static final Target TEXTBOX_MAIL_COPY =
      Target.the("Textbox confirma correo").located(By.id("EmailConfirm"));

  public static final Target TEXTBOX_PHONE =
      Target.the("Textbox telefono").located(By.id("LandlinePhone"));

  public static final Target TEXTBOX_ADDRESS =
      Target.the("Textbox direccion").located(By.id("HomeAddress"));

  public static final Target TEXTBOX_NEIGHBORHOOD =
      Target.the("Textbox barrio").located(By.id("HomeDistrict"));

  public static final Target TEXTBOX_CITY = Target.the("Textbox ciudad").located(By.id("HomeCity"));

  public static final Target TEXTBOX_COMPANY_NAME =
      Target.the("Textbox nombre empresa").located(By.id("CompanyName"));

  public static final Target TEXTBOX_COMPANY_CITY =
      Target.the("Textbox ciudad empresa").located(By.id("WorkCity"));

  public static final Target TEXTBOX_COMPANY_PHONE =
      Target.the("Textbox telefono empresa").located(By.id("WorkPhone"));

  public static final Target TEXTBOX_COMPANY_ADDRESS =
      Target.the("Textbox direccion empresa").located(By.id("WorkAddress"));
}
