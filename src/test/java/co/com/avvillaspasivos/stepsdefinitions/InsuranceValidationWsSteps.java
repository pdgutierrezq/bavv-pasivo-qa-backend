package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.GetFlowDataActor;
import co.com.avvillaspasivos.tasks.Schema;
import co.com.avvillaspasivos.tasks.apitask.GetCustomerConditions;
import co.com.avvillaspasivos.tasks.apitask.GetInsuranceValidation;
import co.com.avvillaspasivos.tasks.apivalidation.ValidateInsurance;
import co.com.avvillaspasivos.util.SessionVariables;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import org.hamcrest.Matchers;

import static co.com.avvillaspasivos.util.Constantes.SUPER_ACTOR;
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
