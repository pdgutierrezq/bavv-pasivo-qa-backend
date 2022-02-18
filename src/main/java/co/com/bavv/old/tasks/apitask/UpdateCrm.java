/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apitask;

import co.com.bavv.old.model.ActorData;
import co.com.bavv.old.model.UpdateCrmBody;
import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import co.com.bavv.old.util.Util;
import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateCrm implements Task {

  public static Performable post() {
    return instrumented(UpdateCrm.class);
  }

  @Override
  @Step("{0} actualiza crm")
  public <T extends Actor> void performAs(T actor) {
    String mainActorName =
        OnStage.theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());

    ActorData actorData =
        OnStage.theActor(mainActorName).recall(SessionVariables.DATA_ACTOR.name());

    actor.whoCan(CallAnApi.at(ServicePaths.getEndPointBase(Constantes.DEV_ENV)));

    UpdateCrmBody updateCrmBody = getUpdateCrmBody(actorData);

    actor.attemptsTo(CallPostWith.token(ServicePaths.pathUpdateCrm(), updateCrmBody));

    actor.remember(SessionVariables.UPDATE_CRM_BODY.name(), updateCrmBody);
  }

  private UpdateCrmBody getUpdateCrmBody(ActorData actorData) {
    Faker faker = new Faker();

    return UpdateCrmBody.builder()
        .documentType(actorData.getDocumentType())
        .documentNumber(actorData.getDocumentNumber())
        .transactionId(Constantes.TRANSACTION_ID_VALUE)
        .totalSave("T")
        .declarant(false)
        .address("CL 95 NO 64 39test")
        .city(Constantes.UPDATE_CRM_CITY)
        .neighborhood(faker.pokemon().name())
        .phoneNumber("313".concat(faker.number().digits(7)))
        .telNumber("6".concat(faker.number().digits(6)))
        .firstName(faker.name().firstName())
        .secondName(faker.name().firstName())
        .lastName(Util.deleteSpecialChar(faker.name().lastName()))
        .secondLastName(Util.deleteSpecialChar(faker.name().lastName()))
        .documentExpDate(1150866000000L)
        .documentExpCity(Constantes.UPDATE_CRM_CITY)
        .birthCity(Constantes.UPDATE_CRM_CITY)
        .gender("M")
        .codeCIIU(113)
        .emailAddr(faker.internet().emailAddress())
        .assets(faker.number().digits(7))
        .liabilities(faker.number().digits(7))
        .monthExpenses(faker.number().digits(7))
        .internationalTrnInd("S")
        .foreignTrnType("1")
        .foreignTrnCurrency("S")
        .foreignAcctType("3")
        .foreignRefId(1+faker.number().digits(14))
        .balanceAcct(faker.number().digits(7))
        .foreignBankCity(faker.address().cityName())
        .foreignBankCountry("062")
        .foreignBankName(faker.company().name().replaceAll("[^a-zA-Z]", "").concat("-"))
        .foreignCurrencyType("EU")
        .income(faker.number().numberBetween(3000000, 10000000))
        .activityEconomical(15)
        .birthDate(584773200000L)
        .companyName(faker.company().name().replaceAll("[^a-zA-Z]", ""))
        .companyCity(Constantes.UPDATE_CRM_CITY)
        .companyAddress("Cra 11 N adltest changed test")
        .companyTel("6".concat(faker.number().digits(6)))
        .build();
  }
}
