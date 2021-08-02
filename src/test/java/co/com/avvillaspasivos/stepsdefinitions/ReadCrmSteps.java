/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CrmInfo;
import co.com.avvillaspasivos.tasks.GetFlowDataActor;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.avvillaspasivos.util.Constantes.SUPER_ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ReadCrmSteps {
  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Dado("que se obtiene un usuario para consultar crm de tipo {string}")
  public void queSeObtieneUnUsuarioParaConsultarCrmDeTipo(String userType) {
    theActorCalled(SUPER_ACTOR).remember(SessionVariables.MAIN_ACTOR.name(), userType);
    theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
  }

  @Cuando("el usuario consulta la información en crm")
  public void elUsuarioConsultaLaInformaciónEnCrm() {
    OnStage.theActorInTheSpotlight().attemptsTo(CrmInfo.post());
  }

  @Entonces("se validará la correcta estructura de la respuesta de consulta crm")
  public void seValidaráLaCorrectaEstructuraDeLaRespuestaDeConsultaCrm() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(Schema.validation(ServicePaths.pathReadDataCrmSchema()));
  }
}
