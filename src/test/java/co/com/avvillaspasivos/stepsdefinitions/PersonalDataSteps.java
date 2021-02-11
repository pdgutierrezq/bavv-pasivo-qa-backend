/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.stepsdefinitions;

import co.com.avvillaspasivos.tasks.TasksGroup;
import co.com.avvillaspasivos.tasks.UiAssertions;
import co.com.avvillaspasivos.tasks.Waits;
import co.com.avvillaspasivos.ui.CommonWebElementsPage;
import co.com.avvillaspasivos.ui.PersonalDataPage;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.conditions.Check;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class PersonalDataSteps {
  @Dado("que estoy en pantalla donde ingreso mis datos personales.")
  public void queEstoyEnPantallaDondeIngresoMisDatosPersonales() {
    OnStage.theActorInTheSpotlight().attemptsTo(TasksGroup.navigateLaterAuthetication());
  }

  @Cuando("de click en el campo de Ciudad de nacimiento.")
  public void deClickEnElCampoDeCiudadDeNacimiento() {
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            Check.whether(the(CommonWebElementsPage.LOADER), isVisible()).andIfSo(Waits.loader()),
            Click.on(PersonalDataPage.BIRTH_CITY_LIST));
  }

  @Entonces(
      "se desplegará el listado de las ciudades o municipios de Colombia que coincida con el listado")
  public void seDesplegaráElListadoDeLasCiudadesOMunicipiosDeColombiaQueCoincidaConElListado() {
    OnStage.theActorInTheSpotlight().attemptsTo(UiAssertions.validateCityListItem());
  }

  @Cuando("de click en el campo de Ciudad de la expedición de la cédula")
  public void deClickEnElCampoDeCiudadDeLaExpediciónDeLaCédula() {
    OnStage.theActorInTheSpotlight().attemptsTo(Click.on(PersonalDataPage.EXPEDITION_CITY_LIST));
  }
}
