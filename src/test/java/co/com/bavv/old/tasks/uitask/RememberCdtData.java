/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.uitask;

import co.com.bavv.old.model.ResumeCdtData;
import co.com.bavv.old.ui.ConfigurationCdtPage;
import co.com.bavv.old.util.ActorActions;
import co.com.bavv.old.util.Constantes;
import co.com.bavv.old.util.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RememberCdtData implements Task {
  private final ResumeCdtData cdtData;

  public RememberCdtData(ResumeCdtData cdtData) {
    this.cdtData = cdtData;
  }

  public static Performable exec(ResumeCdtData cdtData) {
    return instrumented(RememberCdtData.class, cdtData);
  }

  @Step("{0} se almacena informacion del cdt")
  public <T extends Actor> void performAs(T actor) {

    cdtData.setRate(ActorActions.getTextFromTarget(actor, ConfigurationCdtPage.TEXT_TASA));

    if (ConfigurationCdtPage.PERIOD_LIST.resolveFor(actor).isPresent()) {
      cdtData.setPeriod(
          ActorActions.getTextFromPeriodItemList(actor, ConfigurationCdtPage.PERIOD_LIST));
    }else {
        cdtData.setPeriod(Constantes.EXPIRATION_TAG);
    }

    actor.remember(SessionVariables.CDT_DATA.name(), cdtData);
  }
}
