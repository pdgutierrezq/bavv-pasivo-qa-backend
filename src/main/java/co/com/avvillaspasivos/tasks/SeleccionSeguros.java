/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.OfertaSeguroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionSeguros implements Task {
  private final String afirmacion;

  public SeleccionSeguros(String afirmacion) {
    this.afirmacion = afirmacion;
  }

  public static Performable selecciona(String afirmacion) {
    return instrumented(SeleccionSeguros.class, afirmacion);
  }

  @Step("{0} selecciona #afirmacion seguro")
  public <T extends Actor> void performAs(T actor) {
    if ("acepta".equalsIgnoreCase(afirmacion)) {
      actor.attemptsTo(
          Click.on(OfertaSeguroPage.RADIO_ACEPTA_SEGURO),
          Click.on(OfertaSeguroPage.BOTON_CONTINUAR_SEGUROS));
    } else if ("no acepta".equalsIgnoreCase(afirmacion)) {
      actor.attemptsTo(
                  Click.on(OfertaSeguroPage.RADIO_RECHAZA_SEGURO),
                  Click.on(OfertaSeguroPage.BOTON_CONTINUAR_SEGUROS));
    }
  }
}
