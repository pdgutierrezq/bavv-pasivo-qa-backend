package com.bavv.pasivo.api.features.adl.user.identity;

import static com.bavv.pasivo.api.model.karate.def.KarateScript.UPDATE_HEADERS;
import static com.bavv.pasivo.api.model.karate.def.KarateStaticResource.USER_IDENTITY;

import com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostUserIdentitySteps extends Start {

    @Cuando("se validará la OTP")
    public void seValidaráLaOTP() {
//        actor.has(AnInfo.configuredTo(QUERY_GET_BLOCK_DETAIL));
//        actor.attemptsTo(KarateRunner.run(UPDATE_HEADERS, USER_IDENTITY));
    }
}

