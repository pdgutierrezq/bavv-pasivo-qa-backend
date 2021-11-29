# language: es
@sprint:100
@issue:PBA-3961
@app:CDA
@functionality:Pantalla.PEP.Textos
@screen:landing
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Textos en pantalla de preguntas sobre el extranjero
  YO como banco
  QUIERO conocer si el estado legal del cliente
  PARA saber si puedo crear el CDT

  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521770
  Escenario: Titulo en pantalla de preguntas del extranjero
    Dado que llegué a la pantalla de enrolamiento
    Cuando cargue la pantalla
    Entonces aparecerá el titulo “Indícanos la transacción principal que realizas en moneda extranjera” de acuerdo al mock up
