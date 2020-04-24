# language: es
@FBackend:IdentificacionUsuario


Característica: Consumir servicio de identificación de usuario de la nube negra
  YO COMO sistema
  NECESITO validar si un usuario es quien dice ser
  PARA dejarlo continuar con el proceso de apertura de cuenta de forma segura


  @Sprint-3
    @PBA-15
  Esquema del escenario: Consumir servicio de identificacion de usuario para generar otp
    Dado que tengo datos de autenticacion de un usuario "<tipo>"
    Cuando consumo el servicio rest de identificacion
    Entonces el servicio se encarga de enviar OTP al usuario "<tipo>" o me informa que no paso alguna validacion
    Ejemplos:
      | tipo       |
      | valido otp |
      | invalido   |

  @Sprint-6
    @PBA-164
    @testLive
  Esquema del escenario: Consumir servicio de identificacion de usuario para validar otp de forma exitosa
    Dado que tengo datos de autenticacion de un usuario "<tipo>"
    Y el usuario "<tipo>" llama el servicio de identificacion de usuario para generar otp
    Y el usuario obtiene la otp recibida
    Cuando consumo el servicio rest de identificacion para validar otp
    Entonces el servicio el servicio entrega informacion de validacion exitosa
    Ejemplos:
      | tipo       |
      | valido otp |
#      | invalido   |
