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
@repository:user-identification-lambdas
Característica: Condiciones cliente
  YO COMO sistema
  NECESITO obtener informacion de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  @testrail-id:515653
  Escenario: Consumir servicio de condiciones cliente
    Dado que se obtiene un usuario para condiciones cliente de tipo "aleatorio"
    Cuando consumo el servicio rest de condiciones cliente
    Entonces el obtengo la informacion de las condiciones del cliente



