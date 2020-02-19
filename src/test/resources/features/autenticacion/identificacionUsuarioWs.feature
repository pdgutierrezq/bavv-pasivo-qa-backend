# language: es
@FBackend:IdentificacionUsuario


Característica: Consumir servicio de identificación de usuario de la nube negra (TECH)
  YO COMO sistema
  NECESITO validar si un usuario es quien dice ser
  PARA dejarlo continuar con el proceso de apertura de cuenta de forma segura


  @Sprint-3
#    @example
  Esquema del escenario: Consumir servicio de identificación de usuario
    Dado que tengo el "<tipo>", "<número>" de documento y demás datos de autenticación de un usuario
    Cuando consumo el servicio rest de identificación
    Entonces el servicio se encarga de enviar OTP al usuario o me informa que no pasó alguna validación
    Ejemplos:
      | tipo | número     |
      | CC   | 1095798406 |
