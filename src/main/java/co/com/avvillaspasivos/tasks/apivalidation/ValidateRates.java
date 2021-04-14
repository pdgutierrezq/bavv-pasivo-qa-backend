/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks.apivalidation;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.tasks.Schema;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateRates implements Task {

    public static Performable perform() {
        return instrumented(ValidateRates.class);
    }

    @Override
    @Step("{0} valida la información de la respuesta para Get Rates")
    public <T extends Actor> void performAs(T actor) {

        OnStage.theActorInTheSpotlight()
            .attemptsTo(
                Schema.validation(ServicePaths.pathGetRatesSchema()));
    }
}
