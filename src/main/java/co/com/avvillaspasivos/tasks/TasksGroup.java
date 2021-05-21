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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import static co.com.avvillaspasivos.tasks.SmallTasks.passCdtFeatures;
import static co.com.avvillaspasivos.util.Constantes.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
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
        navigateLaterAutheticationCda(), fillEconomicActivity(EMPLOYMENT_VALUE));
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
        fundingSelectBy("PSE"),
        passCdtFeatures(),
        DeclaringSelection.choose(TAG_CONFIRM),
        SignDocuments.perform(),
        Check.whether(the(EnrollmentPage.CONTINUE_BUTTON), isPresent())
            .andIfSo(EnrollmentKey.perform())
            .otherwise(SavingTips.waitAndGo()),
        Waits.loader());
  }

  public static Performable fillPseCdt() {
    return Task.where(
        "{0} diligencia formulario pse",
        navigateToPseCdt(),
        Click.on(PsePage.BANK_LIST_SELECT),
        Click.on(PsePage.FIRST_BANK),
        Click.on(PsePage.RADIO_NATURAL),
        Click.on(PsePage.CONTINUE_BUTTON),
        Waits.loader());
  }

  public static Performable navigateToContactDataCdt() {
    return Task.where(
        "{0} navega hasta la pagina de datos de contacto con un cliente desactualizado",
        navigateLaterAutheticationCdt(), fillEconomicActivity(EMPLOYMENT_VALUE));
  }

  public static Performable navigateAfterAccountConfigCdt(
      String economycActivity, String fundingType, String profitAccount) {
    String userType = theActorCalled(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    return Task.where(
        "{0} navega hasta superar configuracion de cuentas ",
        navigateLaterAutheticationCdt(),
        Check.whether(userType.equals(CLIENT_UPDATED))
            .andIfSo(
                Waits.loader(),
                AccountConfigurationCdt.perform(ACCOUNT_FUNDING_TAG, profitAccount))
            .otherwise(
                fillEconomicActivity(economycActivity),
                Check.whether(the(CommonWebElementsPage.LOADER), isVisible())
                    .andIfSo(Waits.loader()),
                FillContactInfo.fixed(),
                //FillContactInformation.perfom(),
                FillForeignInformation.perfom(),
                FillFinancialInformation.perfom(),
                AccountConfigurationCdt.perform(fundingType, profitAccount)));


  }

  public static Performable navigateToSendingCardCdt() {

    return Task.where(
        "{0} navega hasta la pagina de datos para envio de tarjeta ",
        navigateAfterAccountConfigCdt(EMPLOYMENT_VALUE, "PSE", NEW_ACCOUNT_PROFIT_TAG));
  }

  public static Performable navigateToDocumentLoadCdt(
      String economicActivity, String declarantOption) {

    return Task.where(
        "{0} navega hasta la pagina de cargue de documentos en CDT ",
        navigateAfterAccountConfigCdt(economicActivity, ACCOUNT_FUNDING_TAG, ACCOUNT_PROFIT_TAG),
        passCdtFeatures(),
        DeclaringSelection.choose(declarantOption));
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
                fillEconomicActivity(EMPLOYMENT_VALUE),
                Check.whether(the(CommonWebElementsPage.LOADER), isVisible())
                    .andIfSo(Waits.loader()),
                FillContactInfo.fixed(),
                FillForeignInformation.perfom(),
                FillFinancialInformation.perfom(),
                Waits.loader()));
  }

  public static Performable fillEconomicActivity(String economicActivity) {
    return Task.where(
        "{0} navega hasta la pagina de datos de contacto con un cliente desactualizado",
        Check.whether(EMPLOYMENT_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_EMPLOYMENT)),
        Check.whether(RETIRED_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_RETIRED)),
        Check.whether(HOME_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_HOME)),
        Check.whether(STUDENT_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_STUDENT)),
        Check.whether(INDEPENDENT_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_INDEPENDET)),
        Check.whether(INDEPENDENT_BUSINESS_VALUE.equals(economicActivity))
            .andIfSo(Click.on(EconomicActivityPage.RADIO_INDEPENDENT_BUSINESS)),
        Check.whether(
                INDEPENDENT_BUSINESS_VALUE.equals(economicActivity)
                    || INDEPENDENT_VALUE.equals(economicActivity))
            .andIfSo(
                Enter.theValue("0111").into(EconomicActivityPage.INPUT_CIUU).thenHit(Keys.TAB)),
        Click.on(EconomicActivityPage.CONTINUE_BUTTON));
  }

  public static Performable navigateLaterAutheticationCdt() {
    return Task.where(
        "{0} navega hasta la pagina datos personales",
        navigateToIdentificationFormCdt(),
        FormIdentification.fillAndContinue(PRODUCT_CDT),
        Waits.loader(),
        PepSelection.option("no"),
        FillConfigurationCdt.type(EXPIRATION_TAG),
        Waits.loader(),
        Autentication.byOtp());
  }

  public static Performable fundingSelectBy(String fundingType) {
    return Task.where(
        "{0} navega hasta la pagina datos personales",
        navigateLaterAutheticationCdt(),
        Waits.loader(),
        AccountConfigurationCdt.perform(fundingType, ACCOUNT_PROFIT_TAG));
  }

  public static Performable navigateToDigitalSignatureCdt() {
    return Task.where(
        "{0} navega hasta la pagina firma electronica y continua",
        navigateLaterAutheticationCdt(),
        Waits.loader(),
        AccountConfigurationCdt.perform(ACCOUNT_FUNDING_TAG, ACCOUNT_PROFIT_TAG),
        Click.on(CdtFeaturesPage.CONTINUE_BUTTON),
        DeclaringSelection.choose(TAG_NOT_CONFIRM),
        SignDocuments.perform());
  }

  public static Performable navigateLaterAutheticationCda() {
    return Task.where(
        "{0} navega hasta superar la autenticacion",
        navigateLaterRequiredGmfCda(),
        Check.whether(the(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE), isVisible())
            .andIfSo(
                InsuranceSelection.choose("acepta"),
                Remember.variable(SessionVariables.INSURANCE.name(), "acepta"))
            .otherwise(Remember.variable(SessionVariables.INSURANCE.name(), "no acepta")),
        Waits.loader(),
        Autentication.byOtp());
  }

  public static Performable navigateLaterRequiredGmfCda() {
    return Task.where(
        "{0} navega hasta superar la autenticacion",
        navigateToIdentificationForm(),
        FormIdentification.fillAndContinue(),
        Waits.loader(),
        PepSelection.option("no"),
        AccountSelection.type("Cuenta Digital"));
  }

  public static Performable navigateLaterForeignInformation() {
    return Task.where(
        "{0} navega hasta seleccionar las opciones de validacion del extranjero",
        FillContactInformation.perfom(), FillForeignInformation.perfom());
  }

  public static Performable openBankListPse() {
    return Task.where(
        "{0} abre el listado de bancos pse", Waits.loader(), Click.on(PsePage.BANK_LIST_SELECT));
  }
}
