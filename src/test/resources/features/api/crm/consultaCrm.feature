  # language: es
  @Backend:ConsultaCrm
  @BackendCommon

  @Sprint10
  @PBA-39

  Característica: Consulta CRM
    YO COMO Usuario
    NECESITO consultar mi informacion de crm
    PARA crear el producto pasivo

    @ss
    Escenario: consultar Crm
      Dado que se obtiene un usuario para consultar crm de tipo "aleatorio"
      Cuando el usuario consulta la información en crm
      Entonces se validará la correcta estructura de la respuesta de consulta crm


