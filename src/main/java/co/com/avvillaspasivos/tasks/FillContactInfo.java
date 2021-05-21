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
import co.com.avvillaspasivos.util.SessionVariables;
import co.com.avvillaspasivos.util.Util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static co.com.avvillaspasivos.util.Constantes.MAIN_ACTOR;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;

public class FillContactInfo implements Task {

  public static Performable fixed() {
    return instrumented(FillContactInfo.class);
  }

  @Step("{0} Diligencia el formulario de contacto completo")
  public <T extends Actor> void performAs(T actor) {
    CrmResponseData data = Util.buildContactData();

    OnStage.theActor(theActor(MAIN_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
        .remember(SessionVariables.CONTACT_INFORMATION_DATA.name(), data);

    actor.attemptsTo(
        Enter.theValue(data.getMail()).into(ContactInformationPage.TEXTBOX_MAIL),
        Enter.theValue(data.getMail()).into(ContactInformationPage.TEXTBOX_MAIL_COPY),
        Enter.theValue(data.getCityAddress())
            .into(ContactInformationPage.TEXTBOX_CITY)
            .thenHit(Keys.TAB),
        Enter.theValue(data.getAddress()).into(ContactInformationPage.TEXTBOX_ADDRESS),
        Enter.theValue(data.getNeighborhood()).into(ContactInformationPage.TEXTBOX_NEIGHBORHOOD));

    if (ContactInformationPage.TEXTBOX_COMPANY_NAME.resolveFor(actor).isPresent()) {
      fillOutCompanyDataFixed(data);
    }

    actor.attemptsTo(Click.on(ContactInformationPage.BUTTON_CONTINUE));
  }

  public static Performable fillOutCompanyDataFixed(CrmResponseData data) {
    return Task.where(
        "{0} diligencia la informacion de la compañia",
        Enter.theValue(data.getCompanyName()).into(ContactInformationPage.TEXTBOX_COMPANY_NAME),
        Enter.theValue(data.getCityAddress())
            .into(ContactInformationPage.TEXTBOX_COMPANY_CITY)
            .thenHit(Keys.TAB),
        Enter.theValue(data.getAddress()).into(ContactInformationPage.TEXTBOX_COMPANY_ADDRESS));
  }
}
