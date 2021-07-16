package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.TRANSACTION_ID_VALUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetInsuranceValidation implements Task {

    public static Performable post() {
        return instrumented(GetInsuranceValidation.class);
    }

    @Override
    @Step("{0} realiza el llamado del servicio validacion de seguro")
    public <T extends Actor> void performAs(T actor) {
        ActorData actorData = actor.recall(SessionVariables.DATA_ACTOR.name());

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

        actor.attemptsTo(
            Post.to(ServicePaths.pathInsuranceValidation())
                .with(
                    requestSpecification ->
                        requestSpecification
                            .header("Content-Type", ContentType.JSON)
                            .header("transaction-id", TRANSACTION_ID_VALUE)
                            .header("x-adl-channel", "bavv-pasivo-cdt-masivo")
                            .header("x-adl-document-type", actorData.getDocumentType())
                            .header("x-adl-document-number", actorData.getDocumentNumber())
                ));
    }


}


