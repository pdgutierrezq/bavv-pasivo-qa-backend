  # language: es
  @Frontend:PantallaEnrolamiento
  @Sprint-12
  @PBA-257
  @ok

  Característica: Pantalla de Enrolamiento a canal
    YO COMO Cliente finalizando apertura de cuenta
    NECESITO que enrolarme en canales
    PARA terminar el proceso de apertura de cuenta

    Antecedentes: Obtener datos ara el flujo
      Dado que se obtiene un usuario tipo cliente "true" actualizado "true" lista restrictiva "false" cuenta cat "false" y canales "false"

    Esquema del escenario: scenario: Validación de dígitos consecutivos en nueva contraseña
      Dado el cliente está en la pantalla de enrolamiento
      Cuando ingrese un numero de cuatro digitos y existan "<condicion>"
      Entonces se mostrará un mensaje que diga "La contraseña no puede tener dígitos consecutivos o iguales"
      Y no se activará el botón
      Ejemplos:
        | condicion                                   |
        | 3 dígitos consecutivos de manera ascendente |
        | 3 dígitos iguales                           |
