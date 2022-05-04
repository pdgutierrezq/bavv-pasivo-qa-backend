# language: es
@sprint:103
@issue:PBA-4008
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cambios en pantalla cargue de documentos cda y cdt

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-103
  Escenario: Modificar el titulo de la pantalla*
     #Antes: “Adjunta los siguientes documentos:“
     #*Ahora:* “Adjunta tus documentos:”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-103
  Escenario: Cambiar la frase posterior al cargue de cédula*
     #Antes: “Coloca el documento en posición vertical sobre un fondo blanco, apaga el flash y toma la foto con tu celular. 12:48 Sube archivos con formato PDF, JPG o PNG que no tengan un peso ma  YO r a 3 MB. Ten en cuenta que no se vean brillos o sombras y que la información sea legible.”
     #*Ahora:*  “1) Carga por se
     #  PARA do la parte frontal y el reverso de tu cédula (no admite PDF). Si le vas a tomar una foto, ponla en posición horizontal y apaga el flash.”
     #De acuerdo al Mock Up.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-103
  Escenario: Cambiar la frase posterior al cargue de soportes financieros*
     #Antes: “1. Sube archivoscon formato PDF, JPG o PNG que no tengan un peso ma  YO r a 3 MB
     #2. Verifica que el documento no tenga clave”
     #*Ahora:*  “2) Sube archivos con formato PDF, JPG o PNG que no tengan un peso ma  YO r a 3 MB. (Verifica que le documento no tenga clave).“ 
     #De acuerdo al Mock Up.