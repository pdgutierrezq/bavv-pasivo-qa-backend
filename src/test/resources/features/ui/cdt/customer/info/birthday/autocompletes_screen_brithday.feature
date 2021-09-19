# language: es
@sprint:58
@issue:PBA-1291
@app:CDT
@functionality:Cliente.Info.Fecha_de_Nacimiento.Autocompletes
@screen:datos_personales
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: CDT Pantalla de Fecha de Nacimiento y Genero
  YO COMO  no cliente del BAVV
  NECESITO diligenciar un formulario
  PARA determinar mis datos personales

  Escenario: Autocomplete y dropdown de ciudad de nacimiento
    Dado que se obtiene un usuario tipo "no cliente no actualizado que no tenga canales"
    Y que estoy en pantalla donde ingreso mis datos personales.
    Cuando de click en el campo de Ciudad de nacimiento.
    Entonces se desplegará el listado de las ciudades o municipios de Colombia que coincida con el listado

  Escenario:Autocomplete y dropdown de ciudad de expedición
    Dado que se obtiene un usuario tipo "no cliente no actualizado que no tenga canales"
    Y que estoy en pantalla donde ingreso mis datos personales.
    Cuando de click en el campo de Ciudad de la expedición de la cédula
    Entonces se desplegará el listado de las ciudades o municipios de Colombia que coincida con el listado
