# language: es
@sprint:91
@app:CDT
@functionality:Bank.Card.Pantalla
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Pantalla de tarjeta debito
  YO como banco
  QUIERO conocer informacion de envio de la tarjeta debito
  PARA saber donde enviar la tarjeta de credito

  @issue:PBA-3301
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  Escenario: Subtitulo
    Dado que llegué a la pantalla de tarjeta debito
    Cuando cargue la pantalla
    Entonces aparecerá el siguiente texto como subtitulo de acuerdo al mock up “Verifica que la dirección sea correcta y que una persona mayor de edad la pueda recibir. Aproximadamente en 10 días hábiles.”
