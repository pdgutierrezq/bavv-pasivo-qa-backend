/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apivalidation;

import co.com.avvillaspasivos.model.SstBody;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveSummaryResponse implements Task {

  public static Performable validate() {
    return instrumented(SaveSummaryResponse.class);
  }

  @Override
  @Step("{0} valida la información de la respuesta summary transaction")
  public <T extends Actor> void performAs(T actor) {
    SstBody sstBody = OnStage.theActorInTheSpotlight().recall(SessionVariables.SST_DATA.name());

    actor.attemptsTo(
        Ensure.that(
            "Se valida la confirmación del valor cdtFundingAcct",
            response ->
                response.body(
                    "persistedData.cdtFundingAcct", Matchers.equalTo(sstBody.getCdtFundingAcct()))),
        Ensure.that(
            "Se valida la confirmación del valor cdtProfitsAcct",
            response ->
                response.body(
                    "persistedData.cdtProfitsAcct", Matchers.equalTo(sstBody.getCdtProfitsAcct()))),
        Ensure.that(
            "Se valida la confirmación del valor cdtTermination",
            response ->
                response.body(
                    "persistedData.cdtTermination", Matchers.equalTo(sstBody.getCdtTermination()))),
        Ensure.that(
            "Se valida la confirmación de actualización del servicio",
            response -> response.body("message", Matchers.equalTo("ITEM_UPDATED"))));
  }
}
