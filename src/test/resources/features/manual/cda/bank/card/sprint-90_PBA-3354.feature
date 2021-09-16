# language: es
@sprint:90
@issue:PBA-3354
@app:CDA
@functionality:Banco.Tarjeta
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Textos pantalla de envío de tarjeta
  YO como cliente en proceso de apertura de cuenta digital
  QUIERO tener la opción de que me envíen la tarjeta debito
  PARA que me depositen mis rendimientos del cdt .

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-90
  @testrail-evidence:informes/Sprint_90/HU3354/envio_de_tarjeta
  Escenario: Actualización de texto
    Dado que estoy en la pantalla de envío de tarjeta debito
    Cuando lea la información del tiempo de entrega de la tarjeta
    Entonces  el texto dirá "Verifica que la dirección sea correcta y que una persona mayor de edad la pueda recibir. Aproximadamente en 10 días hábiles."

