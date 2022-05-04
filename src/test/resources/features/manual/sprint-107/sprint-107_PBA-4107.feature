# language: es
@sprint:107
@issue:PBA-4107
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Cambios nómina digital parte 2
  YO  como cliente del banco AV Villas
  *Necesito* poder abrir una cuenta de nómina con convenio en el banco
  PARA  que me paguen mi nómina.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Redirección y validación de pantallas cliente actualizado*
    Dado que  estoy en la pantalla de autenticación y estoy abriendo una cuenta de nómina
    Cuando  sea exitosa la autenticación y sea un cliente actualizado
    Entonces  me redirecciona a la pantalla de Tarjeta Débito (con la tarjeta negra)
     #*Posterior a esta, siguen las siguientes pantallas para cliente actualizado:* Declarante de renta/ firma electrónica/ enrolamiento si no está enrolado, si lo está pasa a tips de ahorro/ Resumen
     #Link invision nómina: [https://projects.invisionapp.com/share/X2118UR33RD8#/screens/454217275|https://projects.invisionapp.com/share/X2118UR33RD8#/screens/454217275|smart-link]

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Redirección y validación de pantallas cliente desactualizado*
    Dado que  estoy en la pantalla de autenticación y estoy abriendo una cuenta de nómina
    Cuando sea exitosa la autenticación y sea un cliente desactualizado
    Entonces  me redirecciona a la pantalla de datos de contacto.
     #*Posterior a esta, siguen las siguientes pantallas para cliente desactualizado:* datos complementarios del extranjero/ datos financieros/ si realiza operaciones en moneda extranjera va a transacciones en moneda extranjera, si no pasa a Tarjeta Débito (Con la tarjeta negra)/ Declarante de renta/ no carga documentos: ni cédula ni de ingresos (a no ser que la cédula esté desactualizada)/ firma electrónica/ si no está enrolado pasa a enrolamiento, si está enrolado pasa a tips de ahorro/ Resumen

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Redirección y validación de pantallas cliente nuevo*
    Dado que  estoy en la pantalla de autenticación y estoy abriendo una cuenta de nómina
    Cuando  sea exitosa la autenticación y sea un cliente nuevo
    Entonces  me redirecciona a la pantalla de datos personales
     #*Posterior a esta, siguen las siguientes pantallas para cliente nuevo:* datos de contacto/ datos complementarios del extranjero/ datos financieros/ si realiza operaciones en moneda extranjera va a transacciones en moneda extranjera, si no pasa a Tarjeta Débito (Con la tarjeta negra)/ Declarante de renta/ cargue de cédula/ firma electrónica/ enrolamiento o tips de ahorro/ Resumen

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Cargue de documentos en el flujo de nómina*
    Dado que  me encuentro en el flujo de nómina y soy un cliente nuevo o desactualizado
    Cuando  se requiera el cargue de mi cédula de acuerdo al servicio (Get documents to charge)
    Entonces  me redireccionarán a la pantalla de cargue de documentos y solo me pedirán cargar la parte frontal y reverso de la cédula de ciudadanía.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: No cargue de documentos en el flujo de nómina*
    Dado que  me encuentro en el flujo de nómina y soy un cliente nuevo o desactualizado
    Cuando  no se requiera el cargue de mi cédula de acuerdo al servicio (Get documents to charge)
    Entonces   me redireccionarán a firma.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Pantalla de resumen*
    Dado que  llegué a la pantalla de resumen y estoy abriendo una cuenta de nómina
    Cuando  cargue la pantalla
    Entonces  se mostrará la pantalla de acuerdo al mockup

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Descarga de resumen de cuenta de nómina*
    Dado que  estoy en el resumen de cuenta de nómina
    Cuando  seleccione la opción para descargar el resumen
    Entonces  se descarga con el diseño de acuerdo al mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-107
  Escenario: Omisión de pantalla de actividad económica cliente nuevo*
    Dado que  estoy abriendo una cuenta de nomina y soy un cliente nuevo
    Cuando  este diligenciando los formularios de datos personales y seleccione la opción para continuar
    Entonces  me redirecciona a la pantalla de datos de contacto
