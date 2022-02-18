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
import co.com.bavv.old.model.CppBody;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreatePasiveProduct implements Task {

    public static Performable post() {
        return instrumented(CreatePasiveProduct.class);
    }

    @Override
    @Step("{0} crea un producto pasivo")
    public <T extends Actor> void performAs(T actor) {
        String mainActorName =
            OnStage.theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

        ActorData actorData = OnStage.theActor(mainActorName).recall(SessionVariables.DATA_ACTOR.name());

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.DEV_ENV)));

        CppBody cppBody =getCppBody(actorData);

        actor.attemptsTo(CallPostWith.token(ServicePaths.pathCpp(), cppBody));
    }

    private CppBody getCppBody(ActorData actorData) {
        return CppBody.builder()
            .documentType("CC")
            .documentNumber(actorData.getDocumentNumber())
            .accountType("CUENTA_SIMPLE")
            .artCode(1)
            .atmWithdrawalsNumber(0)
            .cdtFundingAcct("")
            .cdtFundingId("")
            .cdtProfitsAcct("")
            .cdtProfitsId("")
            .cdtAmount("10000")
            .cdtTerm("365")
            .cdtTermination(1)
            .documentSignature(false)
            .interestRate(2.6)
            .officeWithdrawalsNumber(0)
            .requestCode(0)
            .requiredGMF(false)
            .build();
    }


}
