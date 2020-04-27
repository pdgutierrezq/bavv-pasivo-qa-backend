# language: es
@Frontend:E2E-ClienteActualizado


Característica: Creacion cuenta de ahorros cliente actualizado
  YO COMO  cliente actualizado
  NECESITO abrir una cuenta de ahorros digital
  PARA tener acceso a una cuenta de ahorros digital

  @construccion
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado  con seguro enrolado
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el "cliente actualizado" diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y Selecciona el paquete con "2" retiros en cajero y "1" retiros en oficina
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construccionw
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado  sin seguro enrolado
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el "cliente actualizado" diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta pro"
    Y Selecciona el paquete con "2" retiros en cajero y "1" retiros en oficina
    Y "no acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construccionk
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado con seguro
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el "cliente actualizado" diligencia el formulario de identificacion de usuario
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta

  @construcciony
  Escenario: Creacion cuenta de ahorros pro con cliente actualizado enrolado
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el "cliente no actualizado" diligencia el formulario de identificacion de usuario
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
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando el "no cliente" diligencia el formulario de identificacion de usuario
    Y Selecciono que "no" es PEP
    Y selecciona el producto "cuenta simple"
    Y "acepta" el seguro
    Y se autentica mediante otp
    Y "no actualiza" la direccion de envio
    Y "confirma" que es declarante
    Y realiza la firma electronica de documentos
    Entonces se muestra el resumen de la creacion de la cuenta
