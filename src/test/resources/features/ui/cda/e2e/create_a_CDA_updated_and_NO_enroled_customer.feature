# language: es
@sprint:23
@issue:PBA-470
@app:CDA
@functionality:E2E.Creación.Enrolado.NO
@layer:frontend
@execution:automatic
@automation:complete
Característica: Creación cuenta de ahorros cliente actualizado NO enrolado
  YO COMO  cliente actualizado NO enrolado
  NECESITO abrir una cuenta de ahorros digital
  PARA tener acceso a una cuenta de ahorros digital

  @priority:high
  @regression:yes
  @testrail-id:515717
  Escenario: Creación cuenta de ahorros pro con cliente actualizado NO enrolado con seguro
    Dado que se obtiene un usuario tipo "cliente actualizado que no tenga canales"
    Cuando el usuario realiza el flujo con "Cuenta Digital" y "acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @priority:high
  @regression:yes
  @testrail-id:515718
  Escenario: Creación cuenta de ahorros pro con cliente actualizado NO enrolado sin seguro
    Dado que se obtiene un usuario tipo "cliente actualizado que no tenga canales"
    Cuando el usuario realiza el flujo con "Cuenta Digital" y "no acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @priority:low
  @regression:no
  @testrail-id:515719
  Escenario: Creación cuenta de ahorros simple con cliente actualizado NO enrolado con seguro
    Dado que se obtiene un usuario tipo "cliente actualizado que no tenga canales"
    Cuando el usuario realiza el flujo con "cuenta simple" y "acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta

  @priority:low
  @regression:no
  @testrail-id:515720
  Escenario: Creación cuenta de ahorros simple con cliente actualizado NO enrolado sin seguro
    Dado que se obtiene un usuario tipo "cliente actualizado que no tenga canales"
    Cuando el usuario realiza el flujo con "cuenta simple" y "no acepta" el seguro
    Entonces se muestra el resumen de la creación de la cuenta
