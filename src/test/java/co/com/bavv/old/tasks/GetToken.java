/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.bavv.old.tasks;

import co.com.bavv.old.model.BodyOtpValidate;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetToken implements Task {

    public static Performable userIdentity() {
        return instrumented(GetToken.class);
    }

    @Override
    @Step("{0} obtiene token mediante user identity")
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

        BodyOtpValidate bodyOtpValidate = BodyOtpValidate.builder()
            .otpValue("12345678")
            .otpDesc("cbd42cc6-fd72-4902-8966-9e2eac3dd19b")
            .build();

        actor.attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyOtpValidate));

        String token= lastResponse().getBody().jsonPath().getString("userAccessToken.accessToken");

        actor.remember(SessionVariables.TOKEN.name(),token);

    }
}

