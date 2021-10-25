# language: es
@sprint:95
@issue:PBA-3751
@app:CDA
@functionality:Producto.Deposito_Digital.4x1000
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Deposito digital execta de 4 x mil
  YO Cliente abriendo un deposito digital
  QUIERO que se me marque o no mi deposito con exención del 4 x mil
  PARA  que goce de este beneficio o no

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515690
  Escenario: Seleccion 4 x Mil en pantalla de tarjeta debito
    Dado que  Estoy en la pantalla de firma, seleccioné abrir un deposito digital y elegí 4 x mil
    Cuando  se llame al websocket 2
    Entonces  debo notificar en el campo GMF que elegí exención 4 x mil

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-95
  @testrail-id:515691
  Escenario: NO Seleccion 4 x Mil en pantalla de tarjeta debito
    Dado que  Estoy en la pantalla de firma, seleccioné abrir un deposito digital  y no elegí 4 x mil
    Cuando  se llame al websocket 2
    Entonces  debo notificar en el campo GMF que no elegí exención 4 x mil
     #Nota: En el websocket 1 enviar en el campo GMF que no se selecciona el 4 x mil
