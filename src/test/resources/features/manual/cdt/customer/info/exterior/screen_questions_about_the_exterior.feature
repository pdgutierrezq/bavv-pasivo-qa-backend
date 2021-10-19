# language: es
@sprint:91
@app:CDT
@functionality:Cliente.Info.Exterior.Pantalla
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Pantalla de preguntas sobre el extranjero
  YO como banco
  QUIERO conocer si el estado legal del cliente
  PARA saber si puedo crear el CDT

  @issue:PBA-3301
  @manual
  @manual-result:passed
  @manual-last-tested:sprint-91
  @testrail-id:515698
  Escenario: Imagen en pantalla de preguntas sobre el extranjeto
    Dado que llegué a la pantalla de preguntas sobre el extranjero
    Cuando cargue la pantalla
    Entonces la imagen de preguntas del extranjero esté correctamente de acuerdo al mockup.
