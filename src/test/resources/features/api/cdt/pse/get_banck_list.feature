# language: es
@sprint:54
@issue:PBA-2029
@app:CDT
@functionality:PSE.Bancos
@screen:fondeo_pse
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Consumo de servicio de Lista banco PSE CDT
  YO COMO  Interfaz grafica de usuario
  QUIERO obtener el listado de bancos
  PARA realizar el proceso de Pse

  Escenario: Validacion de esquema de ws get bank list
    Dado que se obtiene un usuario tipo "cliente actualizado"
    Cuando se llama al servicio pse get bank list
    Entonces se validará el esquema de la respuesta
