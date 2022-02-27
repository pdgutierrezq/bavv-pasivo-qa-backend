package co.com.bavv.pasivo.api.cucumber.steps.customer;

import static co.com.bavv.pasivo.api.karate.def.KarateScript.PASSIVE_API;
import static co.com.bavv.pasivo.api.karate.def.KarateStaticResource.CUSTOMER_ACCOUNTS;

import co.com.bavv.pasivo.utils.Start;
import com.peterland.karate.api.screenplay.tasks.KarateRunner;
import io.cucumber.java.es.Cuando;

public class PostCustomerAccountsSteps extends Start {

    @Cuando("el consulta si tiene cuentas CAT")
    public void elConsultaSiTieneCuentasCAT() {
        actor.attemptsTo(KarateRunner.run(PASSIVE_API, CUSTOMER_ACCOUNTS));
    }
}
