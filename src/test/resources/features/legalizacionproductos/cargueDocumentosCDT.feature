# language: es
@Frontend:CargueDocumentos
@Sprint-46
@PBA-1654
@regresion

Característica:Dinamismo en pantalla de Cargue de documentos
  Yo como cliente des-actualizado
  Necesito que se me permita cargar los documentos según mi actividad económica
  Para que mi proceso de abrir CDT este mas completo

  @www
  Esquema del escenario: Re dirección a firma por no cargue porque  el servicio no pide cédula, no es declarante y es independiente o estudiante u hogar.
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "<Actividad economica>" no sea declarante no requiere cedula
    Entonces se redirigirá a firma de documentos
    Ejemplos:
      | Actividad economica |
      | independiente       |
#      | estudiante          |
#      | hogar               |
#
#  @developPending
#  Escenario: Cargue de componente cédula
#    Dado que se obtiene un usuario tipo "cliente no actualizado"
#    Dado que llego a pantalla de cargue de documentos y el servicio iniciar requiere cedula
#    Entonces se mostrará el componente de opción de cargue de cédula en reverso y frontal.

  Escenario: Cliente que haya seleccionado que es empleado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "empleado"
    Entonces se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:
      | Certificación laboral no mayor a 30 días |
      | Certificación de ingresos                |
      | 3 últimos comprobantes de nómina         |
      | Declaración de renta                     |

  Escenario: Cliente que haya seleccionado que es pensionado
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "pensionado"
    Entonces se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:
      | Resolución de liquidación         |
      | 2 últimos comprobantes de pensión |
      | Declaración de renta              |

  Esquema del escenario: Cliente que haya seleccionado que es Estudiante o Hogar y es declarante
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "<Actividad economica>" y sea declarante
    Entonces se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:
      | Certificación de ingresos |
      | Declaración de renta      |
    Ejemplos:
      | Actividad economica |
      | estudiante          |
      | hogar               |

  Esquema del escenario: Cliente que haya seleccionado que es Independiente o independiente con negocio y es declarante
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "<Actividad economica>" y sea declarante
    Entonces se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:
      | Estados financieros                 |
      | Declaración de renta                |
      | Certificación de ingresos           |
      | Contrato de prestación de servicios |
    Ejemplos:
      | Actividad economica       |
      | independiente             |
      | independiente con negocio |


  Escenario: Cliente que haya seleccionado que es independiente con negocio
    Dado que se obtiene un usuario tipo "cliente no actualizado"
    Dado que llego a pantalla de cargue de documentos y haya seleccionado que es "independiente con negocio"
    Entonces se muestra componente de Cargue decodumentos para  independiente que incluye las siguientes opciones:
      | Cámara y comercio |
      | RUT               |
