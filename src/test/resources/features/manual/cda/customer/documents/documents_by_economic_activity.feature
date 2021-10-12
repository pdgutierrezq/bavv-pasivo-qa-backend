# language: es
@sprint:94
@issue:PBA-3613
@app:CDA
@functionality:Cliente.Documentos
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Documentos segun actividad economica e ingresos
  YO como NO cliente o cliente des-actualizado
  QUIERO que se me permita cargar los documentos según mi actividad económica
  PARA que mi proceso de abrir cuenta este mas completo

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-94
  Esquema del escenario:Cliente que haya seleccionado cuenta Digital con Actividad:<Actividad>, <Declarante> es declarante y con <Ingresos>
    Dado que llegué a la pantalla de cargue de documentos
    Cuando haya seleccionado una cuenta Digital, soy <Actividad>, <Declarante> declarante y tengo ingresos <Ingresos>
    Entonces se muestra componente de Cargue soporte ingresos que incluye las siguientes opciones:<Documentos>

    Ejemplos:
      | Actividad                 | Ingresos                | Declarante | Documentos                                                                                             |
      | Estudiante                | mayores a $1.817.052    | Si         | Certificación de ingresos,Declaración de renta                                                         |
      | Estudiante                | mayores a $1.817.052    | No         | Certificación de ingresos,Declaración de renta                                                         |
      | Estudiante                | NO mayores a $1.817.052 | Si         | Certificación de ingresos,Declaración de renta                                                         |
      | Hogar                     | mayores a $1.817.052    | Si         | Certificación de ingresos,Declaración de renta                                                         |
      | Hogar                     | mayores a $1.817.052    | No         | Certificación de ingresos,Declaración de renta                                                         |
      | Hogar                     | NO mayores a $1.817.052 | Si         | Certificación de ingresos,Declaración de renta                                                         |
      | Independiente             | mayores a $1.817.052    | Si         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |
      | Independiente             | mayores a $1.817.052    | No         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |
      | Independiente             | NO mayores a $1.817.052 | Si         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |
      | Independiente con negocio | mayores a $1.817.052    | Si         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |
      | Independiente con negocio | mayores a $1.817.052    | No         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |
      | Independiente con negocio | NO mayores a $1.817.052 | Si         | Estados financieros,Declaración de renta,Certificación de ingresos,Contrato de prestación de servicios |

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-94
  Esquema del escenario:Cliente que haya seleccionado cuenta Digital con Actividad:<Actividad>, <Declarante> es declarante y con <Ingresos>
    Dado que llegué a la pantalla de cargue de documentos
    Cuando haya seleccionado una cuenta Digital, soy <Actividad>, <Declarante> declarante y tengo ingresos <Ingresos>
    Entonces no se muestra componente de Cargue soporte ingresos

    Ejemplos:
      | Actividad                 | Ingresos                | Declarante |
      | Estudiante                | NO mayores a $1.817.052 | No         |
      | Hogar                     | NO mayores a $1.817.052 | No         |
      | Independiente             | NO mayores a $1.817.052 | No         |
      | Independiente con negocio | NO mayores a $1.817.052 | No         |