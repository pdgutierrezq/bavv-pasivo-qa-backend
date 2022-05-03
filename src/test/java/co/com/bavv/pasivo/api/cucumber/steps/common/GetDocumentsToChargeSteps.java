package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.GET_DOCUMENTS_TO_CHARGE;

public class GetDocumentsToChargeSteps extends Start {
    @Cuando("el realiza la peticion de los documentos cargados")
    public void elRealizaLaPeticionDeLosDocumentosCargados() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, GET_DOCUMENTS_TO_CHARGE));
    }
}
