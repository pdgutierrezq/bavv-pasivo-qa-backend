/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveAndDeleteResumeCdt implements Task {

  public static Performable perform() {
    return instrumented(SaveAndDeleteResumeCdt.class);
  }

  @Override
  @Step("{0} se guarda y elimina informacion resumen de cdt")
  public <T extends Actor> void performAs(T actor) {
    OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetTokenBy.userIdentity(
        Constantes.DEV_ENV));
    OnStage.theActorCalled("SAVE_RESUME_CDT").attemptsTo(SaveResumeCdt.post());
    OnStage.theActorCalled("DELETE_RESUME_CDT").attemptsTo(DeleteResumeCdt.delete());
  }
}
