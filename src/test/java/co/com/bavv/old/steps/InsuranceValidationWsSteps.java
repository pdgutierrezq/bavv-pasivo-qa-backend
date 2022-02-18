package co.com.bavv.old.steps;

import co.com.bavv.old.tasks.GetFlowDataActor;
import co.com.bavv.old.tasks.apitask.GetInsuranceValidation;
import co.com.bavv.old.tasks.apivalidation.ValidateInsurance;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class InsuranceValidationWsSteps {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que se obtiene un usuario tipo {string} para validar seguro")
    public void queSeObtieneUnUsuarioTipoParaValidarSeguro(String userType) {
        theActorCalled(userType).attemptsTo(GetFlowDataActor.type(userType));
    }


    @Cuando("se consulta si el usuario tiene seguro")
    public void seConsultaSiElUsuarioTieneSeguro() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                GetInsuranceValidation.post()
            );
    }

    @Entonces("se validara que el usuario no tiene seguro")
    public void seValidaraQueElUsuarioNoTieneSeguro() {
        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                ValidateInsurance.perform()
            );
    }


}
