# language: es
@Frontend:ValidacionesAdicionalesFormularioIdentificacion


Característica: Validaciones Adicionales Formulario de Identificación del usuario
  YO COMO Usuario identificándome
  NECESITO que se me realicen mas validaciones en la información que ingreso
  PARA que mi información sea consistente

  @Sprint-4
  Escenario: Limitar ingreso superior a 20 caracteres a campos de texto
    Dado que los campos donde dígito mi información son tipo texto
    Cuando ingrese mas de 20 caracteres
    Entonces no me permite ingresar mas datos

  @TestLive
  Escenario: validar copiar pegar en campos de telefono
    Dado que el "cliente" esta digitando información en el campo confirmación de telefono
    Cuando intente pegar la información (control V)
    Entonces no me permitirá pegar los datos
