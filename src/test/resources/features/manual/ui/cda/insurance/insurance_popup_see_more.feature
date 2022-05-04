# language: es
@sprint:96
@issue:PBA-3511
@app:CDA
@functionality:Seguro.Popup
@screen:seguro
@layer:frontend
@priority:high
@regression:yes
@execution:manual
@automation:pending
Característica: Popup de ver mas en la pantalla de seguro

  @manual
  @manual-result:passed
  @manual-last-tested:sprint-96
  @testrail-id:519037
  Escenario: Texto del popup de vermas en la pantalla de seguros
    Dado estoy en la pantalla de seguro
    Cuando hago click en "Ver mas"
    Entonces se muestra un popup con el siguiente texto
  # "Con el seguro de cuenta protegida integral por solo $493 pesos diarios ($14.800 mensuales) te proteges en caso de:
  # * Hurto del dinero retirado: en oficinas o cajeros electrónicos hasta por $1.326.000 por evento*.
  # * Utilización forzada: en caso que te obliguen de forma violenta a retirar dinero de tu cuenta hasta por $1.326.000 por evento*.
  # * Uso indebido de la tarjeta: en caso que una persona realice compras o retiros con tu tarjeta sin tu autorización hasta por $1.326.000 por evento*."
  # * Muerte accidental: el valor para que tus beneficiarios puedan destinar libremente es de $4.753.000.
  # * Incapacidad permanente: el valor que puedes destinar libremente es de $4.753.000. *Dos eventos por año.
  # SEGUROS ALFA S.A.asume exclusivamente la responsabilidad del cumplimiento de las obligaciones relacionadas con el Contrato de Seguro y la indemnización en caso de siniestro, por ser quien recibe las primas. La descripción detallada de las coberturas, exclusiones y demás características del seguro están disponibles en la página web_[https://www.segurosalfa.com.co/personas/bancapersonas/banco-av-villas|https://www.segurosalfa.com.co/personas/bancapersonas/banco-av-villas|smart-link] _y_[https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/seguros-avvillas/cuenta-protegida/|https://www.avvillas.com.co/wps/portal/avvillas/banco/banca-personal/seguros-avvillas/cuenta-protegida/|smart-link] _Este producto es ofrecido por la red del Banco AV Villas limitándose al cumplimiento de las instrucciones impartidas por SEGURO ALFA S.A. El BANCO AV VILLAS no actúa como intermediario ni como compañía de seguro.”_

