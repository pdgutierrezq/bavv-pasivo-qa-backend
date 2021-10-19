# language: es
@sprint:68
@issue:PBA-2612
@app:CDT
@functionality:Banco.Tasas
@screen:landing
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consulta de tasas
  YO como cliente abriendo producto
  QUIERO que se me informe las tasas actualizadas
  PARA iniciar el proceso de apertura CDT

  @testrail-id:515634
  Escenario: Consulta de tasas CDT
    Dado que el "usuario" esta habilitado para consultar las tasas
    Cuando realizala consulta de las tasas
    Entonces se validará la correcta estructura de la respuesta

