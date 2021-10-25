# language: es
@sprint:90
@issue:PBA-3354
@app:CDA
@functionality:Cliente.Autenticación.OTP
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Validación Otp
  YO como cliente en proceso de autenticación dentro del flujo
  QUIERO recibir el código de verificación otp por mensaje de texto
  PARA validar mi identidad.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-id:515659
  Escenario: No Reinicio del contador para ingreso del código otp
    Dado que estoy en la pantalla validación Otp
    Cuando ingrese la un Codigo otp no valido
    Entonces  el contador no se reiniciará


  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-id:515660
  Escenario: Reinicio del contador para nueva solicitud del código otp
    Dado que estoy en la pantalla validación Otp
    Cuando ingrese quiera un nuevo Codigo otp
    Entonces  el contador se reiniciará
