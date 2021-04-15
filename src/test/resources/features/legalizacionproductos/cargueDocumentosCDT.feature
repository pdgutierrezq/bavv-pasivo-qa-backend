# language: es
@Frontend:CargueDocumentos
@Sprint-46
@PBA-1654

Característica:Dinamismo en pantalla de Cargue de documentos
  Yo como cliente des-actualizado
  Necesito que se me permita cargar los documentos según mi actividad económica
  Para que mi proceso de abrir CDT este mas completo

#  Escenario: Re dirección a firma por no cargue porque  el servicio no pide cédula, no es declarante y es independiente o estudiante u hogar.
#    Dado que se llamó el servicio iniciar exitosamente y el cliente es desactualizado
#    Cuando el servicio iniciar no pida cédula, el usuario no es declarante y su actividad económica es independiente o Estudiante u hogar.
#    Entonces se redirigirá a firma de documentos
#
  @developPending
  Escenario: Cargue de componente cédula
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y el servicio iniciar requiere cedula
    Entonces se mostrará el componente de opción de cargue de cédula en reverso y frontal.

#  Escenario: Cliente que haya seleccionado que es empleado
#    Dado que llego a pantalla de cargue de documentos
#    Cuando el usuario haya seleccionado que es empleado
#    Entonces se muestra componente de Cargue soporte ingresos empleado que incluye las siguientes opciones:
#  -Certificación laboral no mayor a 30 días
#  -Certificado de ingresos y retenciones
#  -3 últimos comprobantes de nomina.
#  -Declaración de renta.

#  Escenario: Cliente que haya seleccionado que es pensionado
#    Dado que llego a pantalla de cargue de documentos
#    Cuando el usuario haya seleccionado que es pensionado
#    Entonces se muestra componente de Cargue soporte ingresos pensionado que incluye las siguientes opciones:
#  -Resolución de liquidación
#  -Comprobantes de pensión
#  -Declaración de renta


#  Escenario: Cliente que haya seleccionado que es Estudiante o Hogar y es declarante
#    Dado que llego a pantalla de cargue de documentos
#    Cuando el usuario haya seleccionado que es estudiante u hogar y sea declarante
#    Entonces se muestra componente de Cargue soporte ingresos para Estudiante u Hogar que incluye las siguientes opciones:
#  -Certificación de ingresos
#  -Declaración de renta

#  Escenario: Cliente que haya seleccionado que es Independiente o independiente con negocio y es declarante
#    Dado que llego a pantalla de cargue de documentos
#    Cuando el usuario haya seleccionado que es independiente con o sin negocio y sea declarante
#    Entonces se muestra componente de Cargue soporte ingresos para Independiente o independiente con negocio que incluye las siguientes opciones:
#  -Estados financieros
#  -Declaración de renta
#  -Certificación de ingresos
#  -Contrato de prestación de servicios
#
#  Escenario: Cliente que haya seleccionado que es independiente con negocio
#    Dado que llego a pantalla de cargue de documentos
#    Cuando el usuario haya seleccionado que es independiente con negocio
#    Entonces se muestra componente de Cargue RUT o cámara y comercio para independiente con negocio.
