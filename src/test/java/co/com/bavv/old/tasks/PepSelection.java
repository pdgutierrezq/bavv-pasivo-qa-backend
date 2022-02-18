/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.PepPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PepSelection implements Task {
  private final String confirmation;

  public PepSelection(String confirmation) {
    this.confirmation = confirmation;
  }

  public static Performable option(String confirmation) {
    return instrumented(PepSelection.class, confirmation);
  }

  @Step("{0} selecciona la opcion #confirmation pep")
  public <T extends Actor> void performAs(T actor) {

    if ("si".equalsIgnoreCase(confirmation)) {
      actor.attemptsTo(Click.on(PepPage.RADIO_SI_PEP));

    } else if ("no".equalsIgnoreCase(confirmation)) {
      actor.attemptsTo(Click.on(PepPage.RADIO_NO_PEP));
      actor.attemptsTo(Click.on(PepPage.RADIO_NO_SECOND_QUESTION));
    }
    actor.attemptsTo(Click.on(PepPage.CONTINUE_BUTTON));
  }
}
