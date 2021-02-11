  # language: es
  @Frontend:DireccionEnvioTarjeta
  @Sprint-58
  @PBA-2033
  @CDT

  Característica: CDT Pantalla de dirección de envío de tarjeta debito
    YO COMO usuario en pantalla de dirección de envío de tarjeta debito
    NECESITO definir dirección del usuario
    PARA recibir mi tarjeta débito

    @regresion
    Escenario:  cargue de Dirección y ciudad para el envío CDT cliente actualizado
      Dado que se obtiene un usuario tipo "cliente actualizado"
      Cuando se cargue la pantalla de envio de tarjeta para cdt
      Entonces el sistema debe traer la dirección y ciudad de residencia que tiene en memoria proveniente de crm

    @regresion
    Escenario:  cargue de Dirección y ciudad para el envío CDT cliente desactualizado
      Dado que se obtiene un usuario tipo "cliente no actualizado"
      Cuando se cargue la pantalla de envio de tarjeta para cdt
      Entonces el sistema debe traer la dirección y ciudad de residencia que tiene en memoria proveniente de datos de contacto


