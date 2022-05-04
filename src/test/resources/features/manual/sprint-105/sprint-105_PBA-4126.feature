# language: es
@sprint:105
@issue:PBA-4126
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Reintentos de cargue de documentos por maquina de estados (sandbox) parte 2
  YO  como cliente cargando documentos
*Necesito* se reintente el envío de documentos al banco en caso de que fallen
  PARA  completar correctamente el proceso de apertura
Activación fallida en maquina de estados (sandbox) fase enviar
    Dado que  la fase iniciar fue exitosa
    Cuando  se inicie la fase enviar y sea fallida por la siguientes expresiones regulares 
({{1 "(.*Error calling api/create REST service:.*)" }}
{{2 "|(.*failed to create SFTP Session.*)" }}
{{3 "|(.*Initiate - El servicio no está disponible temporalmente. Por favor intenta más tarde..*)" }}
{{4 "|(.*The cause could not be determined because Lambda did not return an error type.*)" }}
{{5 "|(.*Error DPW, 1153711631. Failed to establish a backside connection.*)" }}
{{6 "|(.*ERROR-1:No se enviaron archivos de 680 - VoBo Jefe Inmediato AV Villas VIG:01 MES - Actividad economica '60'.*)" }}
{{7 "|(.*parece estar dañado.*)" }}
{{8 "|(.*no está permitida.*)" }}
{{9 "|(.*(resultBody).*(statusCode).*(500).*(body).*(\\{\\}).*)"}})
    Entonces  se reintentará el proceso cada 4 horas 3 veces por sesión.
Activación fallida en maquina de estados (sandbox) fase cargar
    Dado que  la fase enviar fue exitosa
    Cuando  se inicie la fase cargar y sea fallida por las siguientes expresiones regulares
{{1 *El codDocumental 254 no es válido para esta sesión.*)" }}
{{2 "|(.*El codDocumental 255 no es válido para esta sesión.*)" }}
{{3 "|(.*El codDocumental 256 no es válido para esta sesión.*)" }}
{{4 "|(.*está protegido para lectura, por favor intenta con otro.*}}
    Entonces  se reintentará el proceso cada 4 horas 3 veces por sesión.
*Nota:* Los reintentos se llevan acabo con un contador genérico para todas las fases de la maquina de estados.
Reintento exitoso en las fases de la maquina de estados
    Dado que  falló el proceso en alguna fase de la maquina de estados
    Cuando  se reintente exitosamente
    Entonces  se continuará con la siguiente fase o se finalizará el proceso de cargue de documentos (en el caso de la fase cargar).