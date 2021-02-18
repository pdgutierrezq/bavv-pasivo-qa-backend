/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.ui.*;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

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

  public static Performable navigateToContactDataCDa() {
    return Task.where(
        "{0} navega hasta la pagina de informacion de contacto en Cda",
        navigateLaterAutheticationCda(), fillEconomicActivity());
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

  public static Performable navigateToIdentificationFormCdt() {
    return Task.where(
        "{0} navega hasta la pagina formulario de identificacion de cdt",
        GoTo.homePageCdt(), GoTo.openCdt());
  }

  public static Performable navigateToPseCdt() {
    return Task.where(
        "{0} navega hasta la pagina pse",
        navigateLaterAutheticationCdt(),
        Check.whether(the(CommonWebElementsPage.LOADER), isVisible()).andIfSo(Waits.loader()),
        Click.on(AccountConfigurationPageCdt.PSE_BUTTON));
  }

  public static Performable navigateToContactDataCdt() {
    return Task.where(
        "{0} navega hasta la pagina de datos de contacto con un cliente desactualizado",
        navigateLaterAutheticationCdt(), fillEconomicActivity());
  }

  public static Performable navigateToSendingCardCdt() {
    String userType = theActorCalled(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    return Task.where(
        "{0} navega hasta la pagina de datos para envio de tarjeta ",
        navigateLaterAutheticationCdt(),
        Check.whether(userType.equals(CLIENT_UPDATED))
            .andIfSo(Waits.loader(), Click.on(AccountConfigurationPageCdt.SENDING_CARD_LINK))
            .otherwise(
                fillEconomicActivity(),
                Check.whether(the(CommonWebElementsPage.LOADER), isVisible())
                    .andIfSo(Waits.loader()),
                FillContactInfo.fixed(),
                FillForeignInformation.perfom(),
                FillFinancialInformation.perfom(),
                Click.on(AccountConfigurationPageCdt.SENDING_CARD_LINK)));
  }

  public static Performable navigateToSendingCardCda() {
    String userType = theActorCalled(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());
    OnStage.theActor(userType).entersTheScene();

    return Task.where(
        "{0} navega hasta la pagina de datos para envio de tarjeta para Cda ",
        navigateLaterAutheticationCda(),
        Check.whether(userType.equals(CLIENT_UPDATED))
            .andIfSo(Waits.loader())
            .otherwise(
                fillEconomicActivity(),
                Check.whether(the(CommonWebElementsPage.LOADER), isVisible())
                    .andIfSo(Waits.loader()),
                FillContactInfo.fixed(),
                FillForeignInformation.perfom(), FillFinancialInformation.perfom(),
                Waits.loader()));
  }

  public static Performable fillEconomicActivity() {
    return Task.where(
        "{0} navega hasta la pagina de datos de contacto con un cliente desactualizado",
        Click.on(EconomicActivityPage.RADIO_EMPLOYMENT),
        Click.on(EconomicActivityPage.CONTINUE_BUTTON));
  }

  public static Performable navigateLaterAutheticationCdt() {
    return Task.where(
        "{0} navega hasta la pagina datos personales",
        navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(PRODUCT_CDT),
        Waits.loader(),
        PepSelection.option("no"),
        FillConfigurationCdt.type(),
        Waits.loader(),
        Autentication.byOtp());
  }

  public static Performable navigateToDigitalSignatureCdt() {
    return Task.where(
        "{0} navega hasta la pagina firma electronica y continua",

        navigateLaterAutheticationCdt(),
        Waits.loader(),
        AccountConfigurationCdt.perform(),
        DeclaringSelection.choose(TAG_NOT_CONFIRM),
        SignDocuments.perform()
        );
  }

  public static Performable navigateLaterAutheticationCda() {
    return Task.where(
        "{0} navega hasta superar la autenticacion",
        navigateToIdentificationForm(),
        FormIdentification.fillAndContinue(),
        Waits.loader(),
        PepSelection.option("no"),
        AccountSelection.type("Cuenta Digital"),
        Check.whether(the(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE), isVisible())
            .andIfSo(
                InsuranceSelection.choose("acepta"),
                Remember.variable(SessionVariables.INSURANCE.name(), "acepta"))
            .otherwise(Remember.variable(SessionVariables.INSURANCE.name(), "no acepta")),
        Waits.loader(),
        Autentication.byOtp());
  }

  public static Performable navigateLaterForeignInformation() {
    return Task.where(
        "{0} navega hasta seleccionar las opciones de validacion del extranjero",
        FillContactInformation.perfom(), FillForeignInformation.perfom());
  }

  public static Performable openBankListPse() {
    return Task.where("{0} abre el listado de bancos pse", Click.on(PsePage.BANK_LIST_SELECT));
  }
}
