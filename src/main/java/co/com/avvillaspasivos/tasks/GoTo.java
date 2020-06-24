/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.ApplicationHomePage;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class GoTo {

  private GoTo() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable homePage() {
    return Task.where("{0} abre landing page", Open.browserOn().the(ApplicationHomePage.class));
  }

  public static Performable startOnLanding() {
    return Task.where(
        "{0} ingresa en comenzar solicitud", Click.on(ApplicationHomePage.BOTON_ABRIR_MI_CUENTA));
  }

  public static Performable verMasHabeasData() {
    return Task.where(
        "{0} da clic sobre ver mas de habeas data",
        Click.on(IdentificacionPage.VER_MAS_HABEAS_DATA_BUTTON));
  }

  public static Performable entendidoHabeasData() {
    return Task.where(
        "{0} da clic sobre entendido de habeas data",
        Click.on(IdentificacionPage.ENTENDIDO_HABEAS_DATA_BUTTON));
  }

  public static Performable cerrarHabeasData() {
    return Task.where(
        "{0} da clic sobre cerrar de habeas data",
        Click.on(IdentificacionPage.CERRAR_HABEAS_DATA_BUTTON));
  }
}
