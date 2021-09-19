# language: es
@sprint:38
@issue:PBA-1432
@app:COMMONS
@functionality:Banco.Seguros
@screen:seguro_de_cuenta
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Validacion de seguro
  YO COMO sistema
  NECESITO determinar si el cliente tiene o no seguro
  PARA ofrecerle el producto o no

  Escenario: Consumir servicio de insurance-validation
    Dado que se obtiene un usuario tipo "no cliente" para validar seguro
    Cuando se consulta si el usuario tiene seguro
    Entonces se validara que el usuario no tiene seguro


