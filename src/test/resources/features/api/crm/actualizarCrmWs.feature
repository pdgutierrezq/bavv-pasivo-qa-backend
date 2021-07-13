  # language: es
  @Backend:PantallaDeclarante
  @BackendCDT

  @Sprint67
  @PBA-2652

  Característica: Actualizar CRM
    YO COMO Usuario
    NECESITO actualizar mi informacion de crm
    PARA crear el producto pasivo

    Escenario: Actualizar y validar Crm
      Dado que el "no cliente" se autenticó, radicó pasivo y consultó crm
      Cuando el usuario actualiza la información en crm
      Entonces se validará que la información se actualizó

