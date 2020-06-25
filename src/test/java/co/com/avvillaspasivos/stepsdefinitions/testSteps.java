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
import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.ui.IdentificationPage;
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





  @Dado("el usuario {string} diligencia el formulario  de identificacion")
  public void elUsuarioDiligenciaElFormularioDeIdentificacion(String actor) {

    OnStage.theActorCalled(actor)
        .attemptsTo(
            GoTo.homePage(), GoTo.startOnLanding(), FormIdentification.fill());

    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IdentificationPage.CONTINUE_BUTTON));
  }

  @Cuando("esta en pantalla de ofecimiento de cuenta y selecciona cuenta {string}")
  public void estaEnPantallaDeOfecimientoDeCuentaYSeleccionaCuenta(String tipoCuenta) {
    OnStage.theActorInTheSpotlight().attemptsTo(Waits.loader(), SeleccionCuentaSimple.simple());
  }

  @Y("{string} acepta el ofrecimiento de seguro")
  public void aceptaElOfrecimientoDeSeguro(String aceptacionSeguro) {
    OnStage.theActorInTheSpotlight().attemptsTo(Waits.loader(), SeleccionSeguros.selecciona(aceptacionSeguro));
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
