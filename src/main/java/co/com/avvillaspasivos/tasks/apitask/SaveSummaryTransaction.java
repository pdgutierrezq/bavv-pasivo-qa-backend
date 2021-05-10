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
import co.com.avvillaspasivos.model.SstBody;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.ActorActions.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SaveSummaryTransaction implements Task {

    public static Performable post() {
        return instrumented(SaveSummaryTransaction.class);
    }

    @Override
    @Step("{0} realiza el llamado del servicio save summary transaction")
    public <T extends Actor> void performAs(T actor) {
        String mainActor=getMainActorName();

        ActorData actorData =getActorDataFlow(mainActor);

        String token = getToken();

        OnStage.theActorCalled(mainActor).entersTheScene();

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

        SstBody sstBody=buillSstBody();

            actor.attemptsTo(
                Post.to(ServicePaths.pathSst())
                    .with(
                        requestSpecification ->
                            requestSpecification
                                .header("Content-Type", ContentType.JSON)
                                .header("transaction-id", "5641016020193")
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

