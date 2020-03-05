/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidarIdentificacionUsuario implements Task {
  private final String tipoUsuario;

  public ValidarIdentificacionUsuario(String tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  public static Performable tipo(String tipoUsuario) {
    return instrumented(ValidarIdentificacionUsuario.class, tipoUsuario);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    if ("valido otp".equalsIgnoreCase(tipoUsuario)) {
      Ensure.that(
          "El servicio responde con estado de exito",
          response -> response.body("statusResponse", Matchers.equalTo(HttpStatus.SC_CREATED)));
    } else if ("invalido".equalsIgnoreCase(tipoUsuario)) {
      Ensure.that(
          "El servicio responde con falla que no permite el envio de otp",
          response ->
              response.body("statusResponse", Matchers.equalTo(HttpStatus.SC_PARTIAL_CONTENT)));
    }
  }
}
