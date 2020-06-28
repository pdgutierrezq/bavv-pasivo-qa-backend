/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.InsuranceOfferPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InsuranceSelection implements Task {
  private final String afirmation;
  private final boolean continueOption;

  public InsuranceSelection(String afirmation,boolean continueOption ) {
    this.afirmation = afirmation;
    this.continueOption = continueOption;
  }

  public static Performable choose(String afirmation,boolean continueOption) {
    return instrumented(InsuranceSelection.class, afirmation,continueOption);
  }

  @Step("{0} selecciona #afirmacion seguro")
  public <T extends Actor> void performAs(T actor) {
    if ("acepta".equalsIgnoreCase(afirmation)) {
      actor.attemptsTo(
          Click.on(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE));
    } else if ("no acepta".equalsIgnoreCase(afirmation)) {
      actor.attemptsTo(
                  Click.on(InsuranceOfferPage.RADIO_REJECT_INSURANCE));
    }
    if (continueOption){
        actor.attemptsTo(
            Click.on(InsuranceOfferPage.CONTINUE_BUTTON)
        );
    }
  }
}
