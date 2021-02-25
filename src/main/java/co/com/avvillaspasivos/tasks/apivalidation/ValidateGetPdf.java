/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apivalidation;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateGetPdf implements Task {

  public static Performable perform() {
    return instrumented(ValidateGetPdf.class);
  }

  @Override
  @Step("{0} valida la información de la respuesta para Get Pdf")
  public <T extends Actor> void performAs(T actor) {
    String expectedCode =
        OnStage.theActorCalled("GET_PDF_ACTOR")
            .recall(SessionVariables.CODE_PDF_EXPECTED_CONDITIONS.name());

    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Schema.validation(ServicePaths.pathGetPdfSchema()),
            Ensure.that(
                "Se valida que el codigo del  pdf es correcto",
                response -> response.body("packageId", Matchers.is(expectedCode))));
  }
}
