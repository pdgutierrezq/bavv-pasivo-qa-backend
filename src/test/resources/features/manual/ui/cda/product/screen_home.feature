# language: es
@sprint:97
@issue:PBA-3844
@app:CDA
@functionality:Pantalla.Bienvenida
@screen:landing
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Pantalla de bienvenida
  YO como Cliente interesado en una cuenta o deposito
  QUIERO tener un visual inicial de los productos
  PARA  iniciar la compra de una cuenta o deposito

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519054
  Escenario: Pantalla de bienvenida de cuenta y deposito
    Cuando  cargue la pantalla de bienvenida
    Entonces  se mostrará la pantalla de acuerdo al mockup.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519055
  Escenario: Incluir zona de documentos por actividad económica.
    Dado que estoy en pantalla de bienvenida
    Cuando  quiera saber los documentos que debo tener para abrir mi deposito o cuenta digital
    Entonces  se mostrarán en esta zona los documentos que se requieren y se pueden cargar para abrir una cuenta digital según la actividad económica.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519056
  Escenario: Despliegue de acordeon con información de documentos por actividad económica.
    Dado que estoy en pantalla de bienvenida
    Cuando de click en el recuadro de alguna actividad económica (Empleado, independiente, pensionado, hogar o estudiante)
    Entonces  se despliegan los documentos que se pueden cargar según esa actividad económica.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519057
  Escenario: Cierre de acordeon con incluir información de documentos por actividad económica.
    Dado que estoy en pantalla de landing y que se encuentra abierta una actividad económica
    Cuando de click en el recuadro de otra actividad económica
    Entonces  se cerrará la que tenia abierta y se desplegaran los documentos de la que estoy abriendo, esto según el mock up.

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519058
  Escenario: Link
    Dado que estoy en pantalla de landing
    Cuando de click en el link “Da clic acá”
    Entonces  se redirige al usuario a [https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/productos/ahorro-e-inversion/cuenta-digital/|https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/productos/ahorro-e-inversion/cuenta-digital/|smart-link] 

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-97
  @testrail-id:519059
  Escenario: Botón comenzar
    Dado que estoy en pantalla de landing
    Cuando de click en el botón “Comenzar”
    Entonces  se redirige al usuario a pantalla identificación usuario

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519060
  Escenario: Pop-Up de Cuenta digital en pantalla de bienvenida
    Dado que estoy en la pantalla de landing
    Cuando seleccione la opción para saber que es una cuenta digital
    Entonces se mostrará POP Up de que es una cuenta digital de acuerdo a mock up

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519061
  Escenario: Cierre del pop up de Cuenta digital en pantalla de bienvenida
    Dado que estoy en la pantalla de landing
    Y seleccione la opción para saber que es una cuenta digital
    Cuando cierro el popup
    Entonces  se deja al usuario en la pantalla de landing

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519062
  Escenario: Pop-Up de Deposito digital en pantalla de bienvenida
    Dado que estoy en la pantalla de landing
    Cuando seleccione la opción para saber que es un Deposito digital
    Entonces se mostrará POP Up de que es una deposito digital de acuerdo a mock up

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519063
  Escenario: Cierre del pop up de Deposito digital en pantalla de bienvenida
    Dado que estoy en la pantalla de landing
    Cuando seleccione la opción para saber que es un Deposito digital
    Cuando cierro el popup
    Entonces  se deja al usuario en la pantalla de landing

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519064
  Escenario: Pop-Up de Beneficios compartidos en pantalla de bienvenida
    Dado que  Estoy en la pantalla de landing
    Cuando  seleccione la opción para saber que más beneficios tengo
    Entonces  se mostrará POP Up con los beneficios de acuerdo a mock up

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-98
  @testrail-id:519065
  Escenario:Cierre del Pop-Up de Beneficios compartidos en pantalla de bienvenida
    Dado que estoy en la pantalla de landing
    Y seleccione la opción para saber que más beneficios tengo
    Cuando cierro el popup
    Entonces se deja al usuario en la pantalla de landing
