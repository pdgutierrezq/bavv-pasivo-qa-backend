# language: es
@sprint:95
@issue:PBA-3645
@app:CDA
@functionality:Producto.Deposito_Digital
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Deposito digital

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515684
  Escenario: Ofrecimiento de deposito de bajo monto y cuenta digital sugiriendo deposito.
    Dado que el usuario esta en la pantalla de ofrecimiento de cuentas
    Y los ingresos digitados son menores a <1.500.000  y no tiene cuenta CAT
    Cuando  cargue la pantalla de ofrecimiento de cuenta
    Entonces  debe mostrar cuenta Digital y Deposito de bajo monto pero recomendando el deposito de bajo monto en lado izquierdo de la pantalla según mock.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515685
  Escenario: Ofrecimiento de deposito de bajo monto y cuenta digital sugiriendo cuenta digital
    Dado que el usuario esta en la pantalla de ofrecimiento de cuentas
  Y los ingresos digitados son ma  YO res o iguales a >=1.500.000  y no tiene cuenta CAT
    Cuando  cargue la pantalla de ofrecimiento de cuenta
    Entonces  debe mostrar Deposito de bajo monto y Cuenta Digital pero recomendando la cuenta Digital en lado izquierdo de la pantalla según mock.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515686
  Escenario: Ofrecimiento de solo cuenta digital por que el usuario tiene una cat
    Dado que el usuario esta la pantalla de ofrecimiento de cuentas y ya tiene una cuenta CAT en el banco
    Cuando  se carga la pantalla de ofrecimiento de cuenta
    Entonces  debe mostrar Deposito de bajo monto y Cuenta Digital pero recomendando la cuenta Digital en lado izquierdo de la pantalla y inhabilitando el deposito de bajo monto según mock.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515687
  Escenario: Redirección a pantalla de otp
    Dado que el cliente está en pantalla “Ofrecimiento de cuentas”, seleccionó cuenta Digital o Deposito de bajo monto y tiene seguro
    Cuando  de click para continuar
    Entonces  pasa a pantalla *“*OTP”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515688
  Escenario: Redirección a pantalla de oferta de seguro
    Dado que el cliente esta en pantalla “Ofrecimiento de cuentas”, seleccionó Cuenta digital o deposito de bajo monto y no tiene seguro
    Cuando  de click en continuar
    Entonces  pasa a pantalla *“*Oferta y aceptación de seguro”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515689
  Escenario: Actualización pantalla de oferta de productos
    Dado que el cliente esta en pantalla “PEP”, No es PEP y seleccionó la opción para continuar
    Cuando  llegué a pantalla de ofrecimiento de cuentas
    Entonces  cargará la pantalla con la siguiente información
     #“*Con tu Cuenta o Depósito Digital puedes:* 
     #-Hacer transacciones en nuestros canales digitales sin costo. 
     #-Realizar transferencias a otros bancos gratis a través de AV Villas App y Banca Virtual. 
     #-Tener cuota de manejo $0 y 2 retiros gratis si mantienes saldo promedio de $500.000 al mes, de lo contrario será $3.490 y un retiro gratis en la Red Aval.“ de acuerdo al mock up.
     #Cuenta Digital 
     #-Ábrela con tu cédula y un documento que soporte tus ingresos. 
     #-Realiza compras, pagos, retiros, depósitos y mucho más a cualquier hora y desde cualquier lugar. 
     #-Exonera tu cuenta del 4xmil.
     #Depósito Digital
     #- Ábrelo rápido y sin documentos. 
     #- Puedes tener saldo máximo y retiros mensuales de hasta $7.268.208 (8 SMLV). 
     #- Tus transacciones están exoneradas del 4xmil hasta $2.360.020 (65 UVT) Ver más. “
