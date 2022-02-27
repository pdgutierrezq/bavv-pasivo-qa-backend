package co.com.bavv.pasivo.api.cucumber.steps.user;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateScript.UPDATE_HEADERS;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.USER_IDENTITY_GENERATE;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.USER_IDENTITY_VALIDATE;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostUserIdentitySteps extends Start {

    @Cuando("el solicita la validacion de la OTP")
    public void seValidaráLaOTP() {
        validateOtp();
    }

    public static void validateOtp() {
        actor();
        actor.attemptsTo(KarateRunner.run(UPDATE_HEADERS, USER_IDENTITY_VALIDATE));
    }

    @Cuando("el solicita la generacion de una OTP")
    public void elSolicitaLaGeneracionDeLaOTP() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, USER_IDENTITY_GENERATE));
    }
}

