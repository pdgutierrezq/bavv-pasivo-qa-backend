# language: es
@Backend:ObtenerTasas
@BackendCDT

@PBA-68
@PBA-2612
@regresion

Característica: Consulta de tasas
  Yo como cliente abriendo producto
  quiero que se me informe las tasas actualizadas
  para iniciar el proceso de apertura CDT

  Escenario:  Consulta de tasas CDT
    Dado que el "usuario" esta habilitado para consultar las tasas
    Cuando realizala consulta de las tasas
    Entonces se validará la correcta estructura de la respuesta

