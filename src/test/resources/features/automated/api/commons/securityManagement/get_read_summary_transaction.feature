# language: es
@sprint:120
@issue:PBA-5196
@app:COMMONS
@priority:medium
@regression:yes
@execution:automatic
@automation:complete
@functionality:Read.summary.Transaction
@screen:TransactionSummary
@layer:backend
@service:read-summary-transaction
@repository:bavv-pasivo-backend-transactions-info-lambdas
Característica: Validar el resumen de la transaccion
  Yo como negocio
  Quiero que se realice una consulta al resumen de la transaccion
  Para conocer el resumen de la transaccion

  Escenario: Consulta del resumen de la transaccion ok
    Cuando el solicita la consulta al resumen de la transaccion
    Entonces el recibe una respuesta de generacion exitosa
