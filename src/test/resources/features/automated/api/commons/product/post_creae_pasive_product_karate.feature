# language: es
@sprint:7
@issue:PBA-178
@app:COMMONS
@functionality:Producto.Crear
@screen:declarante
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Radicar pasivo
  YO COMO Usuario
  NECESITO Radicar pasivo
  PARA crear el producto pasivo

  @testrail-id:529449
  Escenario: Peter crea un producto pasivo
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el crea un producto pasivo en el banco
#    Entonces la siguiente informacion esta presente en la respuesta del banco

