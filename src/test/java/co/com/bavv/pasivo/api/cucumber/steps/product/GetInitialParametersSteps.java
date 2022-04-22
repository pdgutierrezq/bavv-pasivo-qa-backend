package co.com.bavv.pasivo.api.cucumber.steps.product;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_GET;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.GET_PRODUCT_CONFIGURATION;

public class GetInitialParametersSteps extends Start {

    @Cuando("el solicita los parametros iniciales de la aplicacion")
    public void elSolicitaLosParametrosInicialesDeLaAplicacion() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_GET, GET_PRODUCT_CONFIGURATION));
    }
}
