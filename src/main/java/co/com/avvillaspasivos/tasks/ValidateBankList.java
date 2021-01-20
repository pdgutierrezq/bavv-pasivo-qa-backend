/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */

package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.PsePage;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static co.com.avvillaspasivos.util.Constantes.BANK_LIST_ACTOR;
import static java.util.stream.Collectors.toList;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateBankList implements Task {

    public static Performable front() {
        return instrumented(ValidateBankList.class);
    }

    @Step("{0} valida la precarga en pantalla Pse")
    public <T extends Actor> void performAs(T actor) {
        String uiActor=OnStage.theActor(Constantes.MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

        List<String> bancosWs =
            OnStage.theActorCalled(BANK_LIST_ACTOR).recall(SessionVariables.BANK_LIST.name());

        List<String> bancosFront =
            PsePage.BANK_LIST
                .resolveAllFor(
                    OnStage.theActor(
                        uiActor))
                .stream()
                .map(WebElementFacade::getText)
                .collect(toList());

        OnStage.theActor(uiActor)
            .attemptsTo(
                Ensure.that(bancosFront).isEqualTo(bancosWs)
            );
    }
}
