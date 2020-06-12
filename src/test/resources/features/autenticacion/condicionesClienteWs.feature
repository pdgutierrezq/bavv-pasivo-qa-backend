# language: es
@FBackend:test
@ok
@PBA-14

Característica: condiciones cliente
  YO COMO sistema
  NECESITO obtener informaicon de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  @Sprint-3
  Esquema del escenario: Consumir servicio de condiciones cliente
    Dado que se obtiene un usuario tipo cliente "<cliente>" actualizado "<actualizado>" lista restrictiva "<listRest>"
    Cuando consumo el servicio rest de condiciones cliente
    Entonces el obtengo la informacion de las condiciones del cliente
    Ejemplos:
      | cliente | actualizado | listRest |
      | true    | true        | true     |
      | true    | true        | false    |
      | true    | false       | false    |
      | true    | false       | true     |
      | false   | false       | false    |
      | false   | true        | false    |
#      | false   | true        | true     |
#      | false   | false       | true     |



