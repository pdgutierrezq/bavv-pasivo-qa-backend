# language: es
@sprint:109
@issue:PBA-4029
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Ajustes otp por voz cdt
  YO  como usuario autenticándome
*Necesito* se me de la opción una opción de OTP por Voz
  PARA  autenticarme

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón de otp por sms
    Dado que  Estoy en la pantalla de OTP
    Cuando  se valide la OTP y es fallida la validación por primera vez 
    Entonces  se muestra la opción actual de OTP por SMS “Solicitar un nuevo código“

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón de otp por voz
    Dado que  Estoy en la pantalla de OTP
    Cuando  se valide la OTP y es fallida la validación por segunda vez
    Entonces  se muestra la opción de OTP por VOZ que menciona el texto “Recibir un nuevo código por llamada telefónica“ de acuerdo a mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón de “recibir un nuevo código por llamada telefónica“
    Entonces  se llama el servicio de generar OTP enviando flag de que es OTP por VOZ.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón de otp por voz
    Dado que  se llamó al servicio de autenticación generar OTP
    Cuando  sea por tercera vez
    Entonces  se llama el servicio de generar la OTP enviando el flag de que es OTP por VOZ
     #Nota: Realizar las validaciones de acuerdo al control de OTP que ya se tiene por cedula en el día.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón de otp por sms
    Dado que  se llamó al servicio de autenticación generar OTP
    Cuando  esté apagado el flag de OTP por voz
    Entonces  en la primer y segunda validación si es fallida se debe mostrar la opción actual de OTP por SMS “Solicitar un nuevo código”
     #Nota: Realizar las validaciones de acuerdo al control de OTP que ya se tiene por cedula en el día.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-109
  Escenario: Ón otp por sesión
    Dado que  se llamó al servicio de autenticación generar OTP
    Cuando  se hayan generado el máximo número de intentos por sesión (máximo 3)
    Entonces  me debe desbordar del flujo porque superé el máximo número de intentos al día