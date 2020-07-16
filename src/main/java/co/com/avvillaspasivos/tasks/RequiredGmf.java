/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.AccountPackagePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.TAG_ACCEPT;
import static co.com.avvillaspasivos.util.Constantes.TAG_NOT_ACCEPT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RequiredGmf implements Task {
  private final String option;

  public RequiredGmf(String option) {
    this.option = option;
  }

  public static Performable selection(String option) {
    return instrumented(RequiredGmf.class, option);
  }

  @Step("{0} #option la excención de 4xmil")
  public <T extends Actor> void performAs(T actor) {
    if (TAG_ACCEPT.equalsIgnoreCase(option)) {
      actor.attemptsTo(
          Click.on(AccountPackagePage.CHECK_ACCEPT), Click.on(AccountPackagePage.CONTINUE_BUTTON));
    } else if (TAG_NOT_ACCEPT.equalsIgnoreCase(option)) {
      actor.attemptsTo(Click.on(AccountPackagePage.CONTINUE_BUTTON));
    }
  }
}
