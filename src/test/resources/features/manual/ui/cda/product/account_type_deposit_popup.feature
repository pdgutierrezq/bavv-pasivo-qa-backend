# language: es
@sprint:96
@issue:PBA-3806
@app:CDA
@functionality:Producto.Popup.Deposito
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Pop up deposito pantalla oferta de productos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519045
  Escenario: Pop-up de 4x Mil en seccion de deposito digital
    Dado que estoy en la pantalla de ofrecimiento de cuentas
    Cuando  seleccione la opción para saber que es el 4 x mil en la sección de deposito digital
    Entonces  se mostrará POP Up de que es 4 x mil de acuerdo a mock up
     #“
     #* Si lo deseas, puedes marcar este producto como el único exento del 4x1000 en el sector financiero.
     #* En caso de tener otra cuenta exenta en otro banco, debes realizar la demarcación con ellos.”
     #

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519046
  Escenario: Boton de cerrar o entendido del pop up 4 x mil en seccion de deposito digital
    Dado que estoy en la pantalla de ofrecimiento de cuentas
    Y seleccione la opción para saber que es el 4 x mil en la sección de deposito digital
    Cuando cierro el popup
    Entonces  se deja al usuario en la pantalla de oferta de productos

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519047
  Escenario: Actualización texto en pantalla de oferta de producto
    Dado que estoy en la pantalla de ofrecimiento de cuentas
    Cuando carga la pantalla
    Entonces se muestra el siguiente texto en la caja de deposito digital
     #"Puedes tener saldo máximo y retiros mensuales hasta $7.268.208 (8 SMMLV)."
