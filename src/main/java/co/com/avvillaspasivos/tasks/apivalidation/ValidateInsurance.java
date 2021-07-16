package co.com.avvillaspasivos.tasks.apivalidation;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.Schema;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateInsurance implements Task {

    public static Performable perform() {
        return instrumented(ValidateInsurance.class);
    }

    @Override
    @Step("{0} valida la información de la respuesta para Insurance Validation")
    public <T extends Actor> void performAs(T actor) {

        actor
            .attemptsTo(
                Ensure.that(
                    "Se valida que el cliente no tiene seguro",
                    response -> response.body("var2", Matchers.equalTo(false))),
                Schema.validation(ServicePaths.pathInsuranceValidationSchema()));
    }
}

