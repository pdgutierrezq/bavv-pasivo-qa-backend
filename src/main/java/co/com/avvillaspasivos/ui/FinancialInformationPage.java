/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FinancialInformationPage {

  private FinancialInformationPage() {
    throw new IllegalStateException("Utility class");
  }

  public static final Target TEXT_ASSETS =
      Target.the("Textbox activos").located(By.id("activeExpensesInput"));

  public static final Target TEXT_LIABILITIES =
      Target.the("Textbox pasivos").located(By.id("passiveExpensesInput"));

  public static final Target TEXT_MONTHLY_EXPENSES =
      Target.the("Textbox gastos mensuales").located(By.id("monthlyExpensesInput"));

  public static final Target TEXT_INCOME_AMOUNT =
      Target.the("Textbox gastos mensuales").located(By.id("monthlyIncomeInput"));

  public static final Target RADIO_ADITIONAL_DATA_QUESTION_NO =
      Target.the("Radio pregunta adicional de moneda extranjera")
          .located(By.xpath("//mat-radio-button[@value='false']"));

  public static final Target LIST_OPERATION_TYPE =
      Target.the("Lista de operaciones internacionales").located(By.id("OperationType"));

  public static final Target LIST_OPTION_NONE =
      Target.the("Opcion Ninguna").located(By.xpath("//mat-option[contains(.,'Ninguna')]"));

  public static final Target CONTINUE_BUTTON =
      Target.the("Boton continuar informacion financiera")
          .located(By.xpath("//button[contains(text(),' Continuar')]"));
}
