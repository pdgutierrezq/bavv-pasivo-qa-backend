  # language: es
  @Frontend:OfrecimientoDeSeguro
  @Sprint-9
  @PBA-11
  @ok

  Característica: Oferta y aceptación de seguro
    YO COMO Cliente
    NECESITO que se me oferte un seguro
    PARA definir si lo quiero o no

    Esquema del escenario: Activación del botón continuar
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y que el cliente se encuentra en pantalla donde se muestra ofrecimiento del seguro
      Cuando el usuario "<afirmacion>" el seguro
      Entonces se activara la opcion continuar
      Ejemplos:
        | afirmacion |
        | acepta     |
        | no acepta  |

    Escenario: POP-UP de descripción del seguro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y que el cliente se encuentra en pantalla donde se muestra ofrecimiento del seguro
      Cuando ingresa en la opcion ver mas
      Entonces se despliega un POP UP con la descripción del seguir

    Escenario: Cierre de POP-UP con descripción del seguro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y que el cliente se encuentra en pantalla donde se muestra ofrecimiento del seguro
      Y ingresa en la opcion ver mas
      Cuando ingrese en la opcion cerrar o el entendido
      Entonces se cierra el POP-UP quedando el cliente en la pantalla de ofrecimiento de seguro

    Escenario: Re-dirección a pantalla de OTP aceptó o no seguro
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y que el cliente se encuentra en pantalla donde se muestra ofrecimiento del seguro
      Cuando "acepta" el seguro y continua
      Entonces pasa a pantalla de OTP
