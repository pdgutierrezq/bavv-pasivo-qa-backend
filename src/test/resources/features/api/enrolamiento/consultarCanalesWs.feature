# language: es
@sprint:19
@issue:PBA-711
@app:COMMONS
@feature:Canales
@screen:Firma_electronica
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consumo de servicio para saber si un usuario esta enrolado
  YO COMO cliente finalizando el flujo
  NECESITO que se consuma el servicio de clientes en canales
  PARA que saber si tengo o no canales

  @testrail-id:510589
  Esquema del escenario: consulta cliente enrolado, <cliente>
    Dado que se obtiene un usuario tipo "<cliente>"
    Cuando el usuario consulta si tiene canales
    Entonces se validara que el usuario "<canales>" canales
    Ejemplos:
      | cliente             | canales  |
      | cliente con canales | tiene    |
      | cliente sin canales | no tiene |
