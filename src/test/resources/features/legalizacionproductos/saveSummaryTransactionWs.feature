  # language: es
  @Backend:PantallaDeclarante
  @Sprint-51
  @PBA-1814
  @regresion

    Característica: Modificar el servicio de save summary transation CDT
    YO COMO Usuario
    NECESITO almacenar datos
    PARA presentar posteriormente un resumen

    Escenario: Actualizar datos para resumen
      Dado que el "usuario" se autentica en el sistema
      Cuando el "usuario" actualiza la informaicon de resumen de forma exitosa
      Entonces se confirmará que se actualizó la información
