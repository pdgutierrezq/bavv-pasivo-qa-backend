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
import co.com.avvillaspasivos.facts.Usuario;
import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.model.ClientConditions;
import co.com.avvillaspasivos.tasks.FormIdentification;
import co.com.avvillaspasivos.tasks.GoTo;
import co.com.avvillaspasivos.util.ActorActions;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GeneralSteps {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

  @Dado(
      "que se obtiene un usuario tipo cliente {string} actualizado {string} lista restrictiva {string} y cuenta cat {string}")
  public void queSeObtieneUnUsuarioTipoClienteActualizadoListaRestrictivaYCuentaCat(
      String client, String updated, String listRest, String cat) {
    ActorActions.configure(client, updated, listRest,cat);
  }

  @Dado(
      "que se obtiene un usuario tipo cliente {string} actualizado {string} lista restrictiva {string}")
  public void queSeObtieneUnUsuarioTipoClienteActualizadoListaRestrictiva(
      String client, String updated, String listRest) {
    ActorActions.configure(client, updated, listRest);
  }

  @Dado(
      "que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos")
  public void
      queElUsuarioEstaInteresadoEnAdquirirElProductoYEnPantallaSeMuestraElFormularioDeDatos() {

    OnStage.theActorInTheSpotlight()
        .attemptsTo(GoTo.homePage(), GoTo.startOnLanding(), FormIdentification.validatePageLoad());
  }

  @Dado("que se obtiene un usuario tipo valido otp {string}")
  public void queSeObtieneUnUsuarioTipoValidoOtp(String otp) {
    ClientConditions clientConditions =
        ClientConditions.builder().validOtp(Boolean.valueOf(otp)).build();

    ActorData actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled("usuario tipo " + clientConditions.getValidOtp())
        .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }
}
