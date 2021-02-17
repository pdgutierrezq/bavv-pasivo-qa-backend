/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.ActorData;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.tasks.TasksGroup.navigateToIdentificationFormCdt;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformFlowCdt implements Task {

  public static Performable type() {
    return instrumented(PerformFlowCdt.class);
  }

  @Step("{0} realiza el flujo de CDT")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData = actor.recall(SessionVariables.DATA_ACTOR.name());
    actor.attemptsTo(BdUser.toBlock(false));

    actor.attemptsTo(
        navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(PRODUCT_CDT),
        Waits.loader(),
        PepSelection.option("no"),
        FillConfigurationCdt.type(),
        Waits.loader(),
        Autentication.byOtp(),
        Waits.loader(120),
        AccountConfigurationCdt.perform(),
        DeclaringSelection.choose(TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(actorData.isChannels())
            .andIfSo(SavingTips.waitAndGo())
            .otherwise(EnrollmentKey.option(CORRECT_PASS_OPTION)));
  }
}
