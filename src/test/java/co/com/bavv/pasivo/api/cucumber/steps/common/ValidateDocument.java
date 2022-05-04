package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.VALIDATE_DOCUMENT;

public class ValidateDocument extends Start {
    @Cuando("el realiza el envio del documento a validar")
    public void elRealizaElEnvioDelDocumentoAValidar() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, VALIDATE_DOCUMENT));
    }
}
