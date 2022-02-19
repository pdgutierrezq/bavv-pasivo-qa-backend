package co.com.bavv.pasivo.api.cucumber.steps.user.identity;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.UPDATE_HEADERS;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.USER_IDENTITY;

import co.com.bavv.pasivo.api.screenplay.data.AnInfo;
import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostUserIdentitySteps extends Start {

    @Cuando("se validará la OTP")
    public void seValidaráLaOTP() {
//        actor.has(AnInfo.configuredTo(USER_IDENTITY));
        getToken();
    }

    public static void getToken() {
        actor();
        actor.attemptsTo(KarateRunner.run(UPDATE_HEADERS, USER_IDENTITY));
    }
}

