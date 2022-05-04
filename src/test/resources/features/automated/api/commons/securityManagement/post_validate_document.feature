# language: es
@sprint:120
@issue:PBA-5200
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Validate.Document
@screen:Cargue.Documentos
@layer:backend
@service:validate-document
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Validacion de documento
  YO COMO sistema
  NECESITO determinar si el documento contiene el numero de documento del cliente
  PARA saber si el documento pertenece al cliente

  Escenario: Peter valida el documento
    Cuando el realiza el envio del documento a validar
    Entonces el recibe una respuesta exitosa
