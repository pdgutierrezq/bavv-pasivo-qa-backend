/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.ui.ElectronicSignaturePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

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
          Check.whether(the(ElectronicSignaturePage.CHECK_FEATURES_AND_CONDITIONS), isPresent())
              .andIfSo(Click.on(ElectronicSignaturePage.CHECK_FEATURES_AND_CONDITIONS)),
          Click.on(ElectronicSignaturePage.CHECK_AUTORIZATION),
          Click.on(ElectronicSignaturePage.CHECK_DATA),
          Click.on(ElectronicSignaturePage.CONTINUE_BUTTON),
          Waits.loader());
    }
  }
}
