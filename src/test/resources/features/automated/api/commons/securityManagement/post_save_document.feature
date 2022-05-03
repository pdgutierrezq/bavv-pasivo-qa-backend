# language: es
@sprint:120
@issue:PBA-5199
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:save.document
@screen:Cargue.Documentos
@layer:backend
@service:save-document
@repository:bavv-pasivo-backend-documents-lambdas
Característica: Validacion guardar documento
  YO COMO sistema
  NECESITO determinar si se guarda el documento
  PARA saber si se guarda de manera exitosa

  Escenario: Peter guarda el documento
    Cuando el realiza el guardado del documento
    Entonces el recibe una respuesta exitosa
