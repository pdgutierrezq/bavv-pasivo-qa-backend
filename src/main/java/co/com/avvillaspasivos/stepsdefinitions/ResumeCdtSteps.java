/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.apitask.GetTokenBy;
import co.com.avvillaspasivos.tasks.apitask.ReadResumeCdt;
import co.com.avvillaspasivos.tasks.apitask.SaveAndDeleteResumeCdt;
import co.com.avvillaspasivos.tasks.apitask.SaveResumeCdt;
import co.com.avvillaspasivos.tasks.apivalidation.ValidateDeletedResumeCDT;
import co.com.avvillaspasivos.tasks.apivalidation.ValidateResumeCdt;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;

import static co.com.avvillaspasivos.util.Constantes.AUTHENTICATION_ACTOR;
import static co.com.avvillaspasivos.util.Constantes.DEV_ENV;

public class ResumeCdtSteps {
  @Cuando("se guarda informacion en base de datos")
  public void seGuardaInformacionEnBaseDeDatos() {
    OnStage.theActorCalled(AUTHENTICATION_ACTOR).attemptsTo(GetTokenBy.userIdentity(DEV_ENV));
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
