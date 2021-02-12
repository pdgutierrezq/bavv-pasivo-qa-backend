# language: es
@Frontend:CDT-precarga
@Sprint-57
@Sprint-58
@Sprint-59
@PBA-2288
@PBA-2182

@Back-CRM-Barrio
@PBA-2326

Característica: Implementar Precarga de info a cliente des actualizado CDT
  YO COMO Cliente
  NECESITO que me muestre la información que tiene CRM del banco
  PARA mejorar mi experiencia

  @CDT
  @regresion
  Escenario: Pre carga de datos para pantalla de datos de contacto
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Y que hay información del usuario en el banco
    Cuando ingrese a la pantalla de datos de contacto o información financiera.
    Entonces se pre cargarán los datos en la pantalla.
