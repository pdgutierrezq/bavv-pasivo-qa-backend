/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.tasks.TasksGroup.navigateToIdentificationForm;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PerformFlow implements Task {
  private final String accountType;
  private final String insurance;

  public PerformFlow(String accountType, String insurance) {
    this.accountType = accountType;
    this.insurance = insurance;
  }

  public static Performable type(String accountType, String insurance) {
    return instrumented(PerformFlow.class, accountType, insurance);
  }

  @Step("{0} realiza el flujo con  #accountType y #insurance")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        navigateToIdentificationForm(),
        FormIdentification.fillAndContinue(),
        Waits.loader(),
        AccountSelection.type(accountType),
        RequiredGmf.selection(TAG_ACCEPT),
        InsuranceSelection.choose(insurance, true),
        Waits.loader(),
        Autentication.byOtp(),
        EditAddress.toSendCard(TAG_NOT_EDIT),
        DeclaringSelection.choose(TAG_CONFIRM),
        SignDocuments.perform(),
        SavingTips.waitAndGo(),
        Waits.loader());
  }
}
