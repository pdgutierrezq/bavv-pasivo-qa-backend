# language: es
@sprint:3
@issue:PBA-14
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Cliente.Condiciones
@screen:identificacion_de_usuario
@layer:backend
@service:customer-conditions
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Consultar el estado de un usuario
  YO COMO sistema
  NECESITO obtener informacion de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  Escenario: Usuario consulta su estado en el banco
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el consulta su estado en el banco
    Entonces el recibe una respuesta exitosa

