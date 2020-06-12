# language: es
@Frontend:ValidacionesAdicionalesFormularioIdentificacion
@ok
@PBA-32

Característica: Validaciones Adicionales Formulario de Identificación del usuario
  YO COMO Usuario identificándome
  NECESITO que se me realicen mas validaciones en la información que ingreso
  PARA que mi información sea consistente

  @Sprint-4
  Escenario: Limitar ingreso superior a 20 caracteres a campos de texto
    Dado que los campos donde digito mi informacion son tipo texto
    Cuando ingrese mas de 20 caracteres
    Entonces no me permite ingresar mas datos


