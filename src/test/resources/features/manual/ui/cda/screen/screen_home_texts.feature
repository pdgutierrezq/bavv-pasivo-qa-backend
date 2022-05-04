# language: es
@sprint:100
@issue:PBA-3961
@app:CDA
@functionality:Pantalla.Bienvenida.Textos
@screen:landing
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Textos en pantalla de bienvenida
  YO como Cliente interesado en una cuenta o deposito
  QUIERO tener un visual inicial de los productos
  PARA  iniciar la compra de una cuenta o deposito

  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521767
  Escenario: Asterisco sin cuota de manejo
    Dado que estoy en la pantalla de bienvenida
    Entonces se mostrarán en esta el siguiente texto “*Sin cuota de manejo y tres retiros gratis si mantienes un saldo promedio de $500.000 pesos al mes, de lo contrario, cuota de manejo de $3.490 y un retiro gratis.”
