/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.GetToken;
import co.com.avvillaspasivos.tasks.apitask.GetPdf;
import co.com.avvillaspasivos.tasks.apivalidation.ValidateGetPdf;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.avvillaspasivos.tasks.SmallTasks.rememberExpectedGetPdfCode;
import static co.com.avvillaspasivos.tasks.SmallTasks.rememberUserPdfConditions;
import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;

public class GetPdfCdtWsSteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Y("que el cliente seleccionó {string}")
  public void queElClienteSeleccionó(String pdfConditions) {
    OnStage.theActorCalled("GET_PDF_ACTOR")
        .attemptsTo(
            rememberUserPdfConditions(pdfConditions), rememberExpectedGetPdfCode(pdfConditions));
  }

  @Cuando("se consulta al banco para obtener el pdf")
  public void seConsultaAlBancoParaObtenerElPdf() {
    OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
    OnStage.theActorCalled("GET_PDF_ACTOR").attemptsTo(GetPdf.post());
  }

  @Entonces("se debe retornar el PDF correspondiente a las condiciones dadas")
  public void seDebeRetornarElPDFCorrespondienteALasCondicionesDadas() {
    OnStage.theActorInTheSpotlight().attemptsTo(ValidateGetPdf.perform());
  }
}
