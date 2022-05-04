# language: es
@sprint:96
@issue:PBA-3797
@app:CDA
@functionality:Producto.Cuenta_Digital
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Cuenta digital pantalla de tarjeta debito

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519038
  Escenario: Pantalla de tarjeta debito para CUENTA DIGITAL
    Dado que el cliente llegó a la pantalla de “tarjeta debito” y seleccionó cuenta digital
    Cuando  cargue la pantalla
    Entonces  cargará la pantalla con la tarjeta debito negra de acuerdo al mock up y el texto de 4 x mil será “
     #  QUIERO que mi cuenta de ahorros esté exenta del 4x1000. (Sólo puedes tener una cuenta/depósito exento en el sector financiero) ¿Qué es?.“ de acuerdo al mock up.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519039
  Escenario: Pantalla de tarjeta debito para DEPOSITO DIGITAL
    Dado que el cliente llegó a la pantalla de “tarjeta debito” y seleccionó deposito digital
    Cuando  cargue la pantalla
    Entonces  cargará la pantalla con la tarjeta debito roja y el texto de 4 x mil será “
     #  QUIERO que mi depósito digital esté exento del 4x1000 (Sólo puedes tener una cuenta/depósito exento en el sector financiero) ¿Qué es?.“ de acuerdo al mock up.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519040
  Escenario: Popup 4 x mil para DEPOSITO DIGITAL
    Dado que estoy en la pantalla de tarjeta debito y seleccioné abrir deposito digital
    Cuando  seleccione la opción de Ver mas para saber que es el 4 x mil
    Entonces  se mostrará POP Up de que es 4 x mil de acuerdo a mock up
     #“ Es un impuesto creado sobre los movimientos financieros en el que por cada $1.000 pesos se pagan $4 pesos al Gobierno. 
     #El Depósito Digital está exento del 4x1.000 hasta 65 UVT ($2.360.020) así tengas otra cuenta marcada con esta exención. También puedes marcarlo como única cuenta exenta en todo el sector financiero, pero en este caso, si tienes otra cuenta exenta en otro banco debes desmarcarla con ellos.” de acuerdo al mock up.
     #

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519041
  Escenario: Cierre de Popup 4 x mil para DEPOSITO DIGITAL
    Dado que  Estoy en el POP up de 4 x mil de deposito digital
    Cuando  seleccione la opción para cerrar o entendido del POP Up 4 x mil
    Entonces  se deja al usuario en la pantalla de  tarjeta debito (con la tarjeta roja).

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519042
  Escenario: NO Cliente o Cliente desactualizado redireccion a pantalla tarjeta debito para DEPOSITO DIGITAL
    Dado que soy un cliente desactualizado o no cliente, estoy en pantalla de datos de contacto y seleccioné deposito digital
    Cuando  seleccione la opción para continuar
    Entonces  me redireccionarán a la pantalla de tarjeta debito
     #*3.Pantalla de resumen*

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519043
  Escenario: Pantalla de resumen para DEPOSITO DIGITAL
    Dado que llegué a la pantalla de resumen y abrí un deposito digital
    Cuando  cargue la pantalla
    Entonces  se mostrará la siguiente información de acuerdo al mock up
     #“¡Felicitaciones Manuel\! 
     #Te presentamos el resumen de los productos que elegiste: 
     #*Depósito Digital* No. 1223676567 
     #-Sin cuota de manejo y dos retiros gratis si mantienes un saldo promedio de $500.000 al mes, de lo contrario, la cuota de manejo es de $3.490 y un retiro gratis. 
     #* Transferencias gratis a través de nuestros Canales Digitales.
     #A partir de ahora podrás empezar a consultar tus productos en nuestros canales digitales. FINALIZAR
     #” de acuerdo al mock up.
     #*4. Cargue de documentos*

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519044
  Escenario: Cargue de documentos para DEPOSITO DIGITAL
    Dado que estoy en la pantalla de declarante , abrí un deposito digital y soy un cliente desactualizado,actualizado o no cliente
    Cuando  seleccione la opción para continuar y crm haya sido exitoso
    Entonces  se redirecciona al usuario a firma electronica ( no pasa por cargue)
