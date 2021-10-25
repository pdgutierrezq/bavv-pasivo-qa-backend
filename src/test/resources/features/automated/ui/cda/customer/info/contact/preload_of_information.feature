# language: es
@sprint:59
@issue:PBA-2326
@app:CDA
@functionality:Cliente.Info.De_contacto.Precarga_de_informacion
@screen:datos_personales
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Pre carga de información para datos básicos CDA
  YO COMO Cliente no actualizado
  NECESITO que me muestre la información que tiene CRM del banco
  PARA mejorar mi experiencia

  @testrail-id:515716
  Escenario: Pre carga de datos para pantalla de datos de datos de contacto cliente desactualizado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Cuando ingrese a la pantalla de datos de contacto en Cda.
    Entonces se pre cargarán los datos en la pantalla de datos de contacto.


