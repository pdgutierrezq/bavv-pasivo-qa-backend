# language: es
@sprint:116
@issue:PBA-4764
@app:CDT
@functionality:Pantalla.PSE
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Modificaciones pantalla pse cdt
  YO como usuario en el flujo de CDT
  Necesito que me den más información en la pantalla de PSE
  PARA  entender la posible devolución

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-116
  Escenario: Modificaciones pantalla configuración pse*
    Dado que  el cliente va a realizar el fondeo de CDT
    Cuando  ingrese en la pantalla de configuración PSE
    Entonces  se debe mostrar la nota de “No olvides tener disponible el dinero en tu cuenta y revisa que los límites transaccionales por PSE en tu otro banco te permitan realizar la transacción.” en la parte superior de la pantalla de acuerdo con el mockup

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-116
  Escenario: Modificaciones sección devolución pse*
    Dado que  el cliente va a realizar el fondeo de CDT
    Cuando  ingrese en la pantalla de configuración PSE
    Entonces  se debe mostrar la frase “En caso de que el CDT no se pueda abrir, necesitamos los siguientes datos para hacerte la devolución de la plata”  de acuerdo con el mockup

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-116
  Escenario: Modificaciones pantalla configuración pse*
    Dado que  el cliente va a realizar el fondeo de CDT
    Cuando  dé clic en ¿Por qué devolveríamos tu plata?
    Entonces  se debe mostrar el Pop up donde se especifica al cliente en qué casos devolveríamos la plata de acuerdo con el mockup
