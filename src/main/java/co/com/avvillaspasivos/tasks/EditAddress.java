/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.AddressPage;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EditAddress implements Task {
  private Faker faker = new Faker();

  private final String option;

  public EditAddress(String option) {
    this.option = option;
  }

  public static Performable toSendCard(String option) {
    return instrumented(EditAddress.class,option);
  }

  @Step("{0} edita la direccion de envio de la tarjeta")
  public <T extends Actor> void performAs(T actor) {

    if (TAG_EDIT.equalsIgnoreCase(option)) {

      if (AddressPage.TEXT_CITY.resolveFor(actor).getValue().equals("")) {
        selectRandomCity(actor);
      }

      actor.attemptsTo(
          Enter.theValue(TEST_DIRECTION).into(AddressPage.TEXT_ADDRESS),
          Click.on(AddressPage.CONTINUE_BUTTON));

    } else if (TAG_NOT_EDIT.equalsIgnoreCase(option)) {
      actor.attemptsTo(Click.on(AddressPage.CONTINUE_BUTTON));
    }
  }

  private void selectRandomCity(Actor actor){
      actor.attemptsTo(Enter.theValue(" ").into(AddressPage.TEXT_CITY));
      actor.attemptsTo(
          Click.on(
              AddressPage.LIST_CITIES.resolveAllFor(actor).get(faker.number().randomDigit())));
  }
}
