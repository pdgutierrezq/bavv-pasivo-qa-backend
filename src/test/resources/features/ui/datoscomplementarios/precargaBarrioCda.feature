# language: es
@Frontend:CDA-precarga
@Sprint-22
@PBA-55
@Sprint-59
@PBA-1153

@Back-CRM-Barrio
@PBA-2326

@CDA
@regresion

Característica: Pre carga de información para datos básicos CDA
  YO COMO Cliente no actualizado
  NECESITO que me muestre la información que tiene CRM del banco
  PARA mejorar mi experiencia

  Escenario: Pre carga de datos para pantalla de datos de datos de contacto cliente desactualizado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Cuando ingrese a la pantalla de datos de contacto en Cda.
    Entonces se pre cargarán los datos en la pantalla de datos de contacto.


