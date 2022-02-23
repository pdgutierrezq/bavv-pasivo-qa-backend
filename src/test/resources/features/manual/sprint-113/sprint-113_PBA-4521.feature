# language: es
@sprint:113
@issue:PBA-4521
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Ajuste habeas data cda
  YO como* CRM
*Necesito* que se envíe exitosamente la marca de habeas data 
  PARA  guardar la información de manera exitosa

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-113
  Escenario: Envío en actualizar crm*
    Dado que  el cliente marcó en el formulario de identificación el check de autorización tratamiento de datos
    Cuando  se envíe la información de actualizar CRM
    Entonces  se debe enviar el campo HabeasDataInd en “S” para todos los tipos de cliente (actualizado, no actualizado y nuevo)
     #Nota: No se debe tener en cuenta la información que traiga el servicio de consultar CRM
     #Nota: El ajuste debe quedar realizado para Cuenta Digital, Nómina Digital y Depósito Digital.