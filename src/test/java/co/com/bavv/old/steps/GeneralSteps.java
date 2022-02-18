/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.data.DataProvider;
import co.com.bavv.old.facts.Usuario;
import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.ClientConditions;
import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.SessionVariables;
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
      "que se obtiene un usuario tipo cliente {string} actualizado {string} lista restrictiva {string} cuenta cat {string} y canales {string}")
  public void queSeObtieneUnUsuarioTipoClienteActualizadoListaRestrictivaCuentaCatYCanales(
      String client, String updated, String listRest, String cat, String channels) {
    ActorActions.configure(client, updated, listRest, cat, channels);
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
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToIdentificationForm());
  }

  @Dado("que se obtiene un usuario tipo valido otp {string}")
  public void queSeObtieneUnUsuarioTipoValidoOtp(String otp) {
    ClientConditions clientConditions =
        ClientConditions.builder().validOtp(Boolean.valueOf(otp)).build();

    ActorData actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled("usuario tipo " + clientConditions.getValidOtp())
        .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }
}
