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

public class PersonalDataPage {
  private PersonalDataPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target BIRTH_CITY_LIST =
      Target.the("Lista de ciudades de nacimiento").located(By.id("BirthCity"));

  public static final Target CITY_LIST_ITEM =
      Target.the("Lista de ciudades ")
          .located(By.xpath("//div/*[@role='option']"));

  public static final Target EXPEDITION_CITY_LIST =
      Target.the("Lista de ciudades de expedicion").located(By.id("IdCity"));


}
