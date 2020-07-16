/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.DeclaringPage;
import co.com.avvillaspasivos.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.TAG_CONFIRM;
import static co.com.avvillaspasivos.util.Constantes.TAG_NOT_CONFIRM;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeclaringSelection implements Task {
  private final String option;

  public DeclaringSelection(String option) {
    this.option = option;
  }

  public static Performable choose(String option) {
    return instrumented(DeclaringSelection.class, option);
  }

  @Step("{0} #option declarante")
  public <T extends Actor> void performAs(T actor) {
    if (TAG_CONFIRM.equalsIgnoreCase(option)) {
      actor.attemptsTo(Click.on(DeclaringPage.RADIO_SI));
    } else if (TAG_NOT_CONFIRM.equalsIgnoreCase(option)) {
      actor.attemptsTo(Click.on(DeclaringPage.RADIO_NO));
    }
    actor.attemptsTo(
        Click.on(DeclaringPage.CONTINUE_BUTTON), Waits.loader(Constantes.MAX_WAIT_GET_PDF));
  }
}
