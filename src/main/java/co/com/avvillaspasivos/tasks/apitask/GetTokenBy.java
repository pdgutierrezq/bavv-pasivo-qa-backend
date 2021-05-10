/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.BodyOtpValidate;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.CallPost;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetTokenBy implements Task {
    private final String env;

    public GetTokenBy(String env) {
        this.env = env;
    }
    public static Performable userIdentity(String env) {
        return instrumented(GetTokenBy.class,env);
    }

    @Override
    @Step("{0} obtiene token mediante user identity")
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(env)));

        BodyOtpValidate bodyOtpValidate = BodyOtpValidate.builder()
            .otpValue("12345678")
            .otpDesc("cbd42cc6-fd72-4902-8966-9e2eac3dd19b")
            .build();

        actor.attemptsTo(CallPost.pathBody(ServicePaths.pathUserIdentity(), bodyOtpValidate));

        String token= lastResponse().getBody().jsonPath().getString("userAccessToken.accessToken");

        actor.remember(SessionVariables.TOKEN.name(),token);

    }
}

