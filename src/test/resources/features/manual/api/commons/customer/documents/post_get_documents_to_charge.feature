# language: es
@sprint:24
@issue:PBA-881
@app:COMMONS
@functionality:Cliente.Documentos
@screen:documentos
@layer:backend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Consumo de servicio de cargue de documentos iniciar en pantalla de documentos
  YO COMO sistema
  NECESITO consumir el servicio de cargue de documentos iniciar
  PARA saber cuales documentos debo cargar dependiendo del cliente

  @testrail-id:516426
  Escenario: Consumo get-documents-to-charge- simple con cc en onbase cualquier actividad
    Dado que tengo un usuario tipo cliente no actualizado sin cuenta simple y no requiere cedula
    Y tiene alguna de las siguientes actividades economicas 1 hogar,3 empleado, 4 independiente,5 estudiante,8 pensionado
    Cuando consulto el ws get-documents-to-charge-empleado
    Entonces obtengo los documentos requeridos "Nos entrega un listado sin documentos ya que no requiere cc"

  @testrail-id:516427
  Escenario: Consumo get-documents-to-charge- pro sin cc en onbase actividad hogar
    Dado que tengo un usuario tipo cliente no actualizado sin cuenta simple y si requiere cedula
    Y tiene actividad economica hogar
    Cuando consulto el ws get-documents-to-charge-empleado
    Entonces obtengo los documentos requeridos "Declaracion de renta,Certificación de Ingresos y Retenciones,Documento Identificacisn (CC, CE, TI, RC)"

  @testrail-id:516428
  Escenario: Consumo get-documents-to-charge- pro con cc en onbase actividad empleado
    Dado que tengo un usuario tipo cliente no actualizado sin cuenta simple y no requiere cedula
    Y tiene actividad economica empleado
    Cuando consulto el ws get-documents-to-charge-empleado
    Entonces obtengo los documentos requeridos "Declaracion renta,Original del certificado laboral,Solicit.Compra Inmueb. y conocimiento cliente,Comporbantes pago nomina / egreso"

  @testrail-id:516429
  Escenario: Consumo get-documents-to-charge- pro sin cc en onbase actividad independiente SI requiere cedula
    Dado que tengo un usuario tipo cliente no actualizado sin cuenta simple y si requiere cedula
    Y tiene actividad economica independiente
    Cuando consulto el ws get-documents-to-charge-empleado
    Entonces obtengo los documentos requeridos "Declaracion renta,Original del certificado laboral,Certificación de Ingresos y Retenciones,Balace y estado p y g,Certificado camara comercio / Reg. Mercantil,Documento Identificacisn (CC, CE, TI, RC),RUT"

  @testrail-id:516430
  Escenario: Consumo get-documents-to-charge- pro con cc en onbase actividad independiente NO requiere cedula
    Dado que tengo un usuario tipo cliente no actualizado sin cuenta simple y no requiere cedula
    Y tiene actividad economica independiente
    Cuando consulto el ws get-documents-to-charge-empleado
    Entonces obtengo los documentos requeridos "Declaracion renta,Original del certificado laboral,Certificación de Ingresos y Retenciones,Balace y estado p y g,Certificado camara comercio / Reg. Mercantil,RUT"

