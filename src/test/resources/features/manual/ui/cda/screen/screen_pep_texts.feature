# language: es
@sprint:100
@issue:PBA-3961
@app:CDA
@functionality:Pantalla.PEP.Textos
@screen:landing
@layer:frontend
@priority:low
@regression:no
@execution:manual
@automation:pending
Característica: Textos en pantalla de cliente PEP
  YO como Cliente interesado en una cuenta o deposito
  QUIERO tener un visual inicial de los productos
  PARA  iniciar la compra de una cuenta o deposito

  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521768
  Escenario: Textos en pantalla de cliente PEP
    Dado que estoy en la pantalla de cliente PEP
    Entonces se mostrarán en esta el siguiente texto “¿Qué es PEP - Persona Expuesta Políticamente? Tú, o alguno de tus relacionados es: ¿Una persona expuesta políticamente?Si/No¿Un directivo de alguna organización internacional y/ouna persona que desempeña funciones públicas destacadas en otro país?Si/No”

  @manual-result:passed
  @manual-last-tested:sprint-100
  @testrail-id:521769
  Escenario: Textos en popup de cliente PEP
    Dado que estoy en la pantalla de cliente PEP
    Entonces se mostrarán en esta el siguiente texto
#  ¿Qué es una PEP - Persona Expuesta Políticamente?
#  Tú, o alguno de tus relacionados* es:
#  Una persona expuesta políticamente, por ocupar actualmente o haber ocupado en un periodo de 2 años atrás algún cargo público relacionado en el Decreto 830 de 2021**
#  Un directivo de alguna organización internacional y/o que desempeña funciones públicas destacadas en otro país***.
#  *Cónyuge, compañero (a), hijo (s), padres, nieto (s), hermano (s), abuelos, suegro (s), nuera (s), yerno (s).
#  **Funcionarios públicos de la rama ejecutiva, legislativa y judicial con capacidad decisoria; representantes legales, presidentes, directores, y tesoreros de partidos y movimientos políticos u otra forma de asociación política reconocida por la ley: directores y tesoreros de patrimonios autónomos o fideicomisos que administren recursos públicos.
#  *** Se entienden por PEP extranjeros: Personas con cargos directivos en alguna organización internacional o con cargos públicos destacados en el exterior como: (i) jefes de Estado, jefes de Gobierno, ministros, subsecretarios o secretarios de Estado; (ii) congresistas o parlamentarios; (iii) miembros de tribunales supremos, tribunales constitucionales u otras altas instancias judiciales cuyas decisiones no admitan normalmente recurso, salvo en circunstancias excepcionales; (iv) miembros de tribunales o de las juntas directivas de bancos centrales; (v) embajadores, encargados de negocios y altos funcionarios de las fuerzas armadas, y (vi) miembros de los órganos administrativos, de gestión o de supervisión de empresas de propiedad estatal.”
