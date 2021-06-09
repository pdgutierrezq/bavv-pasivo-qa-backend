  # language: es
  @Frontend:validacionDeEnrolamiento
  @Sprint-62
  @PBA-510
  @CDT
  @regresion

  Característica: Consumo de servicio para saber si un usuario esta enrolado CDT

    YO COMO cliente finalizando el flujo de CDT
    NECESITO que se consuma el servicio de clientes en SDS (enrolado en canales)
    PARA que saber si tengo o no canales
@wwwP
    Escenario: Re-dirección cliente no enrolado
      Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo no enrolado con renovacion"
      Cuando el usuario inicie el proceso de firma
      Entonces redirecciona a pantalla de "enrolamiento de canales"

    Escenario: Re-dirección cliente enrolado
      Dado que se obtiene un usuario tipo "cliente actualizado con cuenta para fondeo enrolado sin renovacion"
      Cuando el usuario inicie el proceso de firma
      Entonces redirecciona a pantalla de "tips de ahorro"
