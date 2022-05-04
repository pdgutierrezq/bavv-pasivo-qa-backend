# language: es
@sprint:120
@issue:PBA-5194
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Send.Sqs.Message
@screen:Cargue.Documentos
@layer:backend
@service:sqs-cda-documents
@repository:bavv-pasivo-backend-file-upload-lambdas
Característica: Validacion envio de mensaje sqs
  YO COMO sistema
  NECESITO determinar si el envio de documentos es correcto
  PARA saber si el envio del mensaje sqs es exitoso

  Escenario: Usuario genera el envio de documentos ok
    Cuando el realiza el envio de documentos
    Entonces el recibe una respuesta exitosa
