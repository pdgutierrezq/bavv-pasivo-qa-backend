# language: es
@FBackend:test


Característica: Consumir servicio de identificación de usuario de la nube negra (TECH)
  YO COMO sistema
  NECESITO validar si un usuario es quien dice ser
  PARA dejarlo continuar con el proceso de apertura de cuenta de forma segura


#  @Sprint-3
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
#  @example
#  Escenario: test obtener otp
#    Dado que se genera otp
#    Cuando se consulta massivian
#    Entonces se obtiene otp


  @example
  Escenario: test obtener otp
    Dado que se conecta a oracle
    Cuando se consulta massivian
    Entonces se obtiene otp
