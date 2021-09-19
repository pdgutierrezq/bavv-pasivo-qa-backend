# language: es
@sprint:67
@issue:PBA-2652
@app:COMMONS
@functionality:Banco.CRM.Actualización
@screen:declarate
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Actualizar CRM
  YO COMO Usuario
  NECESITO actualizar mi informacion de crm
  PARA crear el producto pasivo

  Escenario: Actualizar y validar CRM
    Dado que el "no cliente" se autenticó, radicó pasivo y consultó crm
    Cuando el usuario actualiza la información en crm
    Entonces se validará que la información se actualizó

