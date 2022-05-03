package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.SAVE_DOCUMENT;

public class SaveDocumentSteps extends Start {
    @Cuando("el realiza el guardado del documento")
    public void elRealizaElGuardadoDelDocumento() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, SAVE_DOCUMENT));
    }
}
