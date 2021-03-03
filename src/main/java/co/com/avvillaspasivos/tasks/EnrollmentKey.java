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
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.CORRECT_PASS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class EnrollmentKey implements Task {

  public static Performable perform() {
    return instrumented(EnrollmentKey.class);
  }

  @Step("{0} ingresa clave con #confirmation")
  public <T extends Actor> void performAs(T actor) {

    actor.attemptsTo(
        Enter.theValue(CORRECT_PASS)
            .into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(0)),
        Enter.theValue(CORRECT_PASS)
            .into(EnrollmentPage.PASSWORD_INPUT.resolveAllFor(theActorInTheSpotlight()).get(4)),
        Click.on(EnrollmentPage.CONTINUE_BUTTON),
        Waits.loader(),
        Check.whether(the(EnrollmentPage.POPUP_BUTTON), isVisible())
            .andIfSo(Click.on(EnrollmentPage.POPUP_BUTTON)));
  }
}
