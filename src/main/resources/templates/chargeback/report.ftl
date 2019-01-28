<#import "../lib/utils.ftl" as u>

<#escape x as x?html>
    <@u.mailtempalte>
        <p>${mensagem}</p>
    </@u.mailtempalte>
</#escape>