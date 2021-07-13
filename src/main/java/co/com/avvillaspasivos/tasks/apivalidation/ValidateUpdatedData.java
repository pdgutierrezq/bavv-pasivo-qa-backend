/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.apivalidation;

import co.com.avvillaspasivos.model.UpdateCrmBody;
import co.com.avvillaspasivos.tasks.CrmInfo;
import co.com.avvillaspasivos.util.DateManagement;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static co.com.avvillaspasivos.util.Constantes.ACTUALIZAR_CRM;
import static co.com.avvillaspasivos.util.UtilWs.getTagValueFromLastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ValidateUpdatedData implements Task {

  public static Performable perform() {
    return instrumented(ValidateUpdatedData.class);
  }

  @Override
  @Step("{0} valida la información actualizada por update crm ")
  public <T extends Actor> void performAs(T actor) {
    UpdateCrmBody updateCrmBody =
        theActorCalled(ACTUALIZAR_CRM).recall(SessionVariables.UPDATE_CRM_BODY.name());

    theActorCalled("CONSULTAR_CRM_UPDATED").attemptsTo(CrmInfo.post());

    actor.attemptsTo(
        validateContactInformation(updateCrmBody),
        validatePersonalInformation(updateCrmBody),
        validateFinancialInformation(updateCrmBody),
        foreignProductInformation(updateCrmBody),
        companyInformation(updateCrmBody));
  }

  private static Performable companyInformation(UpdateCrmBody updateCrmBody) {
    return Task.where(
        "{0} valida la informacion de la empresa",
        Ensure.that(
            " el nombre la empresa se actualizo correctamente",
            response ->
                response.body(
                    "employmentHistoryList[0].companyName",
                    Matchers.equalToIgnoringCase(updateCrmBody.getCompanyName()))),
        Ensure.that(
            " la ciudad de la empresa se actualizo correctamente",
            response ->
                response.body(
                    "employmentHistoryList[0].companyCityCode",
                    Matchers.equalToIgnoringCase(updateCrmBody.getCompanyCity()))),
        Ensure.that(
            " la direccion de la empresa se actualizo correctamente",
            response ->
                response.body(
                    "contactInfoList[0].contactAddressList[0]",
                    Matchers.equalToIgnoringCase(updateCrmBody.getCompanyAddress()))),
        Ensure.that(
            " el telefono de la empresa se actualizo correctamente",
            response ->
                response.body(
                    "contactInfoList[0].contactPhoneList[0]",
                    Matchers.equalToIgnoringCase(updateCrmBody.getCompanyTel()))));
  }

  private static Performable foreignProductInformation(UpdateCrmBody updateCrmBody) {
    return Task.where(
        "{0} valida la informacion de productos e el extranjero",
        Ensure.that(
            " el valor del indicador de transacciones en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "internacionalTransactionId",
                    Matchers.equalToIgnoringCase(updateCrmBody.getInternationalTrnInd()))),
        Ensure.that(
            " el valor del indicador de producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "acctCurrencyForeignInd",
                    Matchers.equalToIgnoringCase(updateCrmBody.getForeignTrnCurrency()))),
        Ensure.that(
            " el valor del tipo de producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "typeCurrencyAcct",
                    Matchers.equalToIgnoringCase(updateCrmBody.getForeignAcctType()))),
        Ensure.that(
            " el valor de tipo de producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "referenceIdCurrencyAcct",
                    Matchers.equalToIgnoringCase(updateCrmBody.getForeignRefId()))),
        Ensure.that(
            " el valor del indicador de producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "balanceAcct",
                    Matchers.equalTo(Float.parseFloat(updateCrmBody.getBalanceAcct() + ".0")))),
        Ensure.that(
            " el valor de la ciudad del producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "cityBankCurrencyAcct",
                    Matchers.equalToIgnoringCase(updateCrmBody.getForeignBankCity()))),
        Ensure.that(
            " el valor del nombre del banco del producto en el extranjero se actualizo correctamente",
            response ->
                response.body(
                    "nameBankCurrencyAcct",
                    Matchers.equalToIgnoringCase(updateCrmBody.getForeignBankName()))));
  }

  private static Performable validateFinancialInformation(UpdateCrmBody updateCrmBody) {
    return Task.where(
        "{0} valida la informacion financiera",
        Ensure.that(
            " el valor de ingresos se actuallizo correctamente",
            response ->
                response.body(
                    "employmentHistoryList[0].incomeAmount",
                    Matchers.equalTo(Float.parseFloat(updateCrmBody.getIncome() + ".0")))),
        Ensure.that(
            " el valor de activos se actualizo correctamente",
            response ->
                response.body(
                    "assetsnumber",
                    Matchers.equalTo(Float.parseFloat(updateCrmBody.getAssets() + ".0")))),
        Ensure.that(
            " el valor de pasivos se actualizo correctamente",
            response ->
                response.body(
                    "liabilitiesNumber",
                    Matchers.equalTo(Float.parseFloat(updateCrmBody.getLiabilities() + ".0")))),
        Ensure.that(
            " el valor de gastos mensuales se actualizo correctamente",
            response ->
                response.body(
                    "montlyExpenses",
                    Matchers.equalTo(Float.parseFloat(updateCrmBody.getMonthExpenses() + ".0")))));
  }

  private static Performable validateContactInformation(UpdateCrmBody updateCrmBody) {
    return Task.where(
        "{0} valida la informacion de contacto",
        Ensure.that(
            " la direccion se actuallizo correctamente",
            response ->
                response.body(
                    "addresessList[0]", Matchers.equalToIgnoringCase(updateCrmBody.getAddress()))),
        Ensure.that(
            " la ciudad se actualizo correctamente",
            response ->
                response.body(
                    "contactCity", Matchers.equalToIgnoringCase(updateCrmBody.getCity()))),
        Ensure.that(
            " el barrio se actualizo correctamente",
            response ->
                response.body(
                    "neighborhood", Matchers.equalToIgnoringCase(updateCrmBody.getNeighborhood()))),
        Ensure.that(
            " el celular se actualizo correctamente",
            response ->
                response.body(
                    "contactPhonesList[1].phoneNumber",
                    Matchers.equalToIgnoringCase(updateCrmBody.getPhoneNumber()))),
        Ensure.that(
            " el telefono se actualizo correctamente",
            response ->
                response.body(
                    "contactPhonesList[0].phoneNumber",
                    Matchers.equalToIgnoringCase(updateCrmBody.getTelNumber()))),
        Ensure.that(
            " el email se actualizo correctamente",
            response ->
                response.body(
                    "emailAdressContact",
                    Matchers.equalToIgnoringCase(updateCrmBody.getEmailAddr()))));
  }

  private static Performable validatePersonalInformation(UpdateCrmBody updateCrmBody) {

    return Task.where(
        "{0} valida la informacion personal",
        Ensure.that(
            " el primer nombre se actualizo correctamente",
            response ->
                response.body(
                    "firstName", Matchers.equalToIgnoringCase(updateCrmBody.getFirstName()))),
        Ensure.that(
            " el segundo nombre se actualizo correctamente",
            response ->
                response.body(
                    "secondName", Matchers.equalToIgnoringCase(updateCrmBody.getSecondName()))),
        Ensure.that(
            " el apellido se actualizo correctamente",
            response ->
                response.body(
                    "lastName", Matchers.equalToIgnoringCase(updateCrmBody.getLastName()))),
        Ensure.that(
            " el segundo apellido se actualizo correctamente",
            response ->
                response.body(
                    "secondLastName",
                    Matchers.equalToIgnoringCase(updateCrmBody.getSecondLastName()))),
        net.serenitybdd.screenplay.ensure.Ensure.that(
                validateDates(updateCrmBody.getDocumentExpDate(), "expDocumentDate"))
            .isTrue(),
        Ensure.that(
            " la ciudad de expedicion de la cedula se actualizo correctamente",
            response ->
                response.body("cityExp", Matchers.equalTo(updateCrmBody.getDocumentExpCity()))),
        Ensure.that(
            " la ciudad de nacimiento se actualizo correctamente",
            response ->
                response.body(
                    "cityBirth", Matchers.equalTo(Integer.parseInt(updateCrmBody.getBirthCity())))),
        Ensure.that(
            "el genero se actualizo correctamente",
            response -> response.body("gender", Matchers.equalTo(updateCrmBody.getGender()))),
        net.serenitybdd.screenplay.ensure.Ensure.that(
                validateDates(updateCrmBody.getBirthDate(), "birthDate"))
            .isTrue());
  }

  private static boolean validateDates(Long dateExpected, String tagName) {
    String obtainedDate = getTagValueFromLastResponse(tagName);
    return DateManagement.validateDate(dateExpected, obtainedDate);
  }
}
