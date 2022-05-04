# language: es
@sprint:24
@issue:PBA-164
@app:COMMONS
@functionality:Cliente.OTP
@screen:OTP
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Consumo de servicio de identificion de usuario
  YO COMO sistema
  NECESITO consumir el servicio de cargue de documentos iniciar
  PARA saber cuales documentos debo cargar dependiendo del cliente

  @testrail-id:516431
  Escenario: consumir servicio de identificacion de usuario de la celula habilitadora para validar otp con validacion exitosa
    Dado que tengo los datos necesarios para realizar la validacion
    Cuando realizo el cosumo del servicio
    Entonces obtengo informacion de validacion exitosa

  @testrail-id:516432
  Escenario: consumir servicio de identificacion de usuario de la celula habilitadora para validar otp con validacion errada por clave usada
    Dado que tengo los datos necesarios para realizar la validacion
    Cuando realizo el cosumo del servicio
    Entonces obtengo informacion de validacion errada por clave usada

  @testrail-id:516433
  Escenario: consumir servicio de identificacion de usuario de la celula habilitadora para validar otp con validacion errada por clave no coincidente
    Dado que tengo los datos necesarios para realizar la validacion
    Cuando realizo el cosumo del servicio
    Entonces obtengo informacion de validacion errada  por clave no coincidente
