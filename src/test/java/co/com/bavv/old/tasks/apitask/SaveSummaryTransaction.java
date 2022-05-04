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
import co.com.bavv.old.model.SstBody;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveSummaryTransaction implements Task {

    public static Performable post() {
        return instrumented(SaveSummaryTransaction.class);
    }

    @Override
    @Step("{0} realiza el llamado del servicio save summary transaction")
    public <T extends Actor> void performAs(T actor) {
        String mainActor= ActorActions.getMainActorName();

        ActorData actorData = ActorActions.getActorDataFlow(mainActor);

        String token = ActorActions.getToken();

        OnStage.theActorCalled(mainActor).entersTheScene();

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

        SstBody sstBody=buillSstBody();

            actor.attemptsTo(
                Post.to(ServicePaths.pathSst())
                    .with(
                        requestSpecification ->
                            requestSpecification
                                .header("Content-Type", ContentType.JSON)
                                .header("transaction-id", Constantes.TRANSACTION_ID_VALUE)
                                .header("authorization-token", token)
                                .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                                .header("x-adl-document-type", actorData.getDocumentType())
                                .header("x-adl-document-number", actorData.getDocumentNumber())
                                .body(sstBody)));

        actor.remember(SessionVariables.SST_DATA.name(), sstBody);
    }

    private SstBody buillSstBody() {
        Faker faker=new Faker();

        return SstBody.builder()
            .cdtFundingAcct(faker.number().digits(4))
            .cdtProfitsAcct(faker.number().digits(4))
            .cdtTermination(String.valueOf(faker.number().randomDigit()))
            .build();
    }

}

