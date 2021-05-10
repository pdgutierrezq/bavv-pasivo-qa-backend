  # language: es
  @Frontend:OfrecimientoDeSeguro
  @Sprint-41
  @PBA-1525
  @regresion
  @CDA

  Característica: Consumo de servicio seguro y redirecciones - CDA
    Yo como usuario con o sin seguro  en banco
    Necesito que se me identifique si lo tengo
    Para que se muestre la pantalla de seguro o no

    Escenario: Usuario con seguro
      Dado que el usuario en la aplicacion "no tiene seguro"
      Cuando que el usuario esta en pantalla de 4 x mil, "no" tiene seguro y continua
      Entonces llegará a la pagina de "ofrecimiento seguro"

    Escenario: Usuario sin seguro
      Dado que el usuario en la aplicacion "tiene seguro"
      Cuando que el usuario esta en pantalla de 4 x mil, "si" tiene seguro y continua
      Entonces llegará a la pagina de "autenticacion"


