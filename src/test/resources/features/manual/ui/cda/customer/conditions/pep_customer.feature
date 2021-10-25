# language: es
@sprint:93
@issue:PBA-3614
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

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-93
  @testrail-id:515661
  Escenario: Cliente PEP
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions
    Cuando el servicio responda con código 8888 (En Var 1)
    Entonces se redirecciona al usuario a la pantalla de error de usuario.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-93
  @testrail-id:515662
  Escenario: Cliente NO PEP
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions
    Cuando el servicio responda con código diferente a 8888
    Entonces el cliente continua con el flujo normal
