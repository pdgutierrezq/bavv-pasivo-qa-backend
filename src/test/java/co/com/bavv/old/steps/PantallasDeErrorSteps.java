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
import co.com.bavv.old.tasks.BdUser;
import co.com.bavv.old.tasks.FormIdentification;
import co.com.bavv.old.tasks.GoTo;
import co.com.bavv.old.tasks.UiAssertions;
import co.com.bavv.old.tasks.Waits;
import co.com.bavv.old.util.SessionVariables;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class PantallasDeErrorSteps {
  private ActorData actorData;

  @Dado("que se obtiene un usuario tipo cliente lista restrictiva {string}")
  public void queSeObtieneUnUsuarioTipoClienteListaRestrictiva(String listRest) {
    ClientConditions clientConditions =
        ClientConditions.builder().restrictiveList(Boolean.valueOf(listRest)).build();

    actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled("usuario tipo listas restrictivas " + listRest)
        .remember(String.valueOf(SessionVariables.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Cuando("se valide en algún paso que hay una restricción")
  public void seValideEnAlgúnPasoQueHayUnaRestricción() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            GoTo.homePage(),
            GoTo.openAccount(),
            FormIdentification.validatePageLoad(),
            FormIdentification.fillAndContinue(),
            Waits.loader());
  }

  @Entonces("se muestra la pantalla de error de proceso")
  public void seMuestraLaPantallaDeErrorDeProceso() {

      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              BdUser.toBlock(false),
              UiAssertions.validarPantallaErrorDeProceso()
          );
  }
}
