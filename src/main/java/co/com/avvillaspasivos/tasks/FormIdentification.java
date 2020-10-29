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
import co.com.avvillaspasivos.ui.IdentificationPage;
import co.com.avvillaspasivos.util.SessionVariables;
import net.serenitybdd.screenplay.AnonymousTask;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Keys;

import static co.com.avvillaspasivos.util.Constantes.*;

public class FormIdentification {
  private static ActorData actorData;

  private FormIdentification() {
    throw new IllegalStateException("Utility class");
  }

  private static void getRecallDataActor() {
    actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
  }

  private static Performable fill(String salary) {
    getRecallDataActor();
    return Task.where(
        "{0} esta diligenciando formulario",
        Enter.theValue(actorData.getDocumentNumber()).into(IdentificationPage.DNI_INPUT),
        Enter.theValue(actorData.getPhone())
            .into(IdentificationPage.CELULAR_INPUT)
            .thenHit(Keys.TAB),
        Enter.theValue(actorData.getPhone()).into(IdentificationPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue(actorData.getFirstName()).into(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(actorData.getLastName()).into(IdentificationPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue(salary).into(IdentificationPage.SALARY_INPUT),
        Click.on(IdentificationPage.HABEAS_DATA_CHECKBOX));
  }

  public static Performable fillForm(String salaryType, boolean continueClick) {
    String salary;

    switch (salaryType) {
      case TAG_VALID:
        salary = VALID_SALARY;
        break;
      case TAG_INVALID:
        salary = INVALID_SALARY;
        break;
      case TAG_PRO:
        salary = PRO_SALARY;
        break;
      case TAG_SIMPLE:
        salary = SIMPLE_SALARY;
        break;
      case TAG_EXCEED_MAX:
        salary = EXCEED_SIZE_SALARY_TEXT;
        break;
      default:
        salary = "";
    }

    AnonymousTask returnTask;

    if (continueClick) {
      returnTask =
          Task.where(
              "{0} inicia a diligenciar formulario",
              fill(salary), Click.on(IdentificationPage.CONTINUE_BUTTON));
    } else {
      returnTask = Task.where("{0} inicia a diligenciar formulario y continua", fill(salary));
    }

    return returnTask;
  }

  public static Performable fillWithSalaryAndContinue(String salary) {
    ActorData actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
    return Task.where(
        "{0} diligencia formulario con salario definido y continua ",
        Enter.theValue(actorData.getDocumentNumber()).into(IdentificationPage.DNI_INPUT),
        Enter.theValue(actorData.getPhone())
            .into(IdentificationPage.CELULAR_INPUT)
            .thenHit(Keys.TAB),
        Enter.theValue(actorData.getPhone()).into(IdentificationPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue(actorData.getFirstName()).into(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(actorData.getLastName()).into(IdentificationPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue(salary).into(IdentificationPage.SALARY_INPUT),
        Click.on(IdentificationPage.HABEAS_DATA_CHECKBOX),
        Click.on(IdentificationPage.CONTINUE_BUTTON));
  }

  public static Performable fillAndContinue() {
    ActorData actorData =
        OnStage.theActorInTheSpotlight().recall(String.valueOf(SessionVariables.DATA_ACTOR));
    return Task.where(
        "{0} diligencia formulario y continua ",
        Enter.theValue(actorData.getDocumentNumber()).into(IdentificationPage.DNI_INPUT),
        Enter.theValue(actorData.getPhone())
            .into(IdentificationPage.CELULAR_INPUT)
            .thenHit(Keys.TAB),
        Enter.theValue(actorData.getPhone()).into(IdentificationPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue(actorData.getFirstName()).into(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(actorData.getLastName()).into(IdentificationPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue(actorData.getSalary()).into(IdentificationPage.SALARY_INPUT),
        Click.on(IdentificationPage.HABEAS_DATA_CHECKBOX),
        Click.on(IdentificationPage.CONTINUE_BUTTON));
  }

  public static Performable fill() {
    getRecallDataActor();
    return Task.where(
        "{0} diligencia formulario",
        Enter.theValue(actorData.getDocumentNumber()).into(IdentificationPage.DNI_INPUT),
        Enter.theValue(actorData.getPhone())
            .into(IdentificationPage.CELULAR_INPUT)
            .thenHit(Keys.TAB),
        Enter.theValue(actorData.getPhone()).into(IdentificationPage.CELULAR_CONFIRMACION_INPUT),
        Enter.theValue(actorData.getFirstName()).into(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(actorData.getLastName()).into(IdentificationPage.PRIMER_APELLIDO_INPUT),
        Enter.theValue(actorData.getSalary()).into(IdentificationPage.SALARY_INPUT),
        Click.on(IdentificationPage.HABEAS_DATA_CHECKBOX));
  }

  public static Performable digitarCelularErrado() {
    return Task.where(
        "{0} diligencia formulario",
        Enter.theValue("31601234567").into(IdentificationPage.CELULAR_INPUT).thenHit(Keys.TAB));
  }

  public static Performable noDiligenciar() {
    return Task.where(
        "{0}  no diligencia formulario",
        Click.on(IdentificationPage.DNI_INPUT),
        Click.on(IdentificationPage.CELULAR_INPUT),
        Click.on(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Click.on(IdentificationPage.PRIMER_APELLIDO_INPUT),
        Click.on(IdentificationPage.DNI_INPUT),
        Click.on(IdentificationPage.SALARY_INPUT),
        Click.on(IdentificationPage.HABEAS_DATA_CHECKBOX));
  }

  public static Performable validatePageLoad() {
    return Task.where(
        "{0} valida carga de pagina identificacion",
        Ensure.that(IdentificationPage.CONTINUE_BUTTON).isDisabled(),
        Ensure.that(IdentificationPage.CELULAR_CONFIRMACION_INPUT).isDisabled());
  }

  public static Performable ingresarTextoFueraDelLimite() {
    return Task.where(
        "{0} diligencia campos de texto con mas de 20 caracteres",
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO).into(IdentificationPage.PRIMER_NOMBRE_INPUT),
        Enter.theValue(TEXTO_SUPERIOR_LIMITE_TAMANIO)
            .into(IdentificationPage.PRIMER_APELLIDO_INPUT));
  }
}
