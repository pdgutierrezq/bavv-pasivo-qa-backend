# language: es
@sprint:99
@issue:PBA-3785
@app:CDT
@functionality:Banco.Enrolamiento.Redireccion
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Redirección consulta de usuario sds fallida a pse
  YO COMO usuario abriendo un cdt y que no se si soy enrolado o no
  QUIERO que se me permita fondear mi CDT por PSE
  PARA  concretar la apertura de mi CDT

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-99
  @testrail-id:520780
  Escenario: Falla en servicio de consulta usuarios en sds y redirección a pse flujo
    Dado que  se llamó el servicio para saber si el usuario está enrolado
    Cuando  sea fallido y va a fondear por PSE
    Entonces  se redirecciona al cliente a pantalla de PSE en el flujo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-99
  @testrail-id:520781
  Escenario: Falla en servicio de consulta usuarios en sds y redirección a tips cdt
    Dado que  se llamó el servicio para saber si el usuario está enrolado
    Cuando  sea fallido y fondeó por cuenta AV Villas
    Entonces  se redirecciona al cliente a la pantalla de Tips CDT
