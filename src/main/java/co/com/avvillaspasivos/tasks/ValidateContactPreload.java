/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.tasks.TasksGroup.navigateLaterForeignInformation;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateContactPreload implements Task {

  public static Performable perform() {
    return instrumented(ValidateContactPreload.class);
  }

  @Step(
      "{0} valida la precarga de datos para el cliente desactualizado"
          + " en Informacion de contacto e informacion financiera")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        UiAssertions.validateContactPreload(),
        navigateLaterForeignInformation());
    actor.attemptsTo(
        UiAssertions.validateFinancialInfPreload());
  }
}
