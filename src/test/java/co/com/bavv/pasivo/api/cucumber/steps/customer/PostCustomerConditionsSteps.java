package co.com.bavv.pasivo.api.cucumber.steps.customer;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.CUSTOMER_CONDITIONS;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostCustomerConditionsSteps extends Start {

    @Cuando("el consulta su estado en el banco")
    public void elConsultaSuEstadoEnElBanco() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, CUSTOMER_CONDITIONS));
    }
}
