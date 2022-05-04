# language: es
@sprint:100
@issue:PBA-3536
@app:CDA
@functionality:Cliente.Autenticación.OTP.Invalida
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Mensaje de OTP invalida
  YO  como usuario autenticándome
  QUIERO se me muestre si la validación de la OTP fue fallida
  PARA  Tener claro si debo modificar el código

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521771
  Escenario: No Reinicio del contador para ingreso del código otp
    Dado que estoy en la pantalla validación Otp
    Cuando ingrese un codigo OTP NO valido
    Entonces  el contador no se reiniciará
    Y se debe mostrar el mensaje “El código que ingresaste no corresponde al enviado.“ (código 56)
