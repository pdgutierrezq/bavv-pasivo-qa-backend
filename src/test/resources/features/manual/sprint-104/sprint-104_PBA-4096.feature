# language: es
@sprint:104
@issue:PBA-4096
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Reintentos de cargue de documentos por maquina de estados (sandbox) parte 1
  YO  como cliente cargando documentos
*Necesito* se reintente el envío de documentos al banco en caso de que fallen
  PARA  completar correctamente el proceso de apertura
 
Llamado de finantial document message handler
    Dado que  el usuario cargó documentos
    Cuando  se seleccione la opción para continuar 
    Entonces  se llamará el servicio para remitir el mensaje en la cola SQS y activar la maquina de estados (sandbox)
Llamado de finantial document message handler exitoso
    Dado que  el usuario cargó documentos y seleccionó la opción para continuar 
    Cuando  se llame le servicio que remite el mensaje en la cola SQS para activar la maquina de estados (sandbox) y sea exitoso
    Entonces  el cliente continuará con el flujo a pantalla de firma 
Llamado de finantial document message handler fallido
    Dado que  el usuario cargó documentos y seleccionó la opción para continuar 
    Cuando  se llame el servicio que remite el mensaje en la cola SQS para activar la maquina de estados (sandbox) y sea fallido
    Entonces  el cliente continuará con el flujo al pop up de cargue fallido
Activación exitosa de maquina de estados (sandbox)
    Dado que  se llamó el servicio que remite el mensaje en la cola SQS para activar la maquina de estados (sandbox) y fue exitoso
    Cuando  se active la maquina de estados y sea exitoso el proceso
    Entonces  el flujo continuará exitosamente dejando la respectiva mensajería exitosa.
Activación fallida en maquina de estados (sandbox) fase iniciar
    Dado que  se llamó el servicio que remite el mensaje en la cola SQS para activar la maquina de estados (sandbox) y fue exitoso
    Cuando  se active la maquina de estados y la fase iniciar sea fallida por la siguiente expresión regular (
{{1. El servicio no está disponible temporalmente. Por favor intenta más tarde..}}
2. {{"|(.*(resultBody).*(statusCode).*(500).*(body).*(\\{\\}).*)"}})
    Entonces  se reintentará el proceso cada 4 horas un máximo 3 veces por sesión.
Reintento exitoso en las fases de la maquina de estados
    Dado que  falló el proceso en alguna fase de la maquina de estados
    Cuando  se reintente exitosamente
    Entonces  se continuará con la siguiente fase o se finalizará el proceso de cargue de documentos (en el caso de la fase cargar).