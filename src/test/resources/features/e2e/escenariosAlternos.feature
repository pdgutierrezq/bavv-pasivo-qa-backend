# language: es
@Frontend:E2E-EscenariosAlternos


Característica: Creacion cuenta de ahorros escenarios alternos
  YO COMO  cliente
  NECESITO abrir una cuenta de ahorros digital
  PARA tener acceso a una cuenta de ahorros digital

  @e2eRun
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado con seguro
    Dado el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "true"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el usuario diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y "acepto " el beneficio de excencion de gmf
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta
  @construcciond

  Escenario: Creacion cuenta de ahorros pro con cliente no actualizado enrolado
    Dado el usuario con condiciones cliente "true" actualizado "false" canales "false" y cuenta cat "false"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Y Selecciono que "no" es PEP
    Y selecciona el producto "cuenta pro"
    Y "acepto " el beneficio de excencion de gmf
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y selecciona actividad economica
    Y diligenciar datos de contacto
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta
  @construcciond
  Escenario: Creacion cuenta de ahorros pro con cliente no actualizado enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "false" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y Selecciono que "no" es PEP
    Y selecciona el producto "cuenta simple"
    Y "acepto " el beneficio de excencion de gmf
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y selecciona actividad economica
    Y diligenciar datos de contacto
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta
#escenarios alternos

  @construccions
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado  sin seguro enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y "acepto " el beneficio de excencion de gmf
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construccions
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado con seguro
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construcciond
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construccions
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construcciond
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y Selecciono que "no" es PEP
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta



  @construcciond
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado enrolado
#    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
#    Cuando el usuario con condiciones cliente "true" actualizado "true" canales "false" y cuenta cat "false", diligencia el formulario de identificacion de usuario
    Y Selecciono que "no" es PEP
    Y selecciona el producto "cuenta pro"
    Y "acepto " el beneficio de excencion de gmf
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta
