# language: es
@sprint:7
@issue:PBA-177
@app:COMMONS
@functionality:radicar_pasivo
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

  @testrail-id:510215
  Escenario: Radicar pasivo
    Dado que el "no cliente" se autenticó
    Cuando el usuario radica el producto pasivo
    Entonces se validará que la estructura de la respuesta es correcta

