# language: es
@sprint:115
@issue:PBA-4426
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Enviar indicador resultado retoma cdt
  YO como* cliente
*Necesito* que se informe mi decisión de continuar con la retoma o no
  PARA  poder hacer la apertura de mi producto

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Á aperturando el producto de cdt con retoma
    Cuando  se muestre el Pop up y el cliente seleccione que si quiere continuar con la retoma
    Entonces  se le debe informar al back la decisión del cliente para que envíe en el campo AuthInd el valor “true” en RPP1

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Úa con retoma*
    Dado que  se está aperturando el producto de cdt  el cliente no continúa con retoma
    Cuando  se muestre el Pop up y el cliente seleccione que no quiere continuar con la retoma
    Entonces  se le debe informar al back la decisión del cliente para que envíe en el campo AuthInd el valor “false” en RPP1

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Á aperturando el producto de cdt sin retoma
    Cuando  continue después del formulario de identificación
    Entonces  debe continuar con la pantalla de pregunta PEP y se le debe enviar a back por defecto para que en el campo AuthInd el valor “false” en RPP1

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-115
  Escenario: Á aperturando el producto de cdt con o sin retoma
    Cuando  se realice el llamado a RPP2
    Entonces  debe envíar en el campo AuthInd el valor “false” por defecto
     #Nota: Confirmar que en back se esté recibiendo y enviando la información al banco.