/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.model.BodyGetPdf;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPdf implements Task {

    public static Performable post() {
        return instrumented(GetPdf.class);
    }

    @Override
    @Step("{0} obtiene el pdf correspondiente al flujo")
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase()));

        BodyGetPdf bodyGetPdf =actor.recall(SessionVariables.GET_PDF_CONDITIONS.name());

        actor.attemptsTo(CallPostWith.token("get-pdf", bodyGetPdf));
    }

}
