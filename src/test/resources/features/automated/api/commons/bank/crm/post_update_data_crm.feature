# language: es
@sprint:67
@issue:PBA-2652
@app:COMMONS
@priority:high
@regression:yes
@execution:automatic
@automation:complete
@functionality:Banco.CRM.Actualización
@screen:declarate
@layer:backend
@service:update-data-crm
@repository:bavv-pasivo-backend-user-identification-lambdas
Característica: Actualizar CRM
  YO COMO Usuario
  NECESITO actualizar mi informacion de crm
  PARA crear el producto pasivo

  @testrail-id:515649
  Escenario: Actualizar y validar CRM
    Dado que el "no cliente" se autenticó, radicó pasivo y consultó crm
    Cuando el usuario actualiza la información en crm
    Entonces se validará que la información se actualizó

  Esquema del escenario: : Peter actualiza sus datos en el flujo de <APLICACION>
    Dado Peter es un usuario con las siguientes caracteristicas
      | documentType   | @{USUARIO.CLIENTE.TIPO_DE_DOCUMENTO} |
      | documentNumber | @{USUARIO.CLIENTE.IDENTIFICACION}    |
    Cuando el actualiza la informacion en el CRM del banco
    Entonces el recibe una respuesta exitosa

    Ejemplos:
      | APLICACION |
      | CDT        |
#     TODO | CDA        |

