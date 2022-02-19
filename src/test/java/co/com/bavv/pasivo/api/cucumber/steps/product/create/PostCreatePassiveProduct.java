package co.com.bavv.pasivo.api.cucumber.steps.product.create;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.CREATE_PASSIVE_PRODUCT;

import co.com.bavv.pasivo.api.cucumber.steps.user.identity.PostUserIdentitySteps;
import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import com.peterland.karate.api.screenplay.tasks.KarateVars;
import io.cucumber.java.es.Cuando;

public class PostCreatePassiveProduct extends Start {
//
//    @Before
//    public void before() {
//        actor();
//        PostUserIdentitySteps.getToken();
//    }

    @Cuando("el usuario crea un producto pasivo")
    public void elUsuarioCreaUnProductoPasivo() {
        PostUserIdentitySteps.getToken();
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, CREATE_PASSIVE_PRODUCT));
    }
}
