# language: es
@sprint:101
@issue:PBA-3971
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Ajuste pep redirecciones cdt
  YO Como* Usuario abriendo un CDT
*Necesito* que se valide si soy un cliente PEP
  PARA  que me deje seguir con el flujo
 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-101
  Escenario: Cliente pep
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions 
    Cuando  el servicio responda con código 8888 (En Var 1) 
    Entonces  se redirecciona al usuario a la pantalla de error de usuario.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-101
  Escenario: Cliente no pep
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions 
    Cuando  el servicio responda con código 0 o 003
    Entonces  el cliente continua con el flujo normal

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-101
  Escenario: Servicio fallido
    Dado que el usuario está en la pantalla de identificación de usuario y se llamó el servicio de costumer conditions 
    Cuando  el servicio responda con código diferente a 0, 003 y 8888
    Entonces  se redirecciona al cliente a la pantalla de error técnico