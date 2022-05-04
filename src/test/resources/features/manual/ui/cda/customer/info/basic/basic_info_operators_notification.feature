# language: es
@sprint:96
@issue:PBA-3511
@app:CDA
@functionality:Cliente.Info.Basica.Notificaciones
@screen:identificacion_de_usuario
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Notificacion operadores mobiles en pantalla de datos basicos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519036
  Escenario: Notificacion operadores en la pantalla de datos basicos
    Cuando cargue la pantalla de datos basicos
    Entonces  aparecerá en el campo de numero de celular un alert con el siguiente texto "PARA poder validar tu identidad, tu operador debe ser Claro, Tigo, Movistar o Avantel.”
