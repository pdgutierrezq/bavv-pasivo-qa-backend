# language: es
@sprint:105
@issue:PBA-4095
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Mapeo de cromalines deposito digital
  YO COMO* usuario en pantalla de dirección de envío de tarjeta debito 
*NECESITO* definir el tipo de tarjeta que
  QUIERO 
  PARA  recibirla en mi casa con dichas especificaciones

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: (validación) despliegue de pregunta transporte masivo
    Dado que el usuario esta en pantalla dirección de envío de tarjeta débito
    Cuando  ingrese alguna ciudad que tiene la opción transporte masivo
    Entonces  Se desplegará la pregunta de si quiere la tarjeta con transporte masivo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Mapeo de cromaline estandar deposito
    Dado que el usuario está en pantalla dirección de envío de tarjeta débito , es un deposito digital y no marca la opción de transporte masivo o no tiene la opción de transporte masivo
    Cuando  seleccione la opción para continuar
    Entonces  guardará en memoria el código 97

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Mapeo de cromaline estandar cuenta
    Dado que el usuario está en pantalla dirección de envío de tarjeta débito, es una cuenta digital y no marca la opción de transporte masivo o no tiene la opción de transporte masivo
    Cuando  seleccione la opción para continuar
    Entonces  guardará en memoria el código 105

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Mapeo de cromaline deposito
    Dado que el usuario está en pantalla dirección de envío de tarjeta débito, es un deposito digital y marca la opción de transporte masivo
    Cuando  seleccione la opción para continuar
    Entonces  guardará en memoria el código correspondiente a la ciudad ingresada ubicada en el archivo adjunto (código detallado en la columna “Transporte Masivo Deposito Digital”)
     #Ejemplo: 
     #Funza --->98
     #Soledad--->99
     #Salento--->100

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Mapeo de cromaline cuenta
    Dado que el usuario está en pantalla dirección de envío de tarjeta débito, es cuenta digital y marca la opción de transporte masivo
    Cuando  seleccione la opción para continuar
    Entonces  guardará en memoria el código correspondiente a la ciudad ingresada ubicada en el archivo adjunto (código detallado en la columna “Transporte Masivo Cta Digital”)
     #Ejemplo: 
     #Cota --->106
     #Soledad--->107
     #Salento--->108

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Mapeo de cromaline en rpp 2
    Dado que se llamó el websocket 2
    Cuando  se llame el servicio de RPP 2
    Entonces  se enviará el cromaline guardado en memoria que el cliente seleccionó