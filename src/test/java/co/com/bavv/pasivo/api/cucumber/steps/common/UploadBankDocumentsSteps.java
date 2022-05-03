package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.UPLOAD_BANK_DOCUMENTS;

public class UploadBankDocumentsSteps extends Start {
    @Cuando("el realiza el cargue de documentos")
    public void elRealizaElCargueDeDocumentos() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, UPLOAD_BANK_DOCUMENTS));
    }
}
