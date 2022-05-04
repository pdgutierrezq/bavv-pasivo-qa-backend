# language: es
@sprint:83
@issue:PBA-2578
@app:COMMONS
@functionality:Banco.Enrolamiento.LLave_Publica
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Llamado al servicio de llave de enrolamiento
  YO COMO sistema
  NECESITO consumir el servicio get public key
  PARA poder cifrar la clave de enrolamiento

  @testrail-id:516424
  Escenario: Consumo del servicio de get public key
    Dado que el cliente está en la pantalla de enrolamiento
    Cuando seleccione la opción para continuar
    Entonces se llama al servicio de get public key
