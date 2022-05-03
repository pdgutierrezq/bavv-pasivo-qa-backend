# language: es
@sprint:120
@issue:PBA-5195
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Upload.Bank.Documents
@screen:Cargue.Documentos
@layer:backend
@service:upload-bank-documents
@repository:bavv-pasivo-backend-documents-lambdas
Característica: Validacion cargue de documentos
  YO COMO sistema
  NECESITO determinar si se realizo el cargue de documentos del cliente
  PARA saber si el cargue de documentos es exitoso

  Escenario: Peter hace el cargue de documentos
    Cuando el realiza el cargue de documentos
    Entonces el recibe una respuesta exitosa