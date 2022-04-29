package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.ELECTRONIC_SIGNATURE;

public class PostElectronicSignature extends Start {
    @Cuando("el realiza la firma electronica de documentos")
    public void elRealizaLaFirmaElectronicaDeDocumentos() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, ELECTRONIC_SIGNATURE));
    }
}
