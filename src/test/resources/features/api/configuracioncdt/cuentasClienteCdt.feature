# language: es
@sprint:76
@issue:PBA-3055
@app:CDT
@feature:consulta_de_cuentas_por_cliente
@screen:OTP
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consulta servicio de cuentas por cliente
  YO COMO Cliente
  NECESITO consultar mis cuentas en el bancoc
  PARA abrir mi CDT

  @testrail-id:510601
  Escenario: consulta cuentas cliente CDT sin cuentas disponibles para fondear
    Dado que se obtiene un usuario "con cuentas en el banco y saldo de 36'000.000"
    Cuando consulta las cuentas del cliente con monto 100000000
    Entonces se validara que no hay cuentas con saldo disponibles para fondear

  @testrail-id:510602
  Escenario: consulta cuentas cliente CDT con cuentas disponibles para fondear
    Dado que se obtiene un usuario "con cuentas en el banco y saldo de 36'000.000"
    Cuando consulta las cuentas del cliente con monto 34000000
    Entonces se validara que si hay cuentas con saldo disponibles para fondear

  @testrail-id:510603
  Escenario: consulta cuentas cliente CDT sin cuentas
    Dado que se obtiene un usuario "sin cuentas en el banco"
    Cuando consulta las cuentas del cliente
    Entonces se validara que no tiene cuentas disponibles


