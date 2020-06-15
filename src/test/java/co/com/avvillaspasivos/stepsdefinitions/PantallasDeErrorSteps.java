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
import co.com.avvillaspasivos.tasks.AsercionesUi;
import co.com.avvillaspasivos.tasks.Esperas;
import co.com.avvillaspasivos.tasks.FormIdentificacion;
import co.com.avvillaspasivos.tasks.NavegarA;
import co.com.avvillaspasivos.ui.IdentificacionPage;
import co.com.avvillaspasivos.util.VariablesDeSession;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

public class PantallasDeErrorSteps {
  private ActorData actorData;

  @Dado("que se obtiene un usuario tipo cliente lista restrictiva {string}")
  public void queSeObtieneUnUsuarioTipoClienteListaRestrictiva(String listRest) {
    ClientConditions clientConditions =
        ClientConditions.builder().restrictiveList(Boolean.valueOf(listRest)).build();

    actorData = DataProvider.getActorData(clientConditions);

    OnStage.theActorCalled("usuario tipo listas restrictivas " + listRest)
        .remember(String.valueOf(VariablesDeSession.DATA_ACTOR), actorData);

    OnStage.theActorInTheSpotlight().has(Usuario.informacion());
  }

  @Cuando("se valide en algún paso que hay una restricción")
  public void seValideEnAlgúnPasoQueHayUnaRestricción() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              NavegarA.homePage(),
              NavegarA.comenzarSolicitud(),
              FormIdentificacion.validarCargaInicial(),
              FormIdentificacion.diligenciar(),
              Click.on(IdentificacionPage.CONTINUAR_BUTTON),
              Esperas.loader()
              );
  }


    @Entonces("se muestra la pantalla de error de proceso")
    public void seMuestraLaPantallaDeErrorDeProceso() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                AsercionesUi.validarPantallaErrorDeProceso()
            );
    }
}
