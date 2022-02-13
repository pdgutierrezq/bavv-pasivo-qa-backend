# language: es
@sprint:110
@issue:PBA-4278
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Modificar pantalla extensión pdf en cédula cda
  YO como* usuario en el flujo de Cuenta
*Necesito* que se me informen las extensiones permitidas
  PARA  poder realizar el cargue de la cédula

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: Modificar pantalla a .pdf*
    Dado que  soy usuario que requiere la cédula 
    Cuando  estoy en la pantalla de cargue de cédula
    Entonces  se muestran las extensiones permitidas para el cargue de cédula de acuerdo a mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: No mostrar la sección de cargue de cédula*
    Dado que  soy usuario que no requiere la cédula 
    Cuando  pase la pantalla de declarante  
    Entonces  no se muestra la sección de cargue de cédula y continua el flujo de acuerdo con el proceso actual (cargue de documentos financieros (si aplica de acuerdo al mockup) o pantalla de firma electrónica de documentos).

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-110
  Escenario: Mostrar la pantalla con cargue de cédula y soportes financieros*
    Dado que  soy usuario nuevo 
    Cuando  pase la pantalla de declarante  
    Entonces  se muestra en la pantalla la sección de cargue de cédula y cargue de documentos financieros (de acuerdo al mockup)