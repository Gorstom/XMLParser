<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:template match="/">
        Ilość meczów: <xsl:value-of select="count(Matches/Match)"/>
        <xsl:text>&#10;</xsl:text>
        Średnia goli/mecz:
        <xsl:value-of select="sum(Matches/Match/(ScoreA + ScoreB)) div count(Matches/Match)"/>
    </xsl:template>
</xsl:stylesheet>