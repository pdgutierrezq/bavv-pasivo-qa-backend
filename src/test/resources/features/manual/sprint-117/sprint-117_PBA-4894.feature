# language: es
@sprint:117
@issue:PBA-4894
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Modificaciones envío td
  YO como* Seguridad
*Necesito* que no se pueda modificar la dirección de envío de TD
  PARA  mantener controles de seguridad en el flujo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Clientes actualizados*
    Dado que  es un cliente actualizado
    Cuando  se muestre la pantalla de dirección de envío de TD en el flujo de cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo al mockup y no debe permitir modificar la dirección de entrega de TD del cliente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Clientes desactualizados pantalla datos de contacto*
    Dado que  es un cliente desactualizado
    Cuando  se muestre la pantalla de datos de contacto en el flujo de cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo al mockup con los campos de dirección, barrio y ciudad ocultos 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Clientes desactualizados entrega td*
    Dado que  es un cliente desactualizado 
    Cuando  se muestre la pantalla de dirección de envío de TD en el flujo de cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo al mockup y no debe permitir modificar la dirección de entrega de TD del cliente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Clientes nuevos pantalla datos de contacto*
    Dado que  es un cliente nuevo
    Cuando  se muestre la pantalla de datos de contacto en el flujo de cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo a la funcionalidad actual con los campos de dirección, barrio y ciudad visibles y modificables

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: Clientes nuevos*
    Dado que  es un cliente nuevo 
    Cuando  se muestre la pantalla de dirección de envío de TD en el flujo cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo a la funcionalidad actual y debe permitir ingresar/cambiar la dirección de entrega de TD del cliente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-117
  Escenario: No llegan datos de ciudad*
    Dado que  es un cliente nuevo o desactualizado y no llegan datos de ciudad del cliente
    Cuando  se muestre la pantalla de dirección de envío de TD en el flujo cuenta/ depósito / nómina
    Entonces  me debe mostrar la pantalla de acuerdo a la funcionalidad actual y debe permitir ingresar la dirección de entrega de TD del cliente
     #Nota: Tener en cuenta que se debe mostrar en entrega de TD la tarjeta roja para depósitos y la negra para cuenta digital y nómina.