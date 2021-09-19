# language: es
@sprint:3
@issue:PBA-14
@app:COMMONS
@functionality:Cliente.Condiciones
@screen:Formulario_de_identificacion_de_usuario
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Condiciones cliente
  YO COMO sistema
  NECESITO obtener informacion de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  Escenario: Consumir servicio de condiciones cliente
    Dado que se obtiene un usuario para condiciones cliente de tipo "aleatorio"
    Cuando consumo el servicio rest de condiciones cliente
    Entonces el obtengo la informacion de las condiciones del cliente



