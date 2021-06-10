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
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.TEST_DIRECTION;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditAddress implements Task {
  private Faker faker = new Faker();

  public static Performable toSendCard() {
    return instrumented(EditAddress.class);
  }

  @Step("{0} edita la direccion de envio de la tarjeta")
  public <T extends Actor> void performAs(T actor) {
    if (SendingCardPage.TEXT_CITY.resolveFor(actor).getValue().equals("")
        || SendingCardPage.TEXT_ADDRESS.resolveFor(actor).getValue().equals("")) {

      selectRandomCity(actor);
      actor.attemptsTo(
          Enter.theValue(TEST_DIRECTION).into(SendingCardPage.TEXT_ADDRESS),
          Click.on(SendingCardPage.CONTINUE_BUTTON),
          Click.on(SendingCardPage.POP_UP_ACCEPT));
    } else {
      actor.attemptsTo(Click.on(SendingCardPage.CONTINUE_BUTTON));
    }
  }

  private void selectRandomCity(Actor actor) {
    actor.attemptsTo(Enter.theValue(" ").into(SendingCardPage.TEXT_CITY));
    actor.attemptsTo(
        Click.on(SendingCardPage.LIST_CITIES.resolveAllFor(actor).get(faker.number().randomDigit())));
  }
}
