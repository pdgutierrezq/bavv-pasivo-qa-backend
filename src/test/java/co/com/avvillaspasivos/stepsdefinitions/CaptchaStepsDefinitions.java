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
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.steps.ValidationCommon;
import co.com.avvillaspasivos.tasks.CallGet;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import co.com.avvillaspasivos.ui.OfertaProductosPage;
import co.com.avvillaspasivos.util.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.seleniumhq.jetty9.http.HttpStatus;

import static net.serenitybdd.screenplay.ensure.Ensure.thatTheCurrentPage;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.isOneOf;

public class CaptchaStepsDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    private Actor actor;

    @Dado("que un {string} quiere acceder a la apertura de cuenta")
    public void queUnQuiereAccederALaAperturaDeCuenta(String featureActor) {
        actor = Actor.named(featureActor).whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));
    }

    @Cuando("consumo el servicio de recaptcha")
    public void consumoElServicioDeRecaptcha() {

    }

    @Entonces("el servicio valida y me entrega la informacion para saber que soy un usuario real")
    public void elServicioValidaYMeEntregaLaInformacionParaSaberQueSoyUnUsuarioReal() {
        ValidationCommon.validateSchema("");
        Ensure.that("status code is 200", response -> response.statusCode(HttpStatus.OK_200));
        Ensure.that(
            "contains user type",
            response -> response.body("usuario", isOneOf(DataProvider.getUsers())));
    }

    @Entonces("se espera la respuesta del captcha")
    public void seEsperaLaRespuestaDelCaptcha() {
        System.out.println("www");
    }

    @Dado("que el formulario de identificacion cliente esta diligenciado correctamente")
    public void queElFormularioDeIdentificacionClienteEstaDiligenciadoCorrectamente() {
        OnStage.theActorCalled("Usuario")
            .attemptsTo(
                NavegarA.homePage(),
                NavegarA.comenzarSolicitud(),
                FormIdentificacion.validarCargaInicial(),
                FormIdentificacion.diligenciar());
    }

    @Cuando("el boton se active y el cliente de click en continuar")
    public void elBotonSeActiveYElClienteDeClickEnContinuar() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IdentificacionPage.CONTINUAR_BUTTON));
    }

    @Entonces("se validara el recapcha fallido")
    public void seValidaraElRecapchaFallido() {
        System.out.println("recaptcha fallido");
    }

    @Cuando("se simule comportamiento de robot y el cliente de click en continuar")
    public void seSimuleComportamientoDeRobotYElClienteDeClickEnContinuar() {
        OnStage.theActorInTheSpotlight().attemptsTo(FormIdentificacion.simularRobot());
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(IdentificacionPage.CONTINUAR_BUTTON));
    }

    @Entonces("se muestra la pantalla PEP confirmando que paso la validacion captcha")
    public void seMuestraLaPantallaPEPConfirmandoQuePasoLaValidacionCaptcha() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                WaitUntil.the(CommonWebElementsPage.LOADER, isVisible()),
                WaitUntil.the(CommonWebElementsPage.LOADER, isNotVisible()),
                WaitUntil.the(OfertaProductosPage.RADIO_PRO, isVisible()),
                thatTheCurrentPage().currentUrl().contains(Constantes.PATH_OFRECIMIENTO));
    }
}
