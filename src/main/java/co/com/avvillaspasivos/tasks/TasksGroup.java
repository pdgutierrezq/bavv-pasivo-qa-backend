/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.DeclaringPage;
import co.com.avvillaspasivos.ui.ElectronicSignaturePage;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.avvillaspasivos.util.Constantes.*;

public class TasksGroup {
  private TasksGroup() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable navigateToProductOfferingWithSalary(String salary) {
    return Task.where(
        "{0} navega hasta la pagina de ofrecimiento de cuentas",
        navigateToIdentificationForm(),
        FormIdentification.fillWithSalaryAndContinue(salary),
        Waits.loader());
  }

  public static Performable navigateToProductOffering() {
    return Task.where(
        "{0} navega hasta la pagina de ofrecimiento de cuentas",
        navigateToIdentificationForm(), FormIdentification.fillAndContinue(), Waits.loader());
  }

  public static Performable navigateToInsuranceOffering() {
    return Task.where(
        "{0} navega hasta la pagina de ofrecimiento de seguro",
        navigateToProductOffering(), AccountSelection.type(TAG_SIMPLE_ACCOUNT));
  }

  public static Performable navigateToSendCard() {
    return Task.where(
        "{0} navega hasta la pagina de envio de tarjeta",
        navigateToInsuranceOffering(),
        InsuranceSelection.choose(TAG_ACCEPT),
        Waits.loader(),
        Autentication.byOtp());
  }

  public static Performable passSendCardScreen() {
    return Task.where(
        "{0} avanza de la pagina envio de tarjeta",
        navigateToSendCard(), EditAddress.toSendCard(TAG_NOT_EDIT));
  }

  public static Performable navigateToDeclaringScreen(
      boolean continueOption, boolean declaringOption) {
    AnonymousTask task;

    if (continueOption) {
      Target radioOption = (declaringOption) ? DeclaringPage.RADIO_SI : DeclaringPage.RADIO_NO;

      task =
          Task.where(
              "{0} navega hasta la pagina de declarante y continua",
              passSendCardScreen(), Click.on(radioOption), Click.on(DeclaringPage.CONTINUE_BUTTON));
    } else {
      task = Task.where("{0} navega hasta la pagina de declarante", passSendCardScreen());
    }
    return task;
  }

  public static Performable navigateToEnrollmentScreen() {
    return Task.where(
        "{0} navega hasta la pagina de enrolamiento",
        navigateToElectronicSignatureScreen(),
        Click.on(ElectronicSignaturePage.CHECK_AUTORIZATION),
        Click.on(ElectronicSignaturePage.CONTINUE_BUTTON),
        Waits.loader());
  }

  public static Performable navigateToElectronicSignatureScreen() {
    return Task.where(
        "{0} navega hasta la pagina de firma electronica",
        navigateToDeclaringScreen(true, true), Waits.loader());
  }

  public static Performable navigateToIdentificationForm() {
    return Task.where(
        "{0} navega hasta la pagina formulario de identificacion",
        GoTo.homePage(), GoTo.openAccount(), FormIdentification.validatePageLoad());
  }
}
