package co.com.bavv.pasivo.api.cucumber.steps.product;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.CREATE_PASSIVE_PRODUCT;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostCreatePassiveProductSteps extends Start {

    @Cuando("el crea un producto pasivo en el banco")
    public void elUsuarioCreaUnProductoPasivo() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, CREATE_PASSIVE_PRODUCT));
    }
}
