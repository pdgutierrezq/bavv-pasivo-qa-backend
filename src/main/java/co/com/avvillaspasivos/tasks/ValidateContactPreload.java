/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks;

import co.com.avvillaspasivos.model.CrmResponseData;
import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.ui.ContactInformationPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.avvillaspasivos.util.Constantes.CRM_ACTOR;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ValidateContactPreload implements Task {

  public static Performable perform() {
    return instrumented(ValidateContactPreload.class);
  }

  @Step("{0} valida la precarga de datos para el cliente desactualizado")
  public <T extends Actor> void performAs(T actor) {
    CrmResponseData crmResponseData =
        OnStage.theActorCalled(CRM_ACTOR).recall(SessionVariables.CRM_DATA.name());

    actor.attemptsTo(
        Check.whether(the(CommonWebElementsPage.LOADER), isVisible()).andIfSo(Waits.loader()),
        Ensure.that(ContactInformationPage.TEXTBOX_MAIL)
            .value()
            .isEqualToIgnoringCase(crmResponseData.getMail()),
        Ensure.that(ContactInformationPage.TEXTBOX_MAIL_COPY)
            .value()
            .isEqualToIgnoringCase(crmResponseData.getMail()),
        Ensure.that(ContactInformationPage.TEXTBOX_CITY)
            .value()
            .isEqualTo(crmResponseData.getCityAddress()),
        Ensure.that(ContactInformationPage.TEXTBOX_PHONE)
            .value()
            .isEqualTo(crmResponseData.getPhone()),
        Ensure.that(ContactInformationPage.TEXTBOX_ADDRESS)
            .value()
            .isEqualTo(crmResponseData.getAddress()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_NAME)
            .value()
            .isEqualTo(crmResponseData.getCompanyName()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_CITY)
            .value()
            .isEqualTo(crmResponseData.getCompanyCity()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_PHONE)
            .value()
            .isEqualTo(crmResponseData.getCompanyPhone()),
        Ensure.that(ContactInformationPage.TEXTBOX_COMPANY_ADDRESS)
            .value()
            .isEqualTo(crmResponseData.getCompanyAddress()));
  }
}
