# language: es
@sprint:60
@issue:PBA-2182
@app:CDT
@functionality:datos_personales
@screen:datos_de_contacto
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Implementar Precarga de info a cliente des actualizado CDT
  YO COMO Cliente
  NECESITO que me muestre la información que tiene CRM del banco
  PARA mejorar mi experiencia

  @testrail-id:510248
  Escenario: Pre carga de datos para pantalla de datos de contacto
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Y que hay información del usuario en el banco
    Cuando ingrese a la pantalla de datos de contacto o información financiera.
    Entonces se pre cargarán los datos en la pantalla.
