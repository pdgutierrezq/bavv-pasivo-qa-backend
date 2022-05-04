/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks;

import co.com.bavv.old.model.CrmResponseData;
import co.com.bavv.old.ui.SendingCardPage;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class ValidateSendingCard implements Task {

  public static Performable perform() {
    return instrumented(ValidateSendingCard.class);
  }

  @Step("{0} valida la precarga en pantalla de envio de tarjeta")
  public <T extends Actor> void performAs(T actor) {
    String userType = theActorCalled(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name());
    CrmResponseData data = CrmResponseData.builder().build();

    if (userType.equals(Constantes.CLIENT_UPDATED)) {
      OnStage.theActorCalled(Constantes.AUTHENTICATION_ACTOR).attemptsTo(GetToken.userIdentity());
      OnStage.theActorCalled(Constantes.CRM_ACTOR).attemptsTo(CrmInfo.post());

      data = theActorCalled(Constantes.CRM_ACTOR).recall(SessionVariables.CRM_DATA.name());

    } else if (userType.equals(Constantes.CLIENT_NO_UPDATED)) {

      data =
          theActor(theActor(Constantes.SUPER_ACTOR).recall(SessionVariables.MAIN_ACTOR.name()))
              .recall(SessionVariables.CONTACT_INFORMATION_DATA.name());
    }

      actor.attemptsTo(
        Ensure.that(SendingCardPage.TEXT_CITY).value().isEqualToIgnoringCase(data.getCityAddress()),
        Ensure.that(SendingCardPage.TEXT_NEIGHBORHOOD).value().isEqualToIgnoringCase(data.getNeighborhood()),
        Ensure.that(SendingCardPage.TEXT_ADDRESS).value().isEqualToIgnoringCase(data.getAddress()));
  }
}
