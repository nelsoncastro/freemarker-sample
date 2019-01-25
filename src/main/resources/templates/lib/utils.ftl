<#macro mailtempalte>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <style type="text/css">
            body {
                font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
                font-size: 16px;
                color: #676a6c;
                overflow-x: hidden;
            }

            .logo {
                float: left;
                margin-left: 58px;
                margin-top: 70px;
            }
        </style>
    </head>
    <body style="margin: 0; padding: 0;">
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border-collapse: collapse;">
        <tr>
            <td bgcolor="#00538b" style="padding: 5px">
                <img class="logo" src="logo.png" border="0">
            </td>
        </tr>
        <tr>
            <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
                <#nested>
            </td>
        </tr>
        <tr>
            <td bgcolor="#eaeaea" style="padding: 25px; text-align: right">
                <p>Brasília, ${.now?string["dd"]} de ${.now?string["MMMM"]} de ${.now?string["yyyy"]}</p>
            </td>
        </tr>
        <tr>
            <td style="font-size: 11px;">Não responda a este e-mail. Esta é uma mensagem gerada automaticamente.</td>
        </tr>
    </table>
    </body>
    </html>
</#macro>