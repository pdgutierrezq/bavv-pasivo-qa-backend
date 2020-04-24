# language: es
@FBackend:test


Característica: condiciones cliente
  YO COMO sistema
  NECESITO on¡btener informaicon de las condicion es del cliente
  PARA direccionarlo al flujo correspondiente

  @Sprint-3
  Esquema del escenario: Consumir servicio de condiciones cliente
    Dado que tengo un usuario tipo "<usuario>"
    Cuando consumo el servicio rest de condiciones cliente
    Entonces el obtengo la informacion de las condiciones del cliente
    Ejemplos:
      | usuario             |
      | listas restrictivas |

#
#  @example
#  Esquema del escenario: test flujo
#    Dado el usuario "<tipo usuario>" diligencia el formulario  de identificacion
#    Cuando esta en pantalla de ofecimiento de cuenta y selecciona cuenta "<tipo cuenta>"
#    Y "<aceptacion seguro>" acepta el ofrecimiento de seguro
#    Entonces el usuario ingresa la otp
#    Ejemplos:
#      | tipo usuario | tipo cuenta | aceptacion seguro |
#      | actualizado  | simple      | no                |

