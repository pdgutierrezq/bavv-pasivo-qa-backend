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
import co.com.avvillaspasivos.model.CrmBody;
import co.com.avvillaspasivos.model.CrmResponseData;
import co.com.avvillaspasivos.paths.ServicePaths;
import co.com.avvillaspasivos.util.Constantes;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.data.DataProvider.getCompanyCity;
import static co.com.avvillaspasivos.util.Constantes.DOMINA;
import static co.com.avvillaspasivos.util.Constantes.FULL_CITIES;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CrmInfo implements Task {

  public static Performable post() {
    return instrumented(CrmInfo.class);
  }

  @Override
  @Step("{0} obtiene la información del cliente")
  public <T extends Actor> void performAs(T actor) {
    String uiActor =
        OnStage.theActor(Constantes.MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    ActorData actorData = OnStage.theActor(uiActor).recall(SessionVariables.DATA_ACTOR.name());

    actor.whoCan(CallAnApi.at(ServicePaths.getAuxEndPointBase()));

    CrmBody crmBody =
        CrmBody.builder().documentType("CC").documentNumber(actorData.getDocumentNumber()).build();

    actor.attemptsTo(CallPost.pathBody(ServicePaths.pathCrmInfo(), crmBody));

    actor.remember(SessionVariables.CRM_DATA.name(), getCrmResponseData());
  }

  private <Any> Any getFlagCrm(String flag) {
    return lastResponse().getBody().jsonPath().get(flag);
  }

  private CrmResponseData getCrmResponseData() {
    String mail = getFlagCrm("emailAdressContact");
    String address = getFlagCrm("addresessList[0]");
    String neighborhood = getFlagCrm("neighborhood");
    String phone = getFlagCrm("contactPhonesList[0].phoneNumber");

    String city = getCompanyCity(getFlagCrm("contactCity"), DOMINA);
    String companyName = getFlagCrm("employmentHistoryList[0].companyName");

    String daneCode = getFlagCrm("employmentHistoryList[0].companyCityCode");
    String companyCity = getCompanyCity(daneCode, FULL_CITIES);

    String companyAddress = getFlagCrm("contactInfoList[0].contactAddressList[0]");
    String companyPhone = getFlagCrm("contactInfoList[0].contactPhoneList[0]");
    Float incomeAmount = getFlagCrm("employmentHistoryList[0].incomeAmount");
    Float liabilitiesNumber = getFlagCrm("liabilitiesNumber");
    Float montlyExpenses = getFlagCrm("montlyExpenses");
    Float assetsnumber = getFlagCrm("assetsnumber");

    return CrmResponseData.builder()
        .mail(mail)
        .phone(phone)
        .cityAddress(city)
        .address(address)
        .neighborhood(neighborhood)
        .companyName(companyName)
        .companyCity(companyCity)
        .companyAddress(companyAddress)
        .companyPhone(companyPhone)
        .incomeAmount(String.valueOf(incomeAmount.longValue()))
        .liabilitiesNumber(String.valueOf(liabilitiesNumber.longValue()))
        .montlyExpenses(String.valueOf(montlyExpenses.longValue()))
        .assetsnumber(String.valueOf(assetsnumber.longValue()))
        .build();
  }
}
