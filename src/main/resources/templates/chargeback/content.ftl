<#import "../lib/utils.ftl" as u>

<#escape x as x?html>
    <@u.mailtempalte>
        <p>Sr. ${dado.solicitante},</p>
        <p>${mensagem}</p>
        <p>Informações referentes a sua solicitação:</p>
        <table>
            <tr>
                <td>Solicitante:</td>
                <td>${dado.solicitante}</td>
            </tr>
            <tr>
                <td>Nº Chargeback:</td>
                <td>${dado.numeroChargeback}</td>
            </tr>
            <tr>
                <td>Vr. Disputa:</td>
                <td>${dado.valorDisputa}</td>
            </tr>
            <tr>
                <td>Entidade Solicitante:</td>
                <td>${dado.entidadeSolicitante}</td>
            </tr>
            <tr>
                <td>Entidade Requerida:</td>
                <td>${dado.entidadeRequerida}</td>
            </tr>
        </table>
    </@u.mailtempalte>
</#escape>