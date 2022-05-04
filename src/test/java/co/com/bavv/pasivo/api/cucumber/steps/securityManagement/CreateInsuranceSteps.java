package co.com.bavv.pasivo.api.cucumber.steps.securityManagement;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.CREATE_INSURANCE;

public class CreateInsuranceSteps extends Start {
    @Cuando("el genera una peticion post al servicio de radicar seguro")
    public void elGeneraUnaPeticionPostAlServicioDeRadicarSeguro() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, CREATE_INSURANCE));
    }
}
