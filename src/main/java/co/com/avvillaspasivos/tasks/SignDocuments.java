/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ElectronicSignaturePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.MAX_WAIT;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SignDocuments implements Task {

  public static Performable perform() {
    return instrumented(SignDocuments.class);
  }

  @Step("{0} firma los docummentos")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(ElectronicSignaturePage.CHECK_AUTORIZATION, isClickable())
            .forNoMoreThan(MAX_WAIT)
            .seconds(),
        Click.on(ElectronicSignaturePage.CHECK_AUTORIZATION),
        Click.on(ElectronicSignaturePage.CONTINUE_BUTTON),
        Waits.loader());
  }
}
