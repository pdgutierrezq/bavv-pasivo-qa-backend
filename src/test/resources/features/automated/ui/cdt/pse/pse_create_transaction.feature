# language: es
@sprint:62
@issue:PBA-2349
@app:CDT
@functionality:PSE.Transacción.Crear
@screen:PSE
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Creacion transaccion PSE
  YO como usuario definiendo desde donde voy a fondear mi CDT
  QUIERO que se redirija al proceso de PSE
  PARA fondear mi CDT

  @testrail-id:515744
  Escenario: Crear transacción de PSE exitosamente
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando se crea la transacción PSE de forma exitosa
    Entonces se envía al cliente a la URL de "PSE externa"

