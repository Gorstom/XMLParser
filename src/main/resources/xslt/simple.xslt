<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <xsl:template match="/">
        <xsl:for-each select="Matches/Match">
            <xsl:value-of select="TeamA"/> vs <xsl:value-of select="TeamB"/>:
            <xsl:value-of select="ScoreA"/>-<xsl:value-of select="ScoreB"/>
            <xsl:text>&#10;</xsl:text>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>