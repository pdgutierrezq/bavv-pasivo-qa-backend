# language: es
@sprint:113
@issue:PBA-XXX
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Cliente.Cuentas
@screen:identificacion_de_usuario
@layer:backend
@service:customer-accounts
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Consultar las cuentas CAT de un usuario
  YO COMO sistema
  NECESITO conocer las cuentas que tiene el usuario y saber si el usuario tiene creada una cuenta de tipo CAT en el banco.
  PARA poder determinar que flujo le corresponde al usuario

  Escenario: Usuario sin cuenta CAT hace una consulta
    Dado David es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CAT.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CAT.IDENTIFICACION}    |
    Cuando el consulta si tiene cuentas CAT
    Entonces el recibe una respuesta exitosa

