  # language: es
  @Frontend:OfrecimientoDeCuentas
  @Sprint-7
  @PBA-28
  @ok

  Característica: Creación pantalla de ofrecimiento de cuentas
    YO COMO usuario
    NECESITO conocer las características de las cuentas de ahorros
    PARA escoger cual cuenta tomar


    Escenario: Resaltar cuenta simple
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Cuando el usuario diligencia el formulario con salario "1799000"
      Entonces la pantalla me debe mostrar la información de las cuentas, resaltando la cuenta simple

    Escenario: Resaltar cuenta Pro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "<listRest>"
      Cuando el usuario diligencia el formulario con salario igual o superior a "1800000"
      Entonces la pantalla me debe mostrar la información de las cuentas, resaltando la cuenta PRO

