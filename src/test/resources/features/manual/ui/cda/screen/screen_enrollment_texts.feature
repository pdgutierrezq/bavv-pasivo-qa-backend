# language: es
@sprint:100
@issue:PBA-3961
@app:CDA
@functionality:Pantalla.Bienvenida.Textos
@screen:landing
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Textos en pantalla de enrolamiento
  YO como Cliente interesado en una cuenta o deposito
  QUIERO tener un visual inicial de los productos
  PARA  iniciar la compra de una cuenta o deposito

  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521766
  Escenario: Titulo en pantalla de enrolamiento
    Dado que llegué a la pantalla de enrolamiento
    Cuando cargue la pantalla
    Entonces aparecerá el titulo “¡Ya creaste tu(s) producto(s)!” de acuerdo al mock up
