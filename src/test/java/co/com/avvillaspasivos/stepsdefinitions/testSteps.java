/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.facts.CondicionesCliente;
import co.com.avvillaspasivos.model.BodyGenerarOtp;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.steps.ValidationCommon;
import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import org.seleniumhq.jetty9.http.HttpStatus;

public class testSteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que tengo un usuario tipo {string}")
  public void queTengoUnUsuarioTipo(String actor) {
    OnStage.theActorCalled(actor).whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    OnStage.theActorInTheSpotlight().has(CondicionesCliente.consultar());
  }

  @Cuando("consumo el servicio rest de condiciones cliente")
  public void consumoElServicioRestDeCondicionesCliente() {
      BodyGenerarOtp bodyCustCond =
          BodyGenerarOtp.builder().documentType("CC").documentNumber("8765789").build();

    OnStage.theActorInTheSpotlight()
        .attemptsTo(CallPost.pathBody(ServicePaths.pathCustomerConditions(), bodyCustCond));
  }

  @Entonces("el obtengo la informacion de las condiciones del cliente")
  public void elObtengoLaInformacionDeLasCondicionesDelCliente() {
    ValidationCommon.validateSchema("schemas/example/customer-conditions.json");

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Ensure.that("status code is 200", response -> response.statusCode(HttpStatus.OK_200)));
  }

  @Dado("el usuario {string} diligencia el formulario  de identificacion")
  public void elUsuarioDiligenciaElFormularioDeIdentificacion(String actor) {

    OnStage.theActorCalled(actor)
        .attemptsTo(
            NavegarA.homePage(), NavegarA.comenzarSolicitud(), FormIdentificacion.diligenciar());

    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IdentificacionPage.CONTINUAR_BUTTON));
  }

  @Cuando("esta en pantalla de ofecimiento de cuenta y selecciona cuenta {string}")
  public void estaEnPantallaDeOfecimientoDeCuentaYSeleccionaCuenta(String tipoCuenta) {
    OnStage.theActorInTheSpotlight().attemptsTo(Esperas.loader(), SeleccionCuentaSimple.simple());
  }

  @Y("{string} acepta el ofrecimiento de seguro")
  public void aceptaElOfrecimientoDeSeguro(String aceptacionSeguro) {
    OnStage.theActorInTheSpotlight().attemptsTo(Esperas.loader(), SeleccionSeguros.selecciona(aceptacionSeguro));
  }

  @Entonces("el usuario ingresa la otp")
  public void elUsuarioIngresaLaOtp() {
    }

  @Dado("que se genera otp")
  public void queSeGeneraOtp() {
            OnStage.theActorCalled("actor")
                .whoCan(
                    CallAnApi.at("https://pa5xaz2b8d.execute-api.us-east-2.amazonaws.com/")
                );

            BodyGenerarOtp bodyGenerarOtp=BodyGenerarOtp.builder()
                .documentType("CC")
                .documentNumber("1096183483")
                .lastName("mariana")
                .firstName("parra")
                .phone("3173458317")
                .build();

            OnStage.theActorInTheSpotlight()
                .attemptsTo(
                    CallPost.pathBody("DEV/",bodyGenerarOtp)
                );

            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println(SerenityRest.lastResponse().asString());
  }

  @Cuando("se consulta massivian")
  public void seConsultaMassivian() {

  }

  @Entonces("se obtiene otp")
  public void seObtieneOtp() {}

  @Dado("que se conecta a oracle")
  public void queSeConectaAOracle() {

  }
}
