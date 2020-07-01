/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.ui.AutenticacionPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Autentication implements Task {

  public static Performable byOtp() {
    return instrumented(Autentication.class);
  }

  @Step("{0} se autentica mediante otp")
  public <T extends Actor> void performAs(T actor) {
    String otp = DataProvider.getOtp();

    actor.attemptsTo(
        Enter.theValue(otp).into(AutenticacionPage.LIST_OTP_INPUT),
        Click.on(AutenticacionPage.CONTINUAR_BUTTON),
        Waits.loader(120));
  }
}
