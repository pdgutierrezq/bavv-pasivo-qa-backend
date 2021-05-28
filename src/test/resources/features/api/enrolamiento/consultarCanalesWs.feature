 # language: es
 @Backend:consultaCanales
 @BackendBooth

 @Sprint-19
 @PBA-711
 @regresion

 Característica: Consumo de servicio para saber si un usuario esta enrolado

   YO COMO cliente finalizando el flujo
   NECESITO que se consuma el servicio de clientes en canales
   PARA que saber si tengo o no canales

   Esquema del escenario: consulta cliente enrolado
     Dado que se obtiene un usuario tipo "<cliente>"
     Cuando el usuario consulta si tiene canales
     Entonces se validara que el usuario "<canales>" canales
Ejemplos:
     |cliente|canales|
     |cliente con canales|tiene|
     |cliente sin canales|no tiene|
