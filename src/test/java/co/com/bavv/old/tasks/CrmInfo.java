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
import co.com.bavv.old.model.CrmBody;
import co.com.bavv.old.model.CrmResponseData;
import co.com.bavv.old.data.DataProvider;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

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
        OnStage.theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

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

    String city = DataProvider.getCompanyCity(getFlagCrm("contactCity"), Constantes.DOMINA);
    String companyName = getFlagCrm("employmentHistoryList[0].companyName");

    String daneCode = getFlagCrm("employmentHistoryList[0].companyCityCode");
    String companyCity = DataProvider.getCompanyCity(daneCode, Constantes.FULL_CITIES);

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
