# language: es
@sprint:38
@issue:PBA-1432
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Banco.Seguros
@screen:PEP
@layer:backend
@service:insurance-validation
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Validacion de seguro
  YO COMO sistema
  NECESITO determinar si el cliente tiene o no seguro
  PARA ofrecerle el producto o no

  @testrail-id:515652
  Escenario: Consumir servicio de insurance-validation
    Dado que se obtiene un usuario tipo "no cliente" para validar seguro
    Cuando se consulta si el usuario tiene seguro
    Entonces se validara que el usuario no tiene seguro


