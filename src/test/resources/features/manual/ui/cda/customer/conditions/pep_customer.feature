# language: es
@sprint:93
@app:CDA
@functionality:Cliente.Condiciones.PEP
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cliente PEP
  YO como Usuario abriendo una cuenta de ahorros
  QUIERO que se valide si soy un cliente PEP
  PARA que me deje seguir con el flujo

  @issue:PBA-3614
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-93
  @testrail-id:515661
  Escenario: Cliente PEP
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions
    Cuando el servicio responda con código 8888 (En Var 1)
    Entonces se redirecciona al usuario a la pantalla de error de usuario.

  @issue:PBA-3614
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-93
  @testrail-id:515662
  Escenario: Cliente NO PEP
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions
    Cuando el servicio responda con código diferente a 8888
    Entonces el cliente continua con el flujo normal

  @issue:PBA-3959
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-99
  @testrail-id:520782
  Escenario: Codigo de error desconocido
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions
    Cuando  el servicio responda con código diferente a 0, 003 y 8888
    Entonces  se redirecciona al cliente a la pantalla de error técnico
