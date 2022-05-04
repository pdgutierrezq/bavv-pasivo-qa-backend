# language: es
@sprint:106
@issue:PBA-3907
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cambios nómina digital parte 1
  YO  como cliente del banco AV Villas
*Necesito* poder abrir una cuenta de nómina con convenio en el banco
  PARA  que me paguen mi nómina.
 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-106
  Escenario: Redirección a pantalla de oferta de producto nómina*
    Dado que  estoy en la pantalla de PEP y no soy cliente PEP 
    Cuando  seleccione la opción para continuar
    Entonces  se redirecciona al usuario a la pantalla de oferta de nómina

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-106
  Escenario: Pantalla de oferta de producto nómina*
    Dado que  llegué a la pantalla de oferta de nómina
    Cuando  cargue la pantalla
    Entonces  aparecerá la información de nomina de acuerdo al mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-106
  Escenario: Redirección a pantalla de seguro*
    Dado que  estoy en la pantalla de oferta de nómina
    Cuando  seleccione la opción para continuar y no tengo seguro cuenta protegida
    Entonces  me redirecciona a la pantalla de oferta de seguro.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-106
  Escenario: Redirección a pantalla de autenticación*
    Dado que  estoy en la pantalla de oferta de nómina
    Cuando  seleccioné la opción para continuar y tengo seguro cuenta protegida
    Entonces  me redirecciona a la pantalla de autenticación.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-106
  Escenario: Titulo de “datos de tu empleador”*
    Dado que  llegué a la pantalla de datos de contacto y estoy abriendo una cuenta de nómina
    Cuando  cargue la pantalla
    Entonces  se mostrará el titulo de la segunda sección como “Datos de tu empleador“ de acuerdo al mockup.