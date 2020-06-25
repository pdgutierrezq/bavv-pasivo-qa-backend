  # language: es
  @Frontend:OfrecimientoDeCuentas
  @Sprint-7
  @PBA-28
  @PBA-77
  @ok

  Característica: Creación pantalla de ofrecimiento de cuentas
    YO COMO usuario
    NECESITO conocer las características de las cuentas de ahorros
    PARA escoger cual cuenta tomar

    Esquema del escenario: Resaltar cuenta simple
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Cuando el usuario diligencia el formulario con salario "1799000"
      Entonces se presentaran las dos cuentas pero sugiriendo la cuenta "SIMPLE" en lado izquierdo de la pantalla y el texto debe decir "<texto>"
      Ejemplos:
        | texto                                                    |
        | Creemos que la Cuenta Simple se ajusta a tus necesidades |

    Esquema del escenario: Resaltar cuenta Pro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "<listRest>"
      Cuando el usuario diligencia el formulario con salario igual o superior a "1800000"
      Entonces se presentaran las dos cuentas pero sugiriendo la cuenta "PRO" en lado izquierdo de la pantalla y el texto debe decir "<texto>"
      Ejemplos:
        | texto                                                 |
        | Creemos que la Cuenta Pro se ajusta a tus necesidades |

    Esquema del escenario: Ofrecimiento de solo cuenta Pro por que el usuario tiene una CAT
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "true"
      Cuando el usuario diligencia el formulario con salario igual o superior a "1800000"
      Entonces solo se muestra la cuenta Pro y el texto debe decir "<texto>"
      Ejemplos:
        | texto                                                 |
        | Creemos que la Cuenta Pro se ajusta a tus necesidades |

    Escenario: Re-dirección a pantalla de selección de paquete dinámico
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Cuando que el cliente esta en pantalla Ofrecimiento de cuentas y seleccionó "cuenta pro"
      Entonces pasara a pantalla Selección de paquete dinámico Cuenta PRO

    Escenario: Re-dirección a pantalla de oferta de seguro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Cuando que el cliente esta en pantalla Ofrecimiento de cuentas y seleccionó "cuenta simple"
      Entonces pasara a pantalla Oferta y aceptación de seguro
