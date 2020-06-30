# language: es
@Frontend:CampoIngresosFormularioIdentificacion
@Sprint-8
@PBA-235
@ok

Característica: Ingresar campo de ingresos en formulario identificación de usuario
  YO COMO usuario interesado en abrir una cuenta de ahorros
  NECESITO ingresar mis ingresos
  PARA determinar que cuenta me sugieren

  Escenario: validaciones de longitud minima para el campo de ingresos mensuales
    Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
    Y que el usuario en pantalla identificación de usuario
    Cuando ingrese el valor de los ingresos mensuales mayores o iguales a 10000
    Entonces se activará el botón continuar si este y los demás campos están diligenciados correctamente.

  Escenario: validaciones de longitud maxima para el campo de ingresos mensuales
    Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
    Y que el usuario en pantalla identificación de usuario
    Cuando ingrese el valor con longitud mayor de diez caracteres numéricos
    Entonces se observara que no permite el ingreso en el campo de texto

  Escenario: Valor mínimo para el campo de ingresos mensuales
    Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
    Y que el usuario en pantalla identificación de usuario
    Cuando el cliente deje el campo y el valor ingresado en el campo ingresos sea menor a 10000
    Entonces se mostrará el mensaje de error "Tus ingresos no pueden ser inferiores a $ 10.000 pesos"

  Escenario: Dar formato al campo de ingresos mensuales
    Dado que se obtiene un usuario tipo cliente "true" actualizado "false" lista restrictiva "false"
    Y que el usuario en pantalla identificación de usuario
    Cuando ingrese el valor de los ingresos mensuales mayores o iguales a 10000
    Entonces la información se visualizara con signo pesos como primer posición y los puntos de miles y o millones
