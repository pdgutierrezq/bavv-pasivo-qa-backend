/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.ActorData;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.ActorActions.*;
import static co.com.avvillaspasivos.util.Constantes.TRANSACTION_ID_VALUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CallPostWith implements Task {

    private final String path;
    private final Object body;

    public CallPostWith(String path, Object body) {
        this.path = path;
        this.body = body;
    }

    public static Performable token(String path, Object body) {
        return instrumented(CallPostWith.class, path, body);
    }

    @Override
    @Step("{0} llama servicio Post")
    public <T extends Actor> void performAs(T actor) {
        String mainActor=getMainActorName();

        ActorData actorData =getActorDataFlow(mainActor);

        String token = getToken();

        OnStage.theActorCalled(mainActor).entersTheScene();
    actor.attemptsTo(
        Post.to(path)
            .with(
                requestSpecification ->
                    requestSpecification
                        .header("Content-Type", ContentType.JSON)
                        .header("transaction-id", TRANSACTION_ID_VALUE)
                        .header("authorization-token", token)
                        .header("x-adl-channel", "bavv-pasivo-cdt-pruebas")
                        .header("x-adl-document-type", actorData.getDocumentType())
                        .header("x-adl-document-number", actorData.getDocumentNumber())
                        .body(body)));
    }
}
