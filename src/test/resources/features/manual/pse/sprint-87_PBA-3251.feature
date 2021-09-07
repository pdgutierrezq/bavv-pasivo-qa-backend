# language: es
@sprint:87
@issue:PBA-3251
@app:CDT
@feature:pse.devolucion_de_dinero
@layer:backend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Logica de devolución del dinero
  YO como cliente que voy a fondear por PSE
  QUIERO ingresar los datos de una cuenta
  PARA me devuelvan el dinero si no se puede constituir el CDT.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510590
  Escenario: Sección de devolución
    Dado que me encuentro en el flujo de cargué documentos
    Cuando llegue a la pantalla de PSE
    Entonces  aparecerá la pantalla de PSE con la sección de devolución del dinero

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510591
  Escenario: No aparece sección de devolución
    Dado que me encuentro en el flujo de cargué documentos
    Cuando llegue a la pantalla de PSE
    Entonces NO aparecerá la pantalla de PSE con la sección de devolución del dinero

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510592
  Escenario: Campo Banco
    Dado que me encuentro en el flujo de cargué documentos
    Cuando seleccione el banco de donde es mi cuenta
    Entonces se desplegarán las opciones de bancos de acuerdo al listado de PSE y por defecto de mostrará la opción Selecciona tu banco de acuerdo al mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510593
  Escenario: Validación de campo banco obligatorio
    Dado que estoy en la pantalla de PSE y desplegué las opciones del listado de bancos de PSE
    Cuando no seleccione una opción
    Entonces se mostrará el error “Este campo es obligatorio”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510594
  Escenario: Campo numero de cuenta
    Dado que llegué a la pantalla de PSE y estoy en el campo de número de cuenta
    Cuando ingrese información
    Entonces solo permitirá ingresar números

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510595
  Escenario: Campo numero de cuenta max
    Dado que llegué a la pantalla de PSE y estoy en el campo  de número de cuenta
    Cuando ingrese mas de 17 números
    Entonces el cliente no podrá hacerlo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510596
  Escenario: Campo numero de cuenta min
    Dado que llegué a la pantalla de PSE y estoy en el campo  de numero de cuenta
    Cuando ingrese menos de 5 números
    Entonces se mostrará el error “Ingresa un número de cuenta válido”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510597
  Escenario: Campo numero de cuenta obligatoria
    Dado que llegué a la pantalla de PSE y estoy en el campo  de numero de cuenta
    Cuando no ingrese información y deje el campo
    Entonces se mostrará el error “Este campo es obligatorio”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510598
  Escenario: Campo tipo de identificación
    Dado que llegué a la pantalla de PSE
    Cuando ingrese al campo  de tipo de identificación
    Entonces se desplegarán las siguientes opciones Cédula ciudadanía, Cédula extranjería, NIT, Pasaporte, Registro civil de nacimiento y Tarjeta de identidad de acuerdo al mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510599
  Escenario: Campo tipo de identificación  obligatorio
    Dado que llegué a la pantalla de PSE y estoy en el campo tipo de identificación
    Cuando no seleccione información y deje el campo
    Entonces se mostrará el error “Este campo es obligatorio”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-87
  @manual-test-evidence:[JIRA](https://avaldigitallabs.atlassian.net/browse/PBA-3251)
  @testrail-id:510600
  Escenario: Activación del botón continuar
    Dado que llegué a la pantalla de PSE
    Cuando haya ingresado toda la información de manera correcta y completa
    Entonces el botón continuar se activará
