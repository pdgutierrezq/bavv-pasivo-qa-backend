/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.*;
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

  public static Performable openAccount() {
    return Task.where(
        "{0} ingresa en comenzar solicitud", Click.on(ApplicationHomePage.BOTON_ABRIR_MI_CUENTA));
  }

  public static Performable pepContinue() {
    return Task.where(
        "{0} selecciona la opcion continuar pep",
        Click.on(PepPage.CONTINUE_BUTTON));
  }


}
