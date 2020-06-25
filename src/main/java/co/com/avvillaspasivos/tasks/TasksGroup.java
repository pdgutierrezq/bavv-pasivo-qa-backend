/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class TasksGroup {
  private TasksGroup() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable navigateToProductOfferingWithSalary(String salary) {
    return Task.where(
        "{0} navega hasta la pagina de ofrecimiento de cuentas",
        GoTo.homePage(),
        GoTo.startOnLanding(),
        FormIdentification.validatePageLoad(),
        FormIdentification.fillWithSalaryAndContinue(salary),
        Waits.loader());
  }

  public static Performable navigateToProductOffering() {
    return Task.where(
        "{0} navega hasta la pagina de ofrecimiento de cuentas",
        GoTo.homePage(),
        GoTo.startOnLanding(),
        FormIdentification.validatePageLoad(),
        FormIdentification.fillAndContinue(),
        Waits.loader());
  }

  public static Performable navigateToIdentificationForm() {
    return Task.where(
        "{0} navega hasta la pagina formulario de identificacion",
        GoTo.homePage(),
        GoTo.startOnLanding(),
        FormIdentification.validatePageLoad());
  }
}
