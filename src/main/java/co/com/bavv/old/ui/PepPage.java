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

public class PepPage {
  private PepPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target POP_UP_PEP =
      Target.the("Pop up  Pep").located(By.xpath("//*[contains(text(),'¿Qué es ser públicamente expuesto?')]"));
  public static final Target VER_MAS_PEP =
      Target.the("Ver mas Pep").located(By.xpath("//button[@class='more-info-pep']"));
  public static final Target RADIO_NO_PEP =
      Target.the("Radio button no PEP").located(By.xpath("//*[@formcontrolname='firstPepInput']//mat-radio-button[contains(*,'No')]"));
  public static final Target RADIO_SI_PEP =
      Target.the("Radio button si PEP").located(By.xpath("//*[@formcontrolname='firstPepInput']//mat-radio-button[contains(*,'Si')]"));
   public static final Target RADIO_NO_SECOND_QUESTION =
      Target.the("Radio button segunda preguta no PEP").located(By.xpath("//*[@formcontrolname='secondPepInput']//mat-radio-button[contains(*,'No')]"));
  public static final Target RADIO_SI_SECOND_QUESTION =
      Target.the("Radio button segunda preguta si PEP").located(By.xpath("//*[@formcontrolname='secondPepInput']//mat-radio-button[contains(*,'Si')]"));
  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar PEP")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
