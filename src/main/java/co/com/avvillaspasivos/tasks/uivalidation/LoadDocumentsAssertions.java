/**
 * Grupo Aval Acciones y Valores S.A. CONFIDENTIAL
 *
 * <p>Copyright (c) 2018 . All Rights Reserved.
 *
 * <p>NOTICE: This file is subject to the terms and conditions defined in file 'LICENSE', which is
 * part of this source code package.
 */
package co.com.avvillaspasivos.tasks.uivalidation;

import co.com.avvillaspasivos.ui.DocumentsLoadPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class LoadDocumentsAssertions {

  private LoadDocumentsAssertions() {
    throw new IllegalStateException("Utility class");
  }

  public static Performable validateDocumentSection() {
    return Task.where(
        "{0} Valida que el cargue de cedula esté presente",
        Ensure.that(DocumentsLoadPage.CC_SECTION).isDisplayed());
  }

  public static Performable validateEmploymentDocs(List<String> docs) {
    return Task.where(
        "{0} Valida que se presente la  opcion para cargar documentos de empleado",
        Ensure.that(DocumentsLoadPage.DOCUMENTS_TO_CHARGE)
            .textValues()
            .containsExactlyElementsFrom(docs));
  }

  public static Performable validateIndependentDocs(List<String> docs) {
    return Task.where(
        "{0} Valida que se presente la  opcion para cargar documentos de independiente",
        Ensure.that(DocumentsLoadPage.INDEPENDENT_DOCUMENTS_TO_CHARGE)
            .textValues()
            .containsExactlyElementsFrom(docs));
  }
}
