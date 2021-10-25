# language: es
@sprint:91
@app:CDT
@functionality:Producto.Info.Basica.Pantalla
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Pantalla de datos basicos del CDT
  YO como banco
  QUIERO conocer el tipo de CDT que el cliente quiera abrir
  PARA saber si puedo crear el CDT

  @issue:PBA-3301
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  @testrail-id:515699
  Escenario: Alerta cuenta disponible con dinero visible
    Dado que llegué a la pantalla de configuración CDT
    Cuando cargue la pantalla
    Entonces aparecerá el siguiente texto de acuerdo al mock up “No olvides tener disponible en tu cuenta el dinero para transferir a tu CDT Digital. No debe estar bloqueado, ni guardado en bolsillos de ahorro para que puedas disponer de el.”
