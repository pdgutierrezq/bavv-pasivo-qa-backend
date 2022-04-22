# language: es
@issue:PBA-4833
@sprint:119
@app:CDT
@functionality:PopUp.Retoma.PSE
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Pop up retomas pse por medio de la consulta inicial de parametros
  Yo como negocio
  Quiero que se realice una consulta a los parámetros de la aplicación
  Para conocer que se debe mostrar en el flujo si retoma apagado o encendido

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-119
  Escenario: Validar parámetros de la aplicación
    Dado que se requiere validar los parámetros de la aplicación
    Cuando el cliente ingrese a la landing
    Entonces se debe realizar una consulta inicial a los parámetros de la aplicación para ver cuál es la configuración de retoma

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-119
  Escenario: Parámetro de retoma encendido
    Dado que se realizó la validación de los parámetros de la aplicación
    Cuando esté el parámetro de retoma encendido y si el cliente cuenta con una retoma
    Entonces se debe mostrar el Pop up preguntándole si desea continuar con la retoma o no

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-119
  Escenario: Parámetro de retoma apagado o no tiene retoma
    Dado que se realizó la validación de los parámetros de la aplicación
    Cuando esté el parámetro de retoma apagado o el cliente no tiene retoma
    Entonces no se debe mostrar el Pop up preguntándole si desea continuar con la retoma o no

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-119
  Escenario: Falla en la consulta de parámetros
    Dado que se requiere validar los parámetros de la aplicación y se presentó una falla
    Cuando el cliente ingrese a la landing
    Entonces debe estar la funcionalidad de retoma por defecto en false y no debe mostrar el pop up preguntándole si desea continuar con la retoma o no
