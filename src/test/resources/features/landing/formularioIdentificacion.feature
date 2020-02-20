# language: es
@Frontend:FormularioIdentificacion


Característica: Formulario de Identificación del usuario
  YO COMO  usuario
  NECESITO abrir una cuenta de ahorros digital de forma segura
  PARA iniciar el proceso de apertura de cuenta

  @Sprint-3
  Escenario: Validacion formulario datos completos y correctos
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando ingresa los datos correctamente
    Entonces se activara el boton de continuar

  @Sprint-3
  Escenario: Validacion formulario datos incompletos
    Dado que el "usuario" es cliente actualizado del banco, esta interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando ingresa los datos incompletos
    Entonces no se activara el boton de continuar y muestra mensaje de error

  @Sprint-3
  Escenario: Validacion formulario numero no coindidente
    Dado que el "usuario" esta en la pantalla del formulario de identificacion de usuario
    Cuando ingresa celular con cuarto numero igual a 1 o 0
    Entonces genera mensaje "El número de celular no es válido"
