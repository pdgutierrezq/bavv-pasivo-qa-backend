package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.SQS_CDA_DOCUMENTS;

public class SqsCdaDocumentsSteps extends Start {
    @Cuando("el realiza el envio de documentos")
    public void elRealizaElEnvioDeDocumentos() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, SQS_CDA_DOCUMENTS));
    }
}
