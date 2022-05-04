/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.ui.CdtFeaturesPage;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformFlowCdt implements Task {
    private final String period;

    public PerformFlowCdt(String period) {
        this.period = period;
    }

  public static Performable type(String period) {
    return instrumented(PerformFlowCdt.class,period);
  }

  @Step("{0} realiza el flujo de CDT")
  public <T extends Actor> void performAs(T actor) {
    ActorData actorData = actor.recall(SessionVariables.DATA_ACTOR.name());
    actor.attemptsTo(BdUser.toBlock(false));

    actor.attemptsTo(
        TasksGroup.navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(Constantes.PRODUCT_CDT),
        Waits.loader(),
        PepSelection.option("no"),
        FillConfigurationCdt.type(period),
        Waits.loader(),
        Autentication.byOtp(),
        Waits.loader(120),
        AccountConfigurationCdt.perform(
            Constantes.ACCOUNT_FUNDING_TAG, Constantes.ACCOUNT_PROFIT_TAG),
        Click.on(CdtFeaturesPage.CONTINUE_BUTTON),
        DeclaringSelection.choose(Constantes.TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(actorData.isChannels())
            .andIfSo(SavingTips.waitAndGo())
            .otherwise(EnrollmentKey.perform()));
  }
}
