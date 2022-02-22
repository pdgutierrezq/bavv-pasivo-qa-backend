# language: es
@sprint:112
@issue:PBA-4468
@app:
@functionality:
@layer:
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Modificación pop up declarante renta cdt
  YO como* cliente
*Necesito* que me informen quienes están obligados a declarar renta
  PARA  saber que opción marcar en la pantalla de declarante

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-112
  Escenario: Pop up cdt*
    Dado que  el cliente está abriendo un cdt y se encuentra en la pantalla de declarante
    Cuando  el cliente de clic en ¿Qué es?
    Entonces  se debe mostrar el Pop up con el siguiente texto
     #“Están obligadas a declarar renta las personas naturales quienes al último día del año gravable 2021, excedieron de patrimonio bruto $163.386.000 o de ingresos totales $50.831.100. También aquellas donde el valor total de: compras y consumos, compras con tarjeta de crédito y el valor total acumulado de las consignaciones bancarias, depósitos o inversiones financieras, sean igual a $50.831.100"