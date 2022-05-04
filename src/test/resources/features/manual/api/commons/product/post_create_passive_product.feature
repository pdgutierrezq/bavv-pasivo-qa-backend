# language: es
@sprint:20
@issue:PBA-210
@app:COMMONS
@functionality:Producto.Crear
@screen:declarante
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Consumo del servicio para crear producto pasivo
  YO COMO Sistema
  NECESITO consumir el servicio Radicación producto pasivo 1
  PARA que la cuenta quede reservada en el banco

  @testrail-id:516434
  Escenario: Consumo del servicio de Radicar producto pasivo
    Dado que tengo la información de la cuenta que seleccionó el usuario
    Cuando se consuma  el Proceso de CRM, crear cuenta1 y saber si enrolar .
    Entonces se consume en simultaneo a CRM el servicio de Radicar producto pasivo.

  @testrail-id:516435
  Escenario: Consumo no exitoso de Radicar producto pasivo
    Dado que se consumió el servicio de Radicar producto pasivo
    Cuando tan pronto se sepa que fue fallido
    Entonces se debe reportar un ErrorDTO con errorCode 500 .
