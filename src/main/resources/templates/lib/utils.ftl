<#macro mailtempalte title name location>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Título</title>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

        <style type="text/css">
            body {
                font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
                font-size: 16px;
                color: #676a6c;
                overflow-x: hidden;
            }
        </style>
    </head>
    <body style="margin: 0; padding: 0;">
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="800" style="border-collapse: collapse;">
        <tr>
            <td bgcolor="#00538b" style="padding: 5px">
                <img src="data:image/png;base64,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"
                />
            </td>
        </tr>
        <tr>
            <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
                <p>Sr. Fulano de Tal,</p>
                <p>O seu pedido de Chargeback foi registrado. O acompanhamento poderá ser realizado pelo Cabal Net.
                </p>
                <table>
                    <tr>
                        <td>Solicitante:</td>
                        <td>FULANO DE TAL</td>
                    </tr>
                    <tr>
                        <td>Nº Chargeback:</td>
                        <td>0000000001</td>
                    </tr>
                    <tr>
                        <td>Vr. Disputa:</td>
                        <td>R$ 100,00</td>
                    </tr>
                    <tr>
                        <td>Entidade Solicitante:</td>
                        <td>BANCOOB</td>
                    </tr>
                    <tr>
                        <td>Entidade Requerida:</td>
                        <td>SOLLUS</td>
                    </tr>
                </table>

            </td>
        </tr>
        <tr>
            <td bgcolor="#eaeaea" style="padding: 25px; text-align: right">
                <p>Brasília, 23 de janeiro de 2019</p>
            </td>
        </tr>
        <tr>
            <td style="font-size: 11px;">Não responda a este e-mail. Esta é uma mensagem gerada automaticamente.</td>
        </tr>
    </table>
    </body>
    </html>
</#macro>