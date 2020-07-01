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
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.TAG_ACCEPT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PopUpAddressOptions implements Task {
  private final String confirmation;

  public PopUpAddressOptions(String confirmation) {
    this.confirmation = confirmation;
  }

  public static Performable choose(String confirmation) {
    return instrumented(PopUpAddressOptions.class, confirmation);
  }

  @Step("{0} selecciona la opcion #confirmation del pop up de direccion")
  public <T extends Actor> void performAs(T actor) {
    if (TAG_ACCEPT.equalsIgnoreCase(confirmation)) {
      actor.attemptsTo(Click.on(AddressPage.POP_UP_ACCEPT));
    } else {
      actor.attemptsTo(Click.on(AddressPage.POP_UP_REJECT));
    }
  }
}
