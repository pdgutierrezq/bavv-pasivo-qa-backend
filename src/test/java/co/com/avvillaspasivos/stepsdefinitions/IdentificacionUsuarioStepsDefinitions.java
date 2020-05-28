/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DataProvider;
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.tasks.ValidarIdentificacionUsuario;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class IdentificacionUsuarioStepsDefinitions {
  private BodyGenerarOtp bodyGenerarOtp = BodyGenerarOtp.builder().build();

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que tengo datos de autenticacion de un usuario {string}")
  public void queTengoDatosDeAutenticacionDeUnUsuario(String tipoUsuario) {
    OnStage.theActorCalled(tipoUsuario).whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    bodyGenerarOtp = DataProvider.getBodyIdentification(tipoUsuario);
  }

  @Cuando("consumo el servicio rest de identificacion")
  public void consumoElServicioRestDeIdentificacion() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyGenerarOtp));
    System.out.println(SerenityRest.lastResponse().asString());
  }

  @Entonces(
      "el servicio se encarga de enviar OTP al usuario {string} o me informa que no paso alguna validacion")
  public void elServicioSeEncargaDeEnviarOTPAlUsuarioOMeInformaQueNoPasoAlgunaValidacion(
      String tipoUsuario) {
    ValidarIdentificacionUsuario.tipo(tipoUsuario);
  }

  @Y("el usuario {string} llama el servicio de identificacion de usuario para generar otp")
  public void elUsuarioLlamaElServicioDeIdentificacionDeUsuarioParaGenerarOtp(String tipoUsuario) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyGenerarOtp));
  }

  @Y("el usuario obtiene la otp recibida")
  public void elUsuarioObtieneLaOtpRecibida() {

  }

  @Cuando("consumo el servicio rest de identificacion para validar otp")
  public void consumoElServicioRestDeIdentificacionParaValidarOtp() {}

  @Entonces("el servicio el servicio entrega informacion de validacion exitosa")
  public void elServicioElServicioEntregaInformacionDeValidacionExitosa() {}
}
