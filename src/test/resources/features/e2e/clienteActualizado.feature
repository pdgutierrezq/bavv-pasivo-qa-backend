# language: es
@Frontend:E2E-ClienteActualizado

Característica: Creacion cuenta de ahorros cliente actualizado
  YO COMO  cliente actualizado
  NECESITO abrir una cuenta de ahorros digital
  PARA tener acceso a una cuenta de ahorros digital

  @e2e
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado con seguro
    Dado que se obtiene un usuario tipo "cliente actualizado sin lista restrictiva con cuenta cat y que tenga canales"
    Cuando el usuario realiza el flujo con "cuenta pro" y "acepta" el seguro
    Entonces se muestra el resumen de la creacion de la cuenta


  Escenario: Creacion cuenta de ahorros pro con cliente actualizado con seguro
    Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" cuenta cat "false" y canales "false"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el usuario diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y "acepta" el beneficio de excencion de gmf
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no modifica" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  Escenario: Creacion cuenta de ahorros pro con cliente actualizado  sin seguro
    Dado el usuario con condiciones cliente "true" actualizado "true" canales "true" y cuenta cat "true"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el usuario diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y "acepto " el beneficio de excencion de gmf
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  Escenario: Creacion cuenta de ahorros simple con cliente actualizado con seguro
    Dado el usuario con condiciones cliente "true" actualizado "true" canales "true" y cuenta cat "true"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el usuario diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  Escenario: Creacion cuenta de ahorros simple con cliente actualizado  sin seguro
    Dado el usuario con condiciones cliente "true" actualizado "true" canales "true" y cuenta cat "true"
    Y que el usuario esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el usuario diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

