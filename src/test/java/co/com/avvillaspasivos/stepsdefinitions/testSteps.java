package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.data.DbQuerys;
import co.com.avvillaspasivos.facts.CondicionesCliente;
import co.com.avvillaspasivos.model.BodyCustCond;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.steps.ValidationCommon;
import co.com.avvillaspasivos.tasks.*;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
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
    BodyCustCond bodyCustCond =
        BodyCustCond.builder().documentType("CC").documentNumber("8765789").build();

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
    OnStage.theActorInTheSpotlight().attemptsTo(Esperas.loader(), SeleccionCuenta.simple());
  }

  @Y("{string} acepta el ofrecimiento de seguro")
  public void aceptaElOfrecimientoDeSeguro(String aceptacionSeguro) {
    OnStage.theActorInTheSpotlight().attemptsTo(Esperas.loader(), SeleccionSeguros.acepta());
  }

  @Entonces("el usuario ingresa la otp")
  public void elUsuarioIngresaLaOtp() {
    //
    // net.serenitybdd.screenplay.ensure.Ensure.that(OfertaSeguroPage.BOTON_CONTINUAR_SEGUROS).isNotDisplayed();
  }

  @Dado("que se genera otp")
  public void queSeGeneraOtp() {
    //        OnStage.theActorCalled("actor")
    //            .whoCan(
    //                CallAnApi.at("https://pa5xaz2b8d.execute-api.us-east-2.amazonaws.com/")
    //            );
    //
    //        BodyGenerarOtp bodyGenerarOtp=BodyGenerarOtp.builder()
    //            .documentType("CC")
    //            .documentNumber("1096183483")
    //            .lastName("mariana")
    //            .firstName("parra")
    //            .phone("3173458317")
    //            .build();
    //
    //        OnStage.theActorInTheSpotlight()
    //            .attemptsTo(
    //                CallPost.pathBody("DEV/",bodyGenerarOtp)
    //            );
    //
    //        System.out.println("************************************");
    //        System.out.println("************************************");
    //        System.out.println(SerenityRest.lastResponse().asString());
  }

  @Cuando("se consulta massivian")
  public void seConsultaMassivian() {
    //        String bodyMasivian = "{\n" +
    //            "\"UserName\": \"saenze@bancoavvillas.com.co\",\n" +
    //            "\"Password\": \"ATHavvillas-2017\",\n" +
    //            "\"RememberMe\": false,\n" +
    //            "\"commit\": \"Ingresar\"\t\n" +
    //            "}";
    //
    //        SerenityRest.useRelaxedHTTPSValidation();
    //
    //        BodyMasivian bodyMasivian=BodyMasivian.builder()
    //           .userName("saenze@bancoavvillas.com.co")
    //            .password("ATHavvillas-2017")
    //            .rememberMe(false)
    //            .commit("Ingresar")
    //            .build();

    //
    //        String queryParam =
    // "%2FSimpleSearch%2FSearchEmailAndCelular%3Fvalor%3D573173458317%26type%3D2%26inicio%3D2020%252F2%252F6%26fin%3D2020%252F2%252F6%26celType%3DMT%26_%3D1580930637721";
    //        given()
    //            .body(bodyMasivian)
    ////            .queryParam(queryParam, "ReturnUrl")
    //
    // .when().post("http://athqa.estratec.com.co/Account/Login?ReturnUrl=%2FSimpleSearch%2FSearchEmailAndCelular%3Fvalor%3D573173458317%26type%3D2%26inicio%3D2020%252F2%252F6%26fin%3D2020%252F2%252F6%26celType%3DMT%26_%3D1580930637721");
    ////            .when().post("http://athqa.estratec.com.co/Account/Login");
    //
    //
    //       //        OnStage.theActorCalled("actor")
    ////            .whoCan(
    ////                CallAnApi.at("http://athqa.estratec.com.co/Account/Login?ReturnUrl=")
    ////            );
    ////        OnStage.theActorInTheSpotlight()
    ////            .whoCan(
    ////                CallAnApi.as(OnStage.theActorInTheSpotlight())
    ////            );
    //
    ////        OnStage.theActorInTheSpotlight()
    ////            .attemptsTo(
    ////                CallPost.pathBody(ServicePaths.pathMasivian(),bodyMasivian)
    ////            );
    //
    //        System.out.println("************************************");
    //        System.out.println("************************************");
    //        System.out.println(SerenityRest.lastResponse().asString());
  }

  @Entonces("se obtiene otp")
  public void seObtieneOtp() {}

  @Dado("que se conecta a oracle")
  public void queSeConectaAOracle() {

    DbQuerys dbQuerys = new DbQuerys();

    String rta = dbQuerys.getXmlOtp();
    System.out.println(rta);
  }
}
