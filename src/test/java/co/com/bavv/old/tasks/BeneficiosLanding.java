/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.ApplicationHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class BeneficiosLanding {

  private BeneficiosLanding() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable verMas() {
    return Task.where(
        "{0} ingresa a opcion ver mas beneficios en landing page",
        Click.on(ApplicationHomePage.VERMAS_BUTTON));
  }
}
