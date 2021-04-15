/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.uivalidation.LoadDocumentsAssertions;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class GetDocumentsSteps {
    @Dado("que llego a pantalla de cargue de documentos y el servicio iniciar requiere cedula")
    public void queLlegoAPantallaDeCargueDeDocumentosYElServicioIniciarRequiereCedula() {
        OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateToDocumentLoadCdt());
    }

    @Entonces("se mostrará el componente de opción de cargue de cédula en reverso y frontal.")
    public void seMostraráElComponenteDeOpciónDeCargueDeCédulaEnReversoYFrontal() {
    OnStage.theActorInTheSpotlight().attemptsTo(LoadDocumentsAssertions.validateDocumentSection());
    }
}
