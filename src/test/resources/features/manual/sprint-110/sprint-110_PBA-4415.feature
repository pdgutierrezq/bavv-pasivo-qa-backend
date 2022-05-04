# language: es
@sprint:110
@issue:PBA-4415
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Corrección tipo de extensión cédula permitiendo pdf cdt
  YO como* Cliente
*Necesito* cargar mi cédula en formato pdf
  PARA  enviar mis documentos al Banco

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: Permitir cargue en formato pdf*
    Dado que  el cliente requiere realizar el cargue de la cédula
    Cuando  esté en la pantalla de cargue de cédula
    Entonces  debe permitir el cargue del documento en extensión .PDF que no tenga un peso ma  YO r a 3 MB

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: Permitir cargue en formatos actuales*
    Dado que  el cliente requiere realizar el cargue de la cédula
    Cuando  esté en la pantalla de cargue de cédula
    Entonces  debe permitir el cargue del documento en extensiones .JPG o .PNG que no tengan un peso ma  YO r a 3MB

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: Permitir cargue en formatos diferentes*
    Dado que  el cliente requiere realizar el cargue de la cédula
    Cuando  esté en la pantalla de cargue de cédula
    Entonces  no debe permitir el cargue del documento en extensiones diferentes a .PDF, .JPG, .PNG y debe mostrar el mensaje de error actual “No es posible adjuntar la cédula en este formato, intenta en formato .PDF, .JPG, .PNG“