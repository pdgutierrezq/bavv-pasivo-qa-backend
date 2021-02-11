/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.SendingCardPage;
import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateInvalidWords implements Task {
  private final String errorText;

  public ValidateInvalidWords(String errorText) {
    this.errorText = errorText;
  }

  public static Performable onSendAddress(String errorText) {
    return instrumented(ValidateInvalidWords.class, errorText);
  }

  @Step("{0} valida error con palabras invalidas")
  public <T extends Actor> void performAs(T actor) {
    List<String> invalidWords = actor.recall(String.valueOf(SessionVariables.WORD_LIST));

    invalidWords.forEach(
        word ->
            actor.attemptsTo(
                Enter.theValue(word).into(SendingCardPage.TEXT_ADDRESS),
                Ensure.that(CommonWebElementsPage.ALERT_INVALID).text().isEqualToIgnoringCase(errorText)));
  }
}
