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

public class EconomicActivityPage {
  private EconomicActivityPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target INPUT_CIUU =
      Target.the("Campo de texto codigo Ciuu").located(By.id("CIIUCode"));

  public static final Target RADIO_INDEPENDET =
      Target.the("Radio Independiente")
          .located(By.xpath("//mat-radio-button[contains(*,'Independiente')]"));

  public static final Target RADIO_INDEPENDENT_BUSINESS =
      Target.the("Radio Independiente con negocio")
          .located(By.xpath("//mat-radio-button[contains(*,'Independiente con negocio')]"));

  public static final Target RADIO_HOME =
      Target.the("Radio Hogar").located(By.xpath("//mat-radio-button[contains(*,'Hogar')]"));

  public static final Target RADIO_STUDENT =
      Target.the("Radio Estudiante")
          .located(By.xpath("//mat-radio-button[contains(*,'Estudiante')]"));

  public static final Target RADIO_EMPLOYMENT =
      Target.the("Radio Empleado").located(By.xpath("//mat-radio-button[contains(*,'Empleado')]"));

  public static final Target RADIO_RETIRED =
      Target.the("Radio Empleado")
          .located(By.xpath("//mat-radio-button[contains(*,'Pensionado')]"));

  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar Actividad economica")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
