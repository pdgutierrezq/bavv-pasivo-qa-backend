# language: es
#@run
@sprint:63
@issue:PBA-510
@app:CDT
@functionality:Validacion_de_enrolamiento
@layer:frontend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consumo de servicio para saber si un usuario esta enrolado CDT
  YO COMO cliente finalizando el flujo de CDT
  NECESITO que se consuma el servicio de clientes en SDS (enrolado en canales)
  PARA que saber si tengo o no canales

  @testrail-id:510252
  Escenario: Re-dirección cliente no enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
    Cuando el usuario inicie el proceso de firma
    Entonces redirecciona a pantalla de "enrolamiento de canales"

  @testrail-id:510253
  Escenario: Re-dirección cliente enrolado
    Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
    Cuando el usuario inicie el proceso de firma
    Entonces redirecciona a pantalla de "tips de ahorro"
