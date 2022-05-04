# language: es
@sprint:119
@issue:PBA-4833
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Parametros.Iniciales.App
@screen:Landing
@layer:backend
@service:get-product-configuration
@repository:bavv-pasivo-backend-product-configuration-lambdas
Característica: Validar parametros iniciales del producto
  Yo como negocio
  Quiero que se realice una consulta a los parámetros de la aplicación
  Para conocer que se debe mostrar en el flujo si retoma apagado o encendido

  Escenario: Generacion de parametros iniciales ok
    Cuando el solicita los parametros iniciales de la aplicacion
    Entonces el recibe una respuesta de generacion exitosa
