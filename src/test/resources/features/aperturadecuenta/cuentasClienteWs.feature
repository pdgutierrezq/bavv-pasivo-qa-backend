# language: es
@Backend:CuentasCliente
@Sprint-3
@PBA-219
@ok

Característica: Servicio web de cuentas clieente
  YO COMO sistema
  NECESITO obtener informaicon de las cuentas del cliente
  PARA direccionarlo al flujo correspondiente

  Esquema del escenario: Consumir servicio cuentas cliente
    Dado que se obtiene un usuario tipo cat "<cat>"
    Cuando consumo el servicio rest de cuentas cliente
    Entonces se validara que la respuesta coincide con las cuentas del cliente
    Ejemplos:
      | cat   |
      | true  |
      | false |



