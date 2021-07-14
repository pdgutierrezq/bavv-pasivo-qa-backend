  # language: es
  @Backend:PantallaDeclarante
  @BackendCommon

  @Sprint7
  @PBA-177

  Característica: Radicar pasivo
    YO COMO Usuario
    NECESITO Radicar pasivo
    PARA crear el producto pasivo

    Escenario: Radicar pasivo
      Dado que el "no cliente" se autenticó
      Cuando el usuario radica el producto pasivo
      Entonces se validará que la estructura de la respuesta es correcta

