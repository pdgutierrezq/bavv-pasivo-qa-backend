/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.tasks.ValidarIdentificacionUsuario;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class IdentificacionUsuarioStepsDefinitions {
  private ActorData actorData;

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Cuando("consumo el servicio rest de identificacion")
  public void consumoElServicioRestDeIdentificacion() {
    actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(VariablesDeSession.DATA_ACTOR));
    OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

    BodyGenerarOtp bodyGenerarOtp =
        BodyGenerarOtp.builder()
            .documentType(actorData.getDocumentType())
            .documentNumber(actorData.getDocumentNumber())
            .firstName(actorData.getFirstName())
            .lastName(actorData.getLastName())
            .phone(actorData.getPhone())
            .build();

    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyGenerarOtp));
  }

  @Entonces(
      "el servicio se encarga de enviar OTP al usuario {string} o me informa que no paso alguna validacion")
  public void elServicioSeEncargaDeEnviarOTPAlUsuarioOMeInformaQueNoPasoAlgunaValidacion(
      String tipoUsuario) {
      OnStage.theActorInTheSpotlight().attemptsTo(
          ValidarIdentificacionUsuario.tipo(tipoUsuario)
      );
  }

  @Y("el usuario {string} llama el servicio de identificacion de usuario para generar otp")
  public void elUsuarioLlamaElServicioDeIdentificacionDeUsuarioParaGenerarOtp(String tipoUsuario) {
    //    OnStage.theActorInTheSpotlight()
    //        .attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyGenerarOtp));
  }

  @Y("el usuario obtiene la otp recibida")
  public void elUsuarioObtieneLaOtpRecibida() {}

  @Cuando("consumo el servicio rest de identificacion para validar otp")
  public void consumoElServicioRestDeIdentificacionParaValidarOtp() {}

  @Entonces("el servicio el servicio entrega informacion de validacion exitosa")
  public void elServicioElServicioEntregaInformacionDeValidacionExitosa() {}
}
