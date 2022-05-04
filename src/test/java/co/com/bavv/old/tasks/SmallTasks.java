/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.bavv.old.ui.CdtFeaturesPage;
import co.com.bavv.old.ui.CommonWebElementsPage;
import co.com.bavv.old.ui.DeclaringPage;
import co.com.bavv.old.ui.ElectronicSignaturePage;
import co.com.bavv.old.ui.IdentificationPage;
import co.com.bavv.old.ui.InsuranceOfferPage;
import co.com.bavv.old.ui.PersonalDataPage;
import co.com.bavv.old.ui.SendingCardPage;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

public class SmallTasks {

    private SmallTasks() {
        throw new IllegalStateException("Utility class");
    }

    public static Performable rememberExpectedGetPdfCode(String pdfConditions) {
        return Task.where(
            "{0} recuerda el codigo esperado para get pdf ",
            Remember.variable(
                SessionVariables.CODE_PDF_EXPECTED_CONDITIONS.name(),
                Constantes.pdfCodeExpectedMap.get(pdfConditions)));
    }

    public static Performable rememberUserPdfConditions(String pdfConditions) {
        return Task.where(
            "{0} recuerda las condiciones para el consumo del servicio get pdf",
            Remember.variable(
                SessionVariables.GET_PDF_CONDITIONS.name(),
                Constantes.pdfOptionsMap.get(pdfConditions)));
    }

    public static Performable continueElectronicSignature() {
        return Task.where(
            "{0} selecciona continuar en firma electronica",
            Click.on(ElectronicSignaturePage.CONTINUE_BUTTON), Waits.loader());
    }

    public static Performable authorizeElectronicSignature() {
        return Task.where(
            "{0} autoriza firma electronica", Click.on(ElectronicSignaturePage.CHECK_AUTORIZATION));
    }

    public static Performable seeMoreInsurance() {
        return Task.where(
            "{0} da clic sobre ver mas de oferta de seguro",
            Click.on(InsuranceOfferPage.LINK_SEE_MORE));
    }

    public static Performable understoodPopupButton() {
        return Task.where(
            "{0} da clic sobre entendido del pop up oferta de seguro",
            Click.on(InsuranceOfferPage.UNDERSTOOD_POP_UP_BUTTON));
    }

    public static Performable understoodHabeasData() {
        return Task.where(
            "{0} da clic sobre entendido de habeas data",
            Click.on(IdentificationPage.ENTENDIDO_HABEAS_DATA_BUTTON));
    }

    public static Performable closeHabeasData() {
        return Task.where(
            "{0} da clic sobre cerrar de habeas data",
            Click.on(IdentificationPage.CERRAR_HABEAS_DATA_BUTTON));
    }

    public static Performable closeDeclaringPopUp() {
        return Task.where(
            "{0} da clic sobre dentendido en pop up declarante",
            Click.on(DeclaringPage.POP_UP_BUTTON));
    }

    public static Performable seeMoreMasHabeasData() {
        return Task.where(
            "{0} da clic sobre ver mas de habeas data",
            Click.on(IdentificationPage.VER_MAS_HABEAS_DATA_BUTTON));
    }

    public static Performable popUpDeclaring() {
        return Task.where(
            "{0} ingresa en en el pop up de declarante", Click.on(DeclaringPage.POP_UP_LINK));
    }

    public static Performable popUpElectronicSignature() {
        return Task.where(
            "{0} ingresa en en el pop up de firma electronica",
            Click.on(ElectronicSignaturePage.POP_UP_LINK));
    }

    public static Performable passCdtFeatures() {
        return Task.where(
            "{0} avanza en la pagina de caracteristicas Cdt",
            Click.on(CdtFeaturesPage.CONTINUE_BUTTON));
    }

    public static Performable leaveEmptyFields() {
        return Task.where(
            "{0} ingresa vacio en ciudad y direccion",
            leaveEmptyCityField(), Enter.theValue(" ").into(SendingCardPage.TEXT_ADDRESS));
    }

    public static Performable leaveEmptyCityField() {
        return Task.where(
            "{0} ingresa vacio en ciudad", Enter.theValue(" ").into(SendingCardPage.TEXT_CITY));
    }

    public static Performable insertInvalidCity() {
        Faker faker = new Faker();
        return Task.where(
            "{0} ingresa una ciudad sin cobertura",
            Enter.theValue(faker.address().city()).into(SendingCardPage.TEXT_CITY));
    }

    public static Performable writeTextWithSize(int size) {
        Faker faker = new Faker();
        return Task.where(
            "{0} ingresa una direccion tamaño #size",
            Enter.theValue(faker.lorem().characters(size - 1)).into(SendingCardPage.TEXT_ADDRESS));
    }

    public static Performable writeAddressWithAtSymbol() {
        Faker faker = new Faker();
        return Task.where(
            "{0} ingresa una direccion con @ en cualquier posicion",
            Enter.theValue(faker.address().streetName() + "@" + faker.address().fullAddress())
                .into(SendingCardPage.TEXT_ADDRESS));
    }

    public static Performable writeAnyNumberOnAddress() {
        Faker faker = new Faker();
        return Task.where(
            "{0} ingresa un numero en la primera posicion de direccion de envio",
            Enter.theValue(faker.number().randomDigit() + faker.address().secondaryAddress())
                .into(SendingCardPage.TEXT_ADDRESS));
    }

    public static Performable declarationSelect() {
        return Task.where(
            "{0} acepta declarante y continua",
            Click.on(DeclaringPage.RADIO_SI),
            Click.on(DeclaringPage.CONTINUE_BUTTON),
            Waits.loader(Constantes.MAX_WAIT_GET_PDF));
    }

    public static Performable seeDocumentExpeditionListCities() {
        return Task.where(
            "{0} hace clic sobre la lista de ciudades de expedicion de la cedula",
            Waits.loader(), Click.on(PersonalDataPage.EXPEDITION_CITY_LIST));
    }

    public static Performable seeBithCitiesList() {
        return Task.where(
            "{0} hace clic sobre la lista de ciudades de nacimiento",
            Check.whether(WebElementQuestion.the(CommonWebElementsPage.LOADER), isVisible())
                .andIfSo(Waits.loader()),
            Click.on(PersonalDataPage.BIRTH_CITY_LIST));
    }
}
