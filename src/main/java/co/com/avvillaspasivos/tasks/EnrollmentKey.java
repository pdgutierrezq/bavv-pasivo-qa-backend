/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.EnrollmentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.CORRECT_PASS;
import static co.com.avvillaspasivos.util.Constantes.CORRECT_PASS_OPTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EnrollmentKey implements Task {
  private final String condition;

  public EnrollmentKey(String condition) {
    this.condition = condition;
  }

  public static Performable option(String condition) {
    return instrumented(EnrollmentKey.class, condition);
  }

  @Step("{0} ingresa clave con #confirmation")
  public <T extends Actor> void performAs(T actor) {

    if (CORRECT_PASS_OPTION.equalsIgnoreCase(condition)) {
      actor.attemptsTo(
          Enter.theValue(CORRECT_PASS).into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(0)),
          Enter.theValue(CORRECT_PASS).into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(4)),
          Click.on(EnrollmentPage.CONTINUE_BUTTON),
          Click.on(EnrollmentPage.POPUP_BUTTON)
      );

    }else  if ("3 dígitos consecutivos de manera ascendente".equalsIgnoreCase(condition)) {
      actor.attemptsTo(
          Enter.theValue("4234").into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(0))
      );

    } else if ("3 dígitos iguales".equalsIgnoreCase(condition)) {
      actor.attemptsTo(
          Enter.theValue("3334").into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(0))
      );
    }
  }
}
