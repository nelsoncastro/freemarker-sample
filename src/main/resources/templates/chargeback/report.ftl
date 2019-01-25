<#import "../lib/utils.ftl" as u>

<#escape x as x?html>
    <@u.mailtempalte>
        <p>Sr. ${solicitante},</p>
        <p>${mensagem}</p>
    </@u.mailtempalte>
</#escape>