# language: es
@sprint:61
@issue:PBA-2295
@app:CDT
@functionality:Cliente.Info.Tarjeta.Campo_barrio
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: CDT Pantalla de dirección de envío de tarjeta debito
  YO COMO usuario en pantalla de dirección de envío de tarjeta debito
  NECESITO definir dirección del usuario
  PARA recibir mi tarjeta débito

  @testrail-id:515729
  Escenario: Cargue de Dirección y ciudad para el envío CDT cliente actualizado
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando se cargue la pantalla de envio de tarjeta para cdt
    Entonces el sistema debe traer la dirección, barrio y ciudad de residencia que tiene en memoria proveniente de crm

  @testrail-id:515730
  Escenario: Cargue de Dirección y ciudad para el envío CDT cliente desactualizado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Cuando se cargue la pantalla de envio de tarjeta para cdt
    Entonces el sistema debe traer la dirección, barrio y ciudad de residencia que tiene en memoria proveniente de datos de contacto


