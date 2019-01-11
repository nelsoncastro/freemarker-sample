<#import "lib/utils.ftl" as u>

<#-- Variables -->
<#assign var_link = "http://www.google.com.br">

<#-- Example of using a macro: -->
<@u.page>
    <a href="${latestProduct.url}">${latestProduct.name}</a>!

    <#-- Just another example of using a macro: -->
    <@u.otherExample p1=11 p2=22 />

    <p>
    <a href="${var_link}">About Lars Vogel</a>

    <#-- Acts like if the color was N/A if there's no color: -->
    <p>Color: ${color!'N/A'}</p>

    <!-- Avoid the whole color row if there's no color: -->
    <#if color??>
        <p>Color: ${color}</p>
    </#if>

    <#escape x as x?html>
        <p>Sender: ${from}
        <p>Title: ${title}
        <p>Message: ${body}
    </#escape>

</@u.page>