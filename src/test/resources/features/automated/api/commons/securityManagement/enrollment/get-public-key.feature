# language: es
@sprint:120
@issue:PBA-5171
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Electronic.Signature
@screen:Firma.Documentos
@layer:backend
@service:get-public-key
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Obtener llave publica
  YO COMO sistema
  NECESITO realizar una consulta de la llave publica
  PARA saber si es posible obtener la llave publica

  Escenario: Peter hace la consulta a la llave publica
    Cuando el consulta el servicio de llave publica
    Entonces el recibe una respuesta exitosa
