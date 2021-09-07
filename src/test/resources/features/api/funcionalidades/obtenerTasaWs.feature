# language: es
@sprint:68
@issue:PBA-2612
@app:CDT
@feature:Consulta_de_tasas
@screen:landing
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consulta de tasas
  Yo como cliente abriendo producto
  quiero que se me informe las tasas actualizadas
  para iniciar el proceso de apertura CDT

  @testrail-id:510247
  Escenario: Consulta de tasas CDT
    Dado que el "usuario" esta habilitado para consultar las tasas
    Cuando realizala consulta de las tasas
    Entonces se validará la correcta estructura de la respuesta

