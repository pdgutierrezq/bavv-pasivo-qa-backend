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

public class IdentificationPage {

  private IdentificationPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target DNI_INPUT =
      Target.the("Campo de texto DNI").located(By.id("DNINumber"));
  public static final Target CELULAR_INPUT =
      Target.the("Campo de texto celular").located(By.id("MobileNumber"));
  public static final Target CELULAR_CONFIRMACION_INPUT =
      Target.the("Campo de texto confirmar celular").located(By.id("MobileConfirmNumber"));
  public static final Target PRIMER_NOMBRE_INPUT =
      Target.the("Campo de texto primer nombre").located(By.id("FirstName"));
  public static final Target PRIMER_APELLIDO_INPUT =
      Target.the("Campo de texto primer apellido").located(By.id("LastName"));
  public static final Target HABEAS_DATA_CHECKBOX =
      Target.the("Checkbox Habeas data")
          .located(
              By.xpath(
                  "//*[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']"));
  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar ").located(By.xpath("//button[contains(text(),'Continuar')]"));
  public static final Target MSJ_CAMPOS_OBLIG =
      Target.the("Texto campos obligatorios ")
          .located(By.xpath("//*[contains(text(),'Este campo es obligatorio')]"));
  public static final Target ALERT_ERROR =
      Target.the("Texto campos obligatorios ")
          .located(By.xpath("//*[@role='alert']"));
  public static final Target VER_MAS_HABEAS_DATA_BUTTON =
      Target.the("Boton ver mas habeas data").located(By.className("btn-see-more"));
  public static final Target VER_MAS_HABEAS_DATA_POPUP =
      Target.the("Popup ver mas habeas data").located(By.className("cdk-overlay-pane"));
  public static final Target ENTENDIDO_HABEAS_DATA_BUTTON =
      Target.the("Boton entendido habeas data")
          .located(By.xpath("//button[contains(text(),'ENTENDIDO')]"));
  public static final Target CERRAR_HABEAS_DATA_BUTTON =
      Target.the("Boton cerrar habeas data").located(By.xpath("//*[@class='icon-salir']"));
  public static final Target SALARY_INPUT =
      Target.the("Input Ingresos").located(By.id("MonthlyIncomeInput"));
}
