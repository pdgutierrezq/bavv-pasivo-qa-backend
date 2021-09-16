# language: es
@sprint:63
@issue:PBA-2336
@app:CDT
@functionality:Banco.PDF
@screen:firma_electronica
@layer:backend
@priority:high
@regression:yes
@execution:automatic
@automation:complete
Característica: Lógica de Get PDFs para CDT
  YO como cliente en firma de documentos
  QUIERO ver y que me lleguen los documentos respectivos a los productos que seleccioné
  PARA identificar que abrí
  
  @testrail-id:511076
  Escenario: Paquete 1508
    Dado que se obtiene un usuario tipo "aleatorio"
    Y que el cliente seleccionó "fondeo por PSE, no seleccionó cuenta y no requiere formato declarante"
    Cuando se consulta al banco para obtener el pdf
    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#  Escenario: Paquete 1509
#    Dado que se obtiene un usuario tipo "aleatorio"
#    Y que el cliente seleccionó "fondeo por PSE, no seleccionó cuenta y requiere formato declarante"
#    Cuando se consulta al banco para obtener el pdf
#    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#  Escenario: Paquete 1510
#    Dado que se obtiene un usuario tipo "aleatorio"
#    Y que el cliente seleccionó "fondeo por PSE, con cuenta abierta en el flujo y no requiere formato declarante"
#    Cuando se consulta al banco para obtener el pdf
#    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#  Escenario: Paquete 1511
#    Dado que se obtiene un usuario tipo "aleatorio"
#    Y que el cliente seleccionó "fondeo por PSE, con cuenta abierta en el flujo y requiere formato declarante"
#    Cuando se consulta al banco para obtener el pdf
#    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#  Escenario: Paquete 1512
#    Dado que se obtiene un usuario tipo "aleatorio"
#    Y que el cliente seleccionó "fondeo con debito de cuenta en el banco y no requiere formato declarante"
#    Cuando se consulta al banco para obtener el pdf
#    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#  Escenario: Paquete 1513
#    Dado que se obtiene un usuario tipo "aleatorio"
#    Y que el cliente seleccionó "fondeo con debito de cuenta en el banco y requiere formato declarante"
#    Cuando se consulta al banco para obtener el pdf
#    Entonces se debe retornar el PDF correspondiente a las condiciones dadas
#
#
