# language: es
@sprint:91
@app:CDT
@functionality:Cliente.Info.Basica.Pantalla
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Pantalla de datos basicos del cliente
  YO como banco
  QUIERO conocer la informacion basica del cliente
  PARA saber si puedo crear el CDT

  @issue:PBA-3301
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: Alerta de operadores
    Dado que llegué a la pantalla de datos basicos del cliente
    Cuando cargue la pantalla
    Entonces aparecerá abajo del campo de numero de celular, un alert con el siguiente texto “Para poder validar tu identidad, tu operador debe ser Claro, Tigo, Movistar o Avantel.”
