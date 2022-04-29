# language: es
@sprint:120
@issue:PBA-5168
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Electronic.Signature
@screen:Firma.Documentos
@layer:backend
@service:electronic-signature
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Validacion de firma de documentos
  YO COMO sistema
  NECESITO determinar si se realizo la firma electronica de documentos
  PARA saber si la transaccion es exitosa

  @run
  Escenario: Peter hace la firma electronica
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el realiza la firma electronica de documentos
    Entonces el recibe una respuesta exitosa
