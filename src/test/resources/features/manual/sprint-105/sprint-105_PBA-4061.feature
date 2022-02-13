# language: es
@sprint:105
@issue:PBA-4061
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Inicio apertura cuenta de nómina
  YO  como cliente del banco AV Villas
*Necesito* poder abrir una cuenta de nómina con convenio en el banco
  PARA  que me paguen mi nómina.
*Diferenciación de ingreso al flujo de nómina con convenio:* Incluir un parámetro en la URL para diferenciar el ingreso al flujo de cuenta digital,
    Cuando se vaya a abrir una cuenta de nómina digital. 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Pantalla identificación de usuario inicio del flujo nómina digital*
    Dado que  cargué la URL de nómina digital 
    Cuando  de click en la URL
    Entonces  llegué a la pantalla de identificación de usuario

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Pantalla identificación de usuario ajuste valor ingreso mensual*
    Dado que  di click en la URL de nómina digital
    Cuando   llegue a la pantalla de identificación de usuario
    Entonces  el campo de “Valor de tus ingresos mensuales” debe decir “Valor de tu salario mensual” como está en el mockup

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Inicio flujo cuenta digital*
    Dado que  cargué la URL de cuenta digital 
    Cuando  de click en la URL  
    Entonces  llegué al landing de Cuenta y Depósito Digital

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Pantalla identificación de usuario cuenta digital*
    Dado que  di click en la URL de cuenta digital
    Cuando  llegue a la pantalla de identificación de usuario
    Entonces  el campo de valor de tu ingreso mensual debe decir “Valor de tus ingresos mensuales”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-105
  Escenario: Recarga de pantalla nómina digital*
    Dado que  estoy en la pantalla de identificación de usuario de cuenta de nómina digital
    Cuando  recargue la pantalla 
    Entonces  debe cargar nuevamente la pantalla de identificación de usuario de nómina digital