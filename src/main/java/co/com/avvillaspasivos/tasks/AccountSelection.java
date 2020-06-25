/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ProductOfferingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AccountSelection implements Task {
  private final String tipoCuenta;

  public AccountSelection(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public static Performable type(String tipoCuenta) {
    return instrumented(AccountSelection.class, tipoCuenta);
  }

  @Step("{0} selecciona cuenta #tipocuenta")
  public <T extends Actor> void performAs(T actor) {
    if ("cuenta simple".equalsIgnoreCase(tipoCuenta)) {
      actor.attemptsTo(
          Click.on(ProductOfferingPage.RADIO_SIMPLE),
          Click.on(ProductOfferingPage.BOTON_CONTINUAR_PRODUCTOS));
    } else if ("cuenta pro".equalsIgnoreCase(tipoCuenta)) {
      actor.attemptsTo(
          Click.on(ProductOfferingPage.RADIO_PRO),
          Click.on(ProductOfferingPage.BOTON_CONTINUAR_PRODUCTOS));
    }
  }
}
