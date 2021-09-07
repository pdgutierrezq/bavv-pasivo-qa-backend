# language: es
@sprint:51
@issue:PBA-1814
@app:CDT
@feature:Resumen_de_transaccion
@screen:declarante
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Modificar el servicio de save summary transation CDT
  YO COMO Usuario
  NECESITO almacenar datos
  PARA presentar posteriormente un resumen

  @testrail-id:510216
  Escenario: Actualizar datos para resumen
    Dado que el "usuario" se autentica en el sistema
    Cuando el "usuario" actualiza la informaicon de resumen de forma exitosa
    Entonces se confirmará que se actualizó la información
