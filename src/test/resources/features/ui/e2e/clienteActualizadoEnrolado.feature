# language: es
@Frontend:E2E-ClienteActualizadoEnrolado
@PBA-255
@Sprint-23
@PBA-470
Característica: Creación cuenta de ahorros cliente actualizado enrolado
  YO COMO  cliente actualizado
  NECESITO abrir una cuenta de ahorros digital
  PARA tener acceso a una cuenta de ahorros digital

  @e2e
  @regresion
  @CDA
  Escenario: Creación cuenta de ahorros pro con cliente actualizado con seguro
    Dado que se obtiene un usuario tipo "cliente actualizado sin lista restrictiva con cuenta cat y que tenga canales"
    Cuando el usuario realiza el flujo con "Cuenta Digital" y "acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @e2e
  @regresion
  @CDA
  Escenario: Creación cuenta de ahorros pro con cliente actualizado  sin seguro
    Dado que se obtiene un usuario tipo "cliente actualizado sin lista restrictiva con cuenta cat y que tenga canales"
    Cuando el usuario realiza el flujo con "Cuenta Digital" y "no acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @simple
  Escenario: Creación cuenta de ahorros simple con cliente actualizado con seguro
    Dado que se obtiene un usuario tipo "cliente actualizado sin lista restrictiva sin cuenta cat y que tenga canales"
    Cuando el usuario realiza el flujo con "cuenta simple" y "acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @simple
  Escenario: Creación cuenta de ahorros simple con cliente actualizado  sin seguro
    Dado que se obtiene un usuario tipo "cliente actualizado sin lista restrictiva sin cuenta cat y que tenga canales"
    Cuando el usuario realiza el flujo con "cuenta simple" y "no acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta
