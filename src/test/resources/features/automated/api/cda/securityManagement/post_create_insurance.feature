# language: es
@sprint:120
@issue:PBA-5172
@app:CDA
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Radicar.Seguro
@screen:firma-documentos
@layer:backend
@service:create-insurance
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Hacer una peticion al servicio de radicar seguro
  YO COMO sistema
  NECESITO conocer si el servicio de radicar seguro responde de manera correcta
  PARA poder determinar que el servicio está funcionando

  Escenario: Usuario hace una peticion post
    Cuando el genera una peticion post al servicio de radicar seguro
    Entonces el recibe una respuesta exitosa
