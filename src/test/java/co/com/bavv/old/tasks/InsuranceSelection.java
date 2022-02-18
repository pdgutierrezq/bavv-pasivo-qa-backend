/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.InsuranceOfferPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InsuranceSelection implements Task {
  private final String afirmation;

  public InsuranceSelection(String afirmation) {
    this.afirmation = afirmation;
  }

  public static Performable choose(String afirmation) {
    return instrumented(InsuranceSelection.class, afirmation);
  }

  @Step("{0} selecciona #afirmacion seguro")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether("acepta".equalsIgnoreCase(afirmation))
            .andIfSo(Click.on(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE))
            .otherwise(Click.on(InsuranceOfferPage.RADIO_REJECT_INSURANCE)),
        Click.on(InsuranceOfferPage.CONTINUE_BUTTON));
  }
}
