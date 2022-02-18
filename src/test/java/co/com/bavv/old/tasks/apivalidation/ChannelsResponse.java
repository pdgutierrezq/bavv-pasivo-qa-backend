/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.bavv.old.tasks.apivalidation;

import co.com.bavv.old.paths.ServicePaths;
import co.com.bavv.old.tasks.Schema;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChannelsResponse implements Task {
  private final String channelsOption;

  public ChannelsResponse(String channelsOption) {
    this.channelsOption = channelsOption;
  }

  public static Performable validate(String channelsOption) {
    return instrumented(ChannelsResponse.class, channelsOption);
  }

  @Override
  @Step("{0} valida la información de la consulta a canales")
  public <T extends Actor> void performAs(T actor) {
    boolean expectedChannels= channelsOption.equals("tiene");

    actor.attemptsTo(
        Schema.validation(ServicePaths.pathGetChannelsSchema(expectedChannels)),
        Ensure.that(
            "Se valida la confirmación del valor cdtFundingAcct",
            response -> response.body("hasChannels", Matchers.equalTo(expectedChannels))));
  }
}
