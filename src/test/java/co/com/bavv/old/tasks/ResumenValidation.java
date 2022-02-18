/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ResumenValidation implements Task {

  public static Performable perform() {
    return instrumented(ResumenValidation.class);
  }

  @Step("{0} selecciona cuenta #tipocuenta")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        BdUser.toBlock(false),
        ValidateAccountResume.perform(),
        ValidateInsuranceResume.perform());
  }
}
