# language: es
@Frontend:PantallasDeError
@ok
Característica: Pantallas de error tecnico y de proceso
  Yo como cliente abriendo producto
  quiero que se me informe si no puedo abrir el producto
  para finalizar el proceso


  Escenario:  Pantalla de error de proceso
    Dado que se obtiene un usuario tipo cliente lista restrictiva "true"
    Cuando se valide en algún paso que hay una restricción
    Entonces se muestra la pantalla de error de proceso

