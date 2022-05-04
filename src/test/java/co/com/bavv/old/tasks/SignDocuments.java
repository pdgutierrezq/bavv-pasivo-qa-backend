/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.ui.CommonWebElementsPage;
import co.com.bavv.old.ui.ElectronicSignaturePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SignDocuments implements Task {

  public static Performable perform() {
    return instrumented(SignDocuments.class);
  }

  @Step("{0} firma los docummentos")
  public <T extends Actor> void performAs(T actor) {
    if (CommonWebElementsPage.LOADER.resolveFor(actor).isPresent()) {
      actor.attemptsTo(Waits.loader(), perform());
    } else {
      actor.attemptsTo(
          Click.on(ElectronicSignaturePage.CHECK_AUTORIZATION),
          Click.on(ElectronicSignaturePage.CHECK_DATA),
          Click.on(ElectronicSignaturePage.CONTINUE_BUTTON),
          Waits.loader());
    }
  }
}
