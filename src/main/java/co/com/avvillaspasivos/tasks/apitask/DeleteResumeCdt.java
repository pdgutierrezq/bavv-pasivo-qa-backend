/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks.apitask;

import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteResumeCdt implements Task {

    public static Performable delete() {
        return instrumented(DeleteResumeCdt.class);
    }

    @Override
    @Step("{0} elimina informacion en base de datos para el resumen de cdt")
    public <T extends Actor> void performAs(T actor) {

        actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.DEV_ENV)));

        actor.attemptsTo(CallDeleteWith.token("delete-resume-cdt"));

    }

}
