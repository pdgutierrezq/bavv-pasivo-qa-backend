# language: es
@sprint:120
@issue:PBA-5193
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Get.Documents.To.Charge
@screen:Cargue.Documentos
@layer:backend
@service:get-documents-to-charge
@repository:bavv-pasivo-backend-documents-lambdas
Característica: Validacion peticion de documentos
  YO COMO sistema
  NECESITO determinar si puedo obtener los documentos
  PARA saber si los documentos se obtivieron de manera exitosa

  Escenario: Peter consulta el cargue de documentos
    Cuando el realiza la peticion de los documentos cargados
    Entonces el recibe una respuesta exitosa
