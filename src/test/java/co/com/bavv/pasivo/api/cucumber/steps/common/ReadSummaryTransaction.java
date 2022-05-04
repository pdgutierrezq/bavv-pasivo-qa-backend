package co.com.bavv.pasivo.api.cucumber.steps.common;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_GET;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.READ_SUMMARY_TRANSACTION;

public class ReadSummaryTransaction extends Start {
    @Cuando("el solicita la consulta al resumen de la transaccion")
    public void elSolicitaLaConsultaAlResumenDeLaTransaccion() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_GET, READ_SUMMARY_TRANSACTION));
    }
}
