# language: es
@Frontend:FormularioIdentificacion


Característica: Formulario de Identificación del usuario
  YO COMO  usuario
  NECESITO abrir una cuenta de ahorros digital de forma segura
  PARA iniciar el proceso de apertura de cuenta

  @Sprint-3
  Escenario: Validación formulario datos completos y correctos
    Dado que el "usuario" es cliente actualizado del banco, está interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando ingresa los datos correctamente
    Entonces se activará el botón de continuar

  @Sprint-3
  Escenario: Validación formulario datos incompletos
    Dado que el "usuario" es cliente actualizado del banco, está interesado en adquirir el producto y en pantalla se muestra el formulario de datos
    Cuando ingresa los datos incompletos
    Entonces no se activará el botón de continuar y muestra mensaje de error

  @Sprint-3
  Escenario: Validación formulario datos incompletos
    Dado que el "usuario" esta en la pantalla del formulario de identificacion de usuario
    Cuando ingresa celular con cuarto numero igual a 1 o 0
    Entonces genera mensaje "El número de celular no es válido"
