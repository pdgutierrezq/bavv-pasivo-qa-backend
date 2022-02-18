/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.Constantes;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallPutWith implements Task {

    private final String path;

    public CallPutWith(String path) {
        this.path = path;
    }

    public static Performable token(String path) {
        return instrumented(CallPutWith.class, path);
    }

    @Override
    @Step("{0} llama servicio Put con token")
    public <T extends Actor> void performAs(T actor) {
        String mainActor = ActorActions.getMainActorName();

        ActorData actorData = ActorActions.getActorDataFlow(mainActor);

        String token = ActorActions.getToken();

        OnStage.theActorCalled(mainActor).entersTheScene();

        actor.attemptsTo(
            Put.to(path)
                .with(
                    requestSpecification ->
                        requestSpecification
                            .header("Content-Type", ContentType.JSON)
                            .header("transaction-id", Constantes.TRANSACTION_ID_VALUE)
                            .header("authorization-token", token)
                            .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                            .header("x-adl-document-type", actorData.getDocumentType())
                            .header("x-adl-document-number", actorData.getDocumentNumber())));
    }
}
