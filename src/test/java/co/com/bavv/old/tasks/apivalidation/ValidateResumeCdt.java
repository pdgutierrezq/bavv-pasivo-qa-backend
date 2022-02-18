/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apivalidation;

import co.com.bavv.old.model.BodySaveResumeCdt;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateResumeCdt implements Task {

  public static Performable perform() {
    return instrumented(ValidateResumeCdt.class);
  }

  @Override
  @Step("{0} valida la información guardada en base de datos para el resumen de CDT ")
  public <T extends Actor> void performAs(T actor) {

    BodySaveResumeCdt savedData =
        OnStage.theActorCalled("SAVE_RESUME_CDT").recall(SessionVariables.CDT_RESUME_DATA.name());

    actor.attemptsTo(
        Ensure.that(
            "Se valida return type",
            response -> response.body("returnType", Matchers.equalTo(savedData.getReturnType()))),
        Ensure.that(
            "Se valida state",
            response -> response.body("state", Matchers.equalTo(savedData.getState()))),
        Ensure.that(
            "Se valida productNumber",
            response ->
                response.body("productNumber", Matchers.equalTo(savedData.getProductNumber()))));
  }
}
