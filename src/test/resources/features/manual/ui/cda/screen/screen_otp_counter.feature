# language: es
@sprint:117
@issue:PBA-4922
@app:CDA
@functionality:Pantalla.Otp
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Habilitar generación de OTP después de 40 segundos-CDA
  Yo como ATH
  Necesito que se ponga una restricción en la solicitud de OTP
  Para poder procesar las solicitudes exitosamente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Generar OTP
    Dado que nos encontramos en la pantalla de OTP
    Cuando pasen 40 segundos desde la primera generación de OTP
    Entonces me debe habilitar el botón de generar una nueva OTP

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: No Generar OTP
    Dado que nos encontramos en la pantalla de OTP
    Cuando no hayan pasado 40 segundos desde la primer generación de OTP
    Entonces no me debe habilitar el botón de generar una nueva OTP

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Validación de contador decreciente
    Dado que nos encontramos en la pantalla de OTP
    Cuando se haya generado la primera OTP
    Entonces debe mostar el mensaje “Puedes solicitar un nuevo código en 00:40”, ir disminuyendo hasta llegar a 00:00 y estar inhabilitado para solicitar un nuevo código

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Validación contador en 00:00
    Dado que nos encontramos en la pantalla de OTP
    Cuando se haya generado la primera OTP y hayan pasado 40 segundos
    Entonces debe mostrar el mensaje “Puedes solicitar un nuevo código en 00:00” y estar habilitado para solicitar un nuevo código
