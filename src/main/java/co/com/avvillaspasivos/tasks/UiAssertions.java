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
import co.com.avvillaspasivos.model.CrmResponseData;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.ui.*;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.Report;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.avvillaspasivos.util.Constantes.*;
import static co.com.avvillaspasivos.util.Util.cleanMoneyFormat;
import static java.util.stream.Collectors.toList;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class UiAssertions {

  private UiAssertions() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validateNameOnElectronicSign() {
    ActorData actorData =
        theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
    return Task.where(
        "{0} valida que el nombre ingresado en el formulario este presente",
        Ensure.that(ElectronicSignaturePage.TITLE)
            .text()
            .containsIgnoringCase(actorData.getFirstName()));
  }

  public static Performable validateAutocompleteCityAddress() {

    return Task.where(
        "{0} valida autocompletar de ciudad, campo texto y check transporte masivo",
        Ensure.that(
                LIST_CITIES.contains(
                    AddressPage.TEXT_CITY.resolveFor(theActorInTheSpotlight()).getValue()))
            .isTrue(),
        Ensure.that(AddressPage.TEXT_ADDRESS).value().isEmpty());
  }

  public static Performable validateCityListItem() {
    List<String> birthCityListUi = getListCitiesFromDropdown(PersonalDataPage.CITY_LIST_ITEM);

    return Task.where(
        "{0} valida que ciudades coincidan con la lista de domina",
        Ensure.that(LIST_CITIES_FULL).isEqualTo(birthCityListUi));
  }

  public static Performable validateCityList() {
    List<String> cityListUi = getCityAddressList();
    Report.logListCompared(LIST_CITIES, cityListUi);

    return Task.where(
        "{0} valida que ciudades coincidan con la lista de domina",
        Ensure.that(LIST_CITIES.equals(cityListUi)).isTrue());
  }

  private static List<String> getCityAddressList() {
    List<String> cityListUi = new ArrayList<>();
    AddressPage.LIST_TEXT_CITIES
        .resolveAllFor(theActorInTheSpotlight())
        .forEach(i -> cityListUi.add(i.getText()));
    return cityListUi;
  }

  private static List<String> getListCitiesFromDropdown(Target dropDown) {
    return dropDown.resolveAllFor(OnStage.theActorInTheSpotlight()).stream()
        .map(WebElementFacade::getText)
        .collect(toList());
  }

  public static Performable validateInvalidWordsOnAddres(String errorText) {
    return Task.where(
        "{0} valida que las palabras invalidas generen error",
        ValidateInvalidWords.onSendAddress(errorText));
  }

  public static Performable validateAlert(String errorText) {

    return Task.where(
        "{0} valida que se presente la alerta de direccion invalida",
        Ensure.that(CommonWebElementsPage.ALERT_INVALID).text().isEqualToIgnoringCase(errorText));
  }

  public static Performable validateCrmAddress() {
    String crmAddress =
        theActorInTheSpotlight().recall(String.valueOf(SessionVariables.CRM_ADDRESS));

    return Task.where(
        "{0} valida que la direccion de Crm no se modifico",
        Ensure.that(AddressPage.TEXT_ADDRESS).value().isEqualToIgnoringCase(crmAddress));
  }

  public static Performable validateIncomeFormat() {
    return Task.where(
        "{0} valida que presenta formato numero",
        Ensure.that(IdentificationPage.SALARY_INPUT).value().contains("$"),
        Ensure.that(IdentificationPage.SALARY_INPUT).value().contains("."));
  }

  public static Performable validateMinIncome(String msg) {
    return Task.where(
        "{0} valida que solo este presente la card de cuenta Pro",
        Ensure.that(IdentificationPage.ALERT_ERROR).textContent().isEqualToIgnoringCase(msg));
  }

  public static Performable validateVisibilityPopUpInsurance(boolean validation) {
    AnonymousTask task;
    if (validation) {
      task =
          Task.where(
              "{0} valida que este presente el pop up de seguros",
              Ensure.that(InsuranceOfferPage.POP_UP_SEE_MORE).isDisplayed());
    } else {
      task =
          Task.where(
              "{0} valida que no este presente el pop up de seguros",
              Ensure.that(InsuranceOfferPage.POP_UP_SEE_MORE).isNotDisplayed());
    }

    return task;
  }

  public static Performable validateAccountSelectionWithCat(String text) {
    return Task.where(
        "{0} valida que solo este presente la card de cuenta Pro",
        Ensure.that(ProductOfferingPage.TITLE_PRODUCT_OFFERING).textContent().contains(text),
        Ensure.that(ProductOfferingPage.FIRST_CARD).textContent().contains("PRO"),
        Ensure.that(ProductOfferingPage.RADIO_SIMPLE).isNotDisplayed());
  }

  public static Performable validateAccountOffering(String text, String account, Target radio) {
    return Task.where(
        "{0} valida el titulo de la oferta para cuenta simple",
        Ensure.that(ProductOfferingPage.TITLE_PRODUCT_OFFERING).textContent().contains(text),
        Ensure.that(ProductOfferingPage.FIRST_CARD).textContent().contains(account),
        Ensure.that(radio.resolveFor(theActorInTheSpotlight()).isSelected()).isTrue());
  }

  public static Performable validateInsuranceOffer() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla oferta de seguro",
        WaitUntil.the(InsuranceOfferPage.RADIO_ACCEPT_INSURANCE, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.insuranceOfferPath()));
  }

  public static Performable validateProductOfferingCharge() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla oferta de productos",
        WaitUntil.the(ProductOfferingPage.RADIO_PRO, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.productOfferingPath()));
  }

  public static Performable validateAccoutPackageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de selección de paquetes",
        WaitUntil.the(AccountPackagePage.FORM_ACCOUNT_PACKAGE, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.accountPackagePath()));
  }

  public static Performable validateOtpPageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de identificacion mediante Otp",
        WaitUntil.the(AutenticacionPage.LIST_OTP_INPUT, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.otpPagePath()));
  }

  public static Performable validateDeliveryAddressCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de direccion de entrega",
        WaitUntil.the(AddressPage.FORM_ADDRESS, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.deliveryAddressPagePath()));
  }

  public static Performable validateChannelEnrollmentPageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla tips de ahorro",
        WaitUntil.the(ChannelEnrollmentPage.CONTAINER_MAIN, isVisible()),
        Ensure.thatTheCurrentPage()
            .currentUrl()
            .contains(ServicePaths.channelEnrollmentPagePath()));
  }

  public static Performable validateSavingTipsPageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla tips de ahorro",
        WaitUntil.the(SavingTipsPage.ANIMATION, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.savingTipsPagePath()));
  }

  public static Performable validateDeclaringPageCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de no declarante",
        WaitUntil.the(DeclaringPage.RADIO_SI, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.declaringPagePath()));
  }

  public static Performable validateAddressTextBoxPrecharged() {
    return Task.where(
        "{0} valida la carga de informacion en los campos de texto de direccion",
        Ensure.that(AddressPage.TEXT_CITY).value().isNotEmpty(),
        Ensure.that(AddressPage.TEXT_ADDRESS).value().isNotEmpty());
  }

  public static Performable validateContinueAddressDisabled() {
    return Task.where(
        "{0} valida opcion continuar de direccion deshabilitada",
        Ensure.that(AddressPage.CONTINUE_BUTTON).isDisabled());
  }

  public static Performable validateContinueEnroomentDisabled() {
    return Task.where(
        "{0} valida opcion continuar de enrolamiento deshabilitada",
        Ensure.that(EnrollmentPage.CONTINUE_BUTTON).isDisabled());
  }

  public static Performable validateContinueOptionPep() {
    return Task.where(
        "{0} valida opcion continuar pep", Ensure.that(PepPage.CONTINUE_BUTTON).isEnabled());
  }

  public static Performable validateContinueOptionInsurance() {
    return Task.where(
        "{0} valida opcion continuar oferta de seguro",
        Ensure.that(InsuranceOfferPage.CONTINUE_BUTTON).isEnabled());
  }

  public static Performable validateSelectedRadio(Target radio) {
    return Task.where(
        "{0} valida que el la tarjeta de la cuenta este seleccionada",
        Ensure.that(radio.resolveFor(theActorInTheSpotlight()).isSelected()).isTrue());
  }

  public static Performable validarPantallaErrorDeProceso() {
    return Task.where(
        "{0} valida la corrección de la pantalla de error de proceso",
        Ensure.that(ErrorPage.TEXT_MENSAJE_PRINCIPAL)
            .text()
            .isEqualToIgnoringCase(TEXTO_ERROR_PROCESO_PRINCIPAL),
        Ensure.that(ErrorPage.TEXT_MENSAJE_SECUNDARIO)
            .text()
            .isEqualToIgnoringCase(TEXTO_ERROR_PROCESO_SECUNDARIO),
        Ensure.that(ErrorPage.BTN_DONDE_ENCONTRARNOS).isEnabled());
  }

  public static Performable validarBotonContinuarLanding() {
    return Task.where(
        "{0} valida boton continuar landing",
        WaitUntil.the(IdentificationPage.CONTINUE_BUTTON, isVisible()),
        Ensure.thatTheCurrentPage().currentUrl().contains(Constantes.PATH_FORM_IDENTIFICACION));
  }

  public static Performable validarPantallaPep() {
    return Task.where(
        "{0} valida la ubicacion en la pantalla pep",
        Ensure.thatTheCurrentPage().currentUrl().contains(ServicePaths.pepPagePath()));
  }

  public static Performable validatePopUpEs() {
    return Task.where(
        "{0} valida la presencia del pop up de firma electronica",
        Ensure.that(ElectronicSignaturePage.POP_UP_ES).isDisplayed());
  }

  public static Performable validarPopUpPep() {
    return Task.where(
        "{0} valida la presencia del pop up de pep", Ensure.that(PepPage.POP_UP_PEP).isDisplayed());
  }

  public static Performable validatePopUpDirection() {
    return Task.where(
        "{0} valida la presencia del pop up de direccion",
        Ensure.that(AddressPage.POP_UP).isDisplayed(),
        Ensure.that(AddressPage.POP_UP).text().contains(TEST_DIRECTION));
  }

  public static Performable validateContinueButtonFormIdentificationEnabled() {
    return Task.where(
        "{0} valida boton continuar formulario identificacion habilitado",
        Scroll.to(IdentificationPage.CONTINUE_BUTTON),
        Ensure.that(IdentificationPage.CONTINUE_BUTTON).isEnabled());
  }

  public static Performable botonContinuarFormIdentificacionDisabled() {
    return Task.where(
        "{0} valida boton continuar landing deshabilitado",
        Scroll.to(IdentificationPage.CONTINUE_BUTTON),
        Ensure.that(IdentificationPage.CONTINUE_BUTTON).isDisabled());
  }

  public static Performable cantidadMsjObligatoriosFormIdentificacion() {
    return Task.where(
        "{0} valida mensajes de error en formulario identificacion",
        Ensure.that(IdentificationPage.MSJ_CAMPOS_OBLIG).values().hasSize(5));
  }

  public static Performable validarMensajeCelularErrado(String mensaje) {
    return Task.where(
        "{0} valida mensajes de error por celular errado",
        Ensure.that(IdentificationPage.ALERT_ERROR).text().contains(mensaje));
  }

  public static Performable validatePopUpHabeasData() {
    return Task.where(
        "{0} valida presencia de popup habeas data",
        Ensure.that(IdentificationPage.VER_MAS_HABEAS_DATA_POPUP).isDisplayed());
  }

  public static Performable validaFormularioIdentificacionHabilitado() {
    return Task.where(
        "{0} valida que no este presente el popup de habeas data",
        Ensure.that(IdentificationPage.VER_MAS_HABEAS_DATA_POPUP).isNotDisplayed());
  }

  public static Performable validarCantidadLimiteTexto() {
    return Task.where(
        "{0} valida que no se supere el limite de texto en campos de texto",
        Ensure.that(IdentificationPage.PRIMER_NOMBRE_INPUT).value().hasSize(20),
        Ensure.that(IdentificationPage.PRIMER_APELLIDO_INPUT).value().hasSize(20));
  }

  public static Performable validateSalaryLimitForm() {

    return Task.where(
        "{0} valida que no se supere el limite del salario",
        Ensure.that(
                IdentificationPage.SALARY_INPUT
                    .resolveFor(theActorInTheSpotlight())
                    .getValue()
                    .replace(" ", "")
                    .replace("$", "")
                    .replace(".", ""))
            .hasSize(SALARY_SIZE));
  }

  public static Performable validarCantidadTextoConfirmacionCel() {
    return Task.where(
        "{0} valida que no exista informacion despues de pegar sobre el campo confirmacion celular",
        Ensure.that(IdentificationPage.PRIMER_NOMBRE_INPUT).value().hasSize(0));
  }

  public static Performable validateDeclaringPopUpClosed() {
    return Task.where(
        "{0} valida que el formulario de declarante este habilitado",
        Ensure.that(DeclaringPage.POP_UP_BUTTON).isNotDisplayed());
  }

  public static Performable validateDigitalSignatureCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de firma electronica",
        WaitUntil.the(ElectronicSignaturePage.CHECK_AUTORIZATION, isVisible()),
        Ensure.thatTheCurrentPage()
            .currentUrl()
            .contains(ServicePaths.electronicSignaturePagePath()));
  }

  public static Performable validatePseCharge() {
    return Task.where(
        "{0} valida la carga de la pantalla de Pse",
        Ensure.thatTheCurrentPage().currentUrl().contains("pse"));
  }

  public static Performable validateContactPreload() {
    CrmResponseData crmResponseData =
        theActorCalled(CRM_ACTOR).recall(SessionVariables.CRM_DATA.name());

    return Task.where(
        "{0} valida la precarga de informacion en datos de contacto",
        Check.whether(the(CommonWebElementsPage.LOADER), isVisible()).andIfSo(Waits.loader()),
        Ensure.that(ContactInformationPage.TEXTBOX_MAIL)
            .value()
            .isEqualToIgnoringCase(crmResponseData.getMail()),
        Ensure.that(ContactInformationPage.TEXTBOX_MAIL_COPY)
            .value()
            .isEqualToIgnoringCase(crmResponseData.getMail()),
//        Ensure.that(ContactInformationPage.TEXTBOX_CITY)
//            .value()
//            .isEqualTo(crmResponseData.getCityAddress()),
        Ensure.that(ContactInformationPage.TEXTBOX_PHONE)
            .value()
            .isEqualTo(crmResponseData.getPhone()),
        Ensure.that(ContactInformationPage.TEXTBOX_ADDRESS)
            .value()
            .isEqualTo(crmResponseData.getAddress()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_NAME)
            .value()
            .isEqualTo(crmResponseData.getCompanyName()),
//        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_CITY)
//            .value()
//            .isEqualTo(crmResponseData.getCompanyCity()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_PHONE)
            .value()
            .isEqualTo(crmResponseData.getCompanyPhone()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_ADDRESS)
            .value()
            .isEqualTo(crmResponseData.getCompanyAddress()));
  }

  public static Performable validateFinancialInfPreload() {
    String uiActorName = theActor(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    CrmResponseData crmResponseData =
        theActorCalled(CRM_ACTOR).recall(SessionVariables.CRM_DATA.name());

    return Task.where(
        "{0} valida la precarga de datos en informacion financiera",
        Ensure.that(
                cleanMoneyFormat(
                    FinancialInformationPage.TEXT_ASSETS
                        .resolveFor(theActor(uiActorName))
                        .getValue()))
            .isEqualTo(crmResponseData.getAssetsnumber()),
        Ensure.that(
                cleanMoneyFormat(
                    FinancialInformationPage.TEXT_LIABILITIES
                        .resolveFor(theActor(uiActorName))
                        .getValue()))
            .isEqualTo(crmResponseData.getLiabilitiesNumber()),
        Ensure.that(
                cleanMoneyFormat(
                    FinancialInformationPage.TEXT_MONTHLY_EXPENSES
                        .resolveFor(theActor(uiActorName))
                        .getValue()))
            .isEqualTo(crmResponseData.getMontlyExpenses()));
  }
}
