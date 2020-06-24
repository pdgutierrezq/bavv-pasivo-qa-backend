  # language: es
  @Frontend:PantallaPep
  @Sprint-5
  @PBA-66
  @ok

  Característica: Creación de pantalla de PEP con Tooltip
    YO COMO no cliente o cliente desactualizado del BAVV
    NECESITO que se me muestre la pantalla PEP
    PARA definir si soy o no PEP

    @Sprint-6
      @PBA-162
    Esquema del escenario: Pantalla para definir si es o no PEP
      Dado que se obtiene un usuario tipo cliente "<cliente>" actualizado "<actualizado>" lista restrictiva "<listRest>"
      Cuando el cliente superó el recaptcha.
      Entonces se muestra la pantalla PEP.
      Ejemplos:
        | cliente | actualizado | listRest |
        | true    | false       | false    |
        | false   | false       | false    |

    Escenario: Detalle de lo que es un PEP
      Dado que el cliente "true" actualizado "false" lista restrictiva "false" esta en pantalla PEP
      Cuando el cliente ingresa en el tooltip
      Entonces se le muestra la información disponible de lo que es un PEP mediante POP-UP.
