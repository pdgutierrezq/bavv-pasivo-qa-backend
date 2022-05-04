package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_GET;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.PUBLIC_KEY;

public class GetPublicKeySteps extends Start {
    @Cuando("el consulta el servicio de llave publica")
    public void elConsultaElServicioDeLlavePublica() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_GET, PUBLIC_KEY));
    }
}
