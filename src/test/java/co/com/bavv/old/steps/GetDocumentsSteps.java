/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.TasksGroup;
import co.com.bavv.old.tasks.uivalidation.LoadDocumentsAssertions;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class GetDocumentsSteps {
  @Dado("que llego a pantalla de cargue de documentos y el servicio iniciar requiere cedula")
  public void queLlegoAPantallaDeCargueDeDocumentosYElServicioIniciarRequiereCedula() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            TasksGroup.navigateToDocumentLoadCdt(Constantes.EMPLOYMENT_VALUE, Constantes.TAG_CONFIRM));
  }

  @Entonces("se mostrará el componente de opción de cargue de cédula en reverso y frontal.")
  public void seMostraráElComponenteDeOpciónDeCargueDeCédulaEnReversoYFrontal() {
    OnStage.theActorInTheSpotlight().attemptsTo(LoadDocumentsAssertions.validateDocumentSection());
  }

  @Dado("que llego a pantalla de cargue de documentos y haya seleccionado que es {string}")
  public void queLlegoAPantallaDeCargueDeDocumentosYHayaSeleccionadoQueEs(String economicActivity) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(TasksGroup.navigateToDocumentLoadCdt(economicActivity, Constantes.TAG_CONFIRM));
  }

  @Entonces("se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:")
  public void seMuestraComponenteDeCargueSoporteIngresosQueIncluyeLasSiguientesOpciones(
      List<String> docs) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(LoadDocumentsAssertions.validateEmploymentDocs(docs));
  }

  @Dado(
      "que llego a pantalla de cargue de documentos y haya seleccionado que es {string} y sea declarante")
  public void queLlegoAPantallaDeCargueDeDocumentosYHayaSeleccionadoQueEsYSeaDeclarante(
      String economicActivity) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(TasksGroup.navigateToDocumentLoadCdt(economicActivity, Constantes.TAG_CONFIRM));
  }

  @Entonces(
      "se muestra componente de Cargue decodumentos para  independiente que incluye las siguientes opciones:")
  public void
      seMuestraComponenteDeCargueDecodumentosParaIndependienteQueIncluyeLasSiguientesOpciones(
          List<String> docs) {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(LoadDocumentsAssertions.validateIndependentDocs(docs));
  }

    @Dado("que llego a pantalla de cargue de documentos y haya seleccionado que es {string} no sea declarante no requiere cedula")
    public void queLlegoAPantallaDeCargueDeDocumentosYHayaSeleccionadoQueEsNoSeaDeclaranteNoRequiereCedula(String economicActivity) {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(TasksGroup.navigateToDocumentLoadCdt(economicActivity, Constantes.TAG_NOT_CONFIRM));
    }

    @Entonces("se redirigirá a firma de documentos")
    public void seRedirigiráAFirmaDeDocumentos() {
      OnStage.theActorInTheSpotlight()
          .attemptsTo(
              Ensure.thatTheCurrentPage().currentUrl().contains("firma-documentos")
          );
    }
}
