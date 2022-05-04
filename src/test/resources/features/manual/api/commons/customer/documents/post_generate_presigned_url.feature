# language: es
@sprint:26
@issue:PBA-1061
@app:COMMONS
@functionality:Cliente.Documentos
@screen:documentos
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Consumo de servicio de generar documentos prefirmados
  YO COMO sistema
  NECESITO consumir el servicio de generar documentos prefirmados
  PARA poderlos consultar

  @testrail-id:516425
  Escenario: Llamar para prefirmar documentos
    Dado que el cliente está en la pantalla de cargue de docuemntos
    Cuando llamos el servicio de firmado de docuemntos
    Entonces se retorna las lista de documentos con la url del documento prefirmado
