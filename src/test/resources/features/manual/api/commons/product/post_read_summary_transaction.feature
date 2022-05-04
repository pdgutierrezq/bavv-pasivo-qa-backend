# language: es
@sprint:51
@issue:PBA-2465
@app:COMMONS
@functionality:Producto.Leer
@screen:declarante
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Llamado de read summary transaction en pantalla de declarante
  YO COMO sistema
  NECESITO consumir el servicio de read summary transaction (Actualización)
  PARA finiquitar el flujo

  @testrail-id:516454
  Escenario: Consumo del servicio read summary transaction (Actualización)
    Dado que el cliente está en la pantalla de declarante
    Cuando seleccione la opción para continuar
    Entonces se llama read summary transaction (Actualización) y actualizar CRM .
