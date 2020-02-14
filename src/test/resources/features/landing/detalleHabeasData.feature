# language: es
@Frontend:DetalleHabeasData

Característica: Detalle Habeas Data
  YO COMO Cliente
  NECESITO saber el detalle de lo que es habeas data
  PARA dar mi consentimiento por medio de un check y seguir con el proceso de apertura

  @Sprint-3
  Escenario: Visualizar informacion adicional de habeas data
    Dado que el "cliente" quiere saber que es la autorización de habeas data
    Cuando de click en ver mas habeas data
    Entonces se le desplegará un Pop-Up con la información de lo que es la autorización del habeas data.

  @Sprint-3
  Escenario: Validar funcionalidad boton entendido ver mas habeas data
    Dado que el "cliente" esta en el POPUP de lo que es la autorización de habeas data
    Cuando Cuando de click en entendido
    Entonces Regresará a la pantalla de identificación cliente


  @Sprint-3
  Escenario: Validar funcionalidad boton cerrar ver mas habeas data
    Dado que el "cliente" esta en el POPUP de lo que es la autorización de habeas data
    Cuando Cuando de click en cerrar
    Entonces Regresará a la pantalla de identificación cliente


