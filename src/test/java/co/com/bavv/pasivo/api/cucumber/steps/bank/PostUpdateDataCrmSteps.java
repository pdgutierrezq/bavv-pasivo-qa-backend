package co.com.bavv.pasivo.api.cucumber.steps.bank;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.UPDATE_DATA_CRM;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostUpdateDataCrmSteps extends Start {

    @Cuando("el actualiza la informacion en el CRM del banco")
    public void elActualizaLaInformacionEnElCRMDelBanco() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, UPDATE_DATA_CRM));
    }
}
