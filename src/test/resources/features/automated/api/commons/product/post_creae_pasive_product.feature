# language: es
@sprint:7
@issue:PBA-177
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Producto.Crear
@screen:declarante
@layer:backend
@service:create-passive-product
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Radicar pasivo
  YO COMO Usuario
  NECESITO Radicar pasivo
  PARA crear el producto pasivo

  @testrail-id:515654
  Escenario: Peter crea un producto pasivo
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el crea un producto pasivo en el banco
    Entonces el obtinene una respuesta exitosa

