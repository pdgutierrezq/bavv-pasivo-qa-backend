/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.apitask.GetTokenBy;
import co.com.bavv.old.tasks.apitask.ReadResumeCdt;
import co.com.bavv.old.tasks.apitask.SaveAndDeleteResumeCdt;
import co.com.bavv.old.tasks.apitask.SaveResumeCdt;
import co.com.bavv.old.tasks.apivalidation.ValidateDeletedResumeCDT;
import co.com.bavv.old.tasks.apivalidation.ValidateResumeCdt;
import co.com.bavv.old.util.Constantes;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

public class ResumeCdtSteps {
  @Cuando("se guarda informacion en base de datos")
  public void seGuardaInformacionEnBaseDeDatos() {
    OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(
        GetTokenBy.userIdentity(Constantes.DEV_ENV));
    OnStage.theActorCalled("SAVE_RESUME_CDT").attemptsTo(SaveResumeCdt.post());
  }

  @Entonces("se lee la informacion del resumen para validar la coincidencia de datos")
  public void seLeeLaInformacionDelResumenParaValidarLaCoincidenciaDeDatos() {
    OnStage.theActorCalled("READ_RESUME_CDT")
        .attemptsTo(ReadResumeCdt.get(), ValidateResumeCdt.perform());
  }

  @Cuando("se guarda y eliminan datos del resumen CDT")
  public void seGuardaYEliminanDatosDelResumenCDT() {
    OnStage.theActorInTheSpotlight().attemptsTo(SaveAndDeleteResumeCdt.perform());
  }

  @Entonces("se valida que no existan datos en la base de datos")
  public void seValidaQueNoExistanDatosEnLaBaseDeDatos() {
    OnStage.theActorCalled("READ_RESUME_CDT")
        .attemptsTo(ReadResumeCdt.get(), ValidateDeletedResumeCDT.perform());
  }
}
