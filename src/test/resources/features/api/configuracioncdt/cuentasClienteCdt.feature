# language: es
@Backend:CuentasCliente
@BackendCDT

@Sprint-44
@PBA-1613
@Sprint-76
@PBA-3055

@regresion
@rrr

Característica: Consulta servicio de cuentas por cliente
  YO COMO Cliente
  NECESITO consultar mis cuentas en el bancoc
  PARA abrir mi CDT

  Escenario: consulta cuentas cliente CDT sin cuentas disponibles para fondear
    Dado que se obtiene un usuario "con cuentas en el banco y saldo de 36'000.000"
    Cuando consulta las cuentas del cliente con monto 100000000
    Entonces se validara que no hay cuentas con saldo disponibles para fondear

  Escenario: consulta cuentas cliente CDT con cuentas disponibles para fondear
    Dado que se obtiene un usuario "con cuentas en el banco y saldo de 36'000.000"
    Cuando consulta las cuentas del cliente con monto 34000000
    Entonces se validara que si hay cuentas con saldo disponibles para fondear

  Escenario: consulta cuentas cliente CDT sin cuentas
    Dado que se obtiene un usuario "sin cuentas en el banco"
    Cuando consulta las cuentas del cliente
    Entonces se validara que no tiene cuentas disponibles


