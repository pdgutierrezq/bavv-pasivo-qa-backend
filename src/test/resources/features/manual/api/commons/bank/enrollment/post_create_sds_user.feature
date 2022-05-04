# language: es
@sprint:51
@issue:PBA-1555
@app:COMMONS
@functionality:Banco.Enrolamiento
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Llamado pare enrolar cliente
  YO COMO sistema
  NECESITO poder enrolar clientes
  PARA hacer el proceso de autenticacion mas seguro

  @testrail-id:516423
  Escenario: Consumo del servicio de enrolamiento
    Dado que el cliente está en la pantalla de enrolamiento
    Cuando seleccione la opción para continuar
    Entonces se llama al servicio de enrolar cliene create-sds-user
