<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Wyniki meczów</title>
                <style>
                    table { border-collapse: collapse; width: 100%; }
                    th, td { border: 1px solid black; padding: 8px; text-align: left; }
                    tr:nth-child(even) { background-color: #f2f2f2; }
                </style>
            </head>
            <body>
                <h2>Wyniki meczów</h2>
                <table>
                    <tr>
                        <th>Data</th>
                        <th>Drużyna A</th>
                        <th>Drużyna B</th>
                        <th>Wynik</th>
                    </tr>
                    <xsl:for-each select="Matches/Match">
                        <tr>
                            <td><xsl:value-of select="@Date"/></td>
                            <td><xsl:value-of select="TeamA"/></td>
                            <td><xsl:value-of select="TeamB"/></td>
                            <td><xsl:value-of select="ScoreA"/>-<xsl:value-of select="ScoreB"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>