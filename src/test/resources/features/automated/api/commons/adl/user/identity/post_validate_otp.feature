# language: es
@sprint:24
@issue:PBA-168
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Cliente.OTP
@screen:OTP
@layer:backend
@layer:backend
@service:user-identity
@repository:bavv-pasivo-backend-security-lambdas
Característica: Validar OTP de un usuario
  YO COMO PO
  NECESITO validar que la OTP digitada por el usuario es correcta
  PARA validar la autenticidad del usuario

  Escenario: Generacion correcta de una OTP
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el solicita la generacion de una OTP
    Entonces el recibe una respuesta de generacion exitosa

  @testrail-id:529448
  Escenario: Validacion correcta de una OTP
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el solicita la validacion de la OTP
    Entonces el recibe una respuesta de validacion exitosa


