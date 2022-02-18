/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.GetToken;
import co.com.bavv.old.tasks.SmallTasks;
import co.com.bavv.old.tasks.apitask.GetPdf;
import co.com.bavv.old.tasks.apivalidation.ValidateGetPdf;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetPdfCdtWsSteps {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Y("que el cliente seleccionó {string}")
  public void queElClienteSeleccionó(String pdfConditions) {
    OnStage.theActorCalled("GET_PDF_ACTOR")
        .attemptsTo(
            SmallTasks.rememberUserPdfConditions(pdfConditions), SmallTasks.rememberExpectedGetPdfCode(pdfConditions));
  }

  @Cuando("se consulta al banco para obtener el pdf")
  public void seConsultaAlBancoParaObtenerElPdf() {
    OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
    OnStage.theActorCalled("GET_PDF_ACTOR").attemptsTo(GetPdf.post());
  }

  @Entonces("se debe retornar el PDF correspondiente a las condiciones dadas")
  public void seDebeRetornarElPDFCorrespondienteALasCondicionesDadas() {
    OnStage.theActorInTheSpotlight().attemptsTo(ValidateGetPdf.perform());
  }
}
