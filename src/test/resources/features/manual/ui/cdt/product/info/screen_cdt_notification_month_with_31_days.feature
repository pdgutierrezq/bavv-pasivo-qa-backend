# language: es
@sprint:94
@issue:PBA-3578
@app:CDT
@functionality:Producto.Info.Basica.Pantalla
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Nota de creación de CDT fin de mes
  YO como usuario abriendo un CDT a fin de mes
  QUIERO que se me informe que quedará creado a inicio del siguiente mes
  PARA que sea claro y transparente

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-94
  @testrail-id:515700
  Escenario: Nota de creacion de CDT en dia 31 del mes
    Dado que el usuario está en la pantalla de configuración de CDT
    Cuando sea 31 de cualquier mes
    Entonces se le mostrará la nota “La constitución de tu CDT y la contabilización del plazo comenzará el siguiente día hábil.”

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-94
  @testrail-id:515701
  Escenario: Nota de creacion de CDT en dia NO 31 del mes
    Dado que el usuario está en la pantalla de configuración de CDT
    Cuando sea un día diferente a 31
    Entonces no se le mostrará la nota
