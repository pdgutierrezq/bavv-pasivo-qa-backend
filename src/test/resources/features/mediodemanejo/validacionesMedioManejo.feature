  # language: es
  @Frontend:ValidacionMedioDeManejo
  @Sprint-10
  @PBA-8

  Característica: Validaciones en Dirección de entrega Tarjeta Débito
    YO COMO usuario que seleccioné una cuenta de ahorros (Simple o PRO)
    NECESITO que se me valide la dirección de entrega de la tarjeta débito
    PARA que este correctamente escrita

    Escenario: No permitir el ingreso de palabras especificas
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese textos en el campo de dirección como
        | DEFINI | TIENE | MISMA | NO TIENE | ESPECIFI | NO APLICA |
      Entonces Se validará que se presenta el mensaje "La información ingresada no es válida" al ingresar palabra invalidas
      Y será un bloqueante para la activación de la opción continuar

    Escenario: Carácter numérico en primer posición
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese un numero en la primera posición y cambié de campo
      Entonces le aparecerá un mensaje informando que "La información ingresada no es válida"
      Y será un bloqueante para la activación de la opción continuar

    Escenario: Carácter especial @ en campo de dirección
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese un @ en cualquier posición  y cambié de campo
      Entonces le aparecerá un mensaje informando que "La información ingresada no es válida"
      Y será un bloqueante para la activación de la opción continuar

    Escenario: Longitud de campo
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese un valor inferior a 5 caracteres
      Entonces le aparecerá un mensaje informando que "Este campo debe tener mínimo 5 caracteres"
      Y será un bloqueante para la activación de la opción continuar

    Escenario: Auto complete dropdown de campo de ciudad
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese a digitar el campo
      Entonces se desplegará el listado de las ciudades o municipios de Colombia que tiene cobertura de Domina.

    Escenario: Valor invalido en el campo de ciudad
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando ingrese alguna ciudad que no este en la lista desplegable
      Entonces le aparecerá un mensaje informando que "En esta ciudad no tenemos cobertura de entrega"
      Y será un bloqueante para la activación de la opción continuar

#    Escenario: Vacío en el campo de ciudad o dirección
#      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
#      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
#      Cuando deje el campo de dirección o de ciudad vacío y cambie de campo
#      Entonces le aparecerá un mensaje informando que "Este campo es obligatorio"
#      Y será un bloqueante para la activación de la opción continuar

    Escenario: Auto complete dropdown de campo de ciudad
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" y cuenta cat "false"
      Y el cliente está en la pantalla de confirmación de dirección de envío de la tarjeta débito y viene de OTP
      Cuando cambie la ciudad y sea una Ciudad valida
      Entonces El campo de dirección y check de transporte masivo deberá quedar vació

