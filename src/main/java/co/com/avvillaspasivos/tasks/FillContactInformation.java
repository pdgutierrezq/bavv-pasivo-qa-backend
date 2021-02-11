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
import co.com.avvillaspasivos.ui.ContactInformationPage;
import co.com.avvillaspasivos.util.Util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillContactInformation implements Task {

  public static Performable perfom() {
    return instrumented(FillContactInformation.class);
  }

  @Step("{0} Diligencia el formulario de contacto")
  public <T extends Actor> void performAs(T actor) {
    CrmResponseData data = Util.buildContactData();

    actor.attemptsTo(
        Check.whether(ContactInformationPage.TEXTBOX_MAIL.resolveFor(actor).getValue().isEmpty())
            .andIfSo(
                Enter.theValue(data.getMail()).into(ContactInformationPage.TEXTBOX_MAIL),
                Enter.theValue(data.getMail()).into(ContactInformationPage.TEXTBOX_MAIL_COPY)),
        Check.whether(ContactInformationPage.TEXTBOX_CITY.resolveFor(actor).getValue().isEmpty())
            .andIfSo(
                Enter.theValue(data.getCityAddress())
                    .into(ContactInformationPage.TEXTBOX_CITY)
                    .thenHit(Keys.TAB)),
        Check.whether(ContactInformationPage.TEXTBOX_ADDRESS.resolveFor(actor).getValue().isEmpty())
            .andIfSo(
                Enter.theValue(data.getAddress()).into(ContactInformationPage.TEXTBOX_ADDRESS)),
        Check.whether(
                ContactInformationPage.TEXTBOX_COMPANY_NAME.resolveFor(actor).getValue().isEmpty())
            .andIfSo(
                Enter.theValue(data.getCompanyName())
                    .into(ContactInformationPage.TEXTBOX_COMPANY_NAME)),
        Check.whether(
                ContactInformationPage.TEXTBOX_COMPANY_CITY.resolveFor(actor).getValue().isEmpty())
            .andIfSo(
                Enter.theValue(data.getCityAddress())
                    .into(ContactInformationPage.TEXTBOX_COMPANY_CITY)
                    .thenHit(Keys.TAB)),
        Check.whether(
                ContactInformationPage.TEXTBOX_COMPANY_ADDRESS
                    .resolveFor(actor)
                    .getValue()
                    .isEmpty())
            .andIfSo(
                Enter.theValue(data.getAddress())
                    .into(ContactInformationPage.TEXTBOX_COMPANY_ADDRESS)),
        Click.on(ContactInformationPage.BUTTON_CONTINUE));
  }
}
