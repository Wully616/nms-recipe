package com.wully.nmsrecipe.loader;

import org.junit.Test;

public class EXMLReaderTest {

    private static final String substanceXML = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<!--File created using MBINCompiler version (1.78.0)-->\n" +
            "<Template template=\"GcSubstanceTable\">\n" +
            "  <Property name=\"Table\">\n" +
            "    <Property value=\"GcRealitySubstanceData.xml\">\n" +
            "      <Property name=\"Name\" value=\"UI_FUEL_1_NAME\" />\n" +
            "      <Property name=\"NameLower\" value=\"UI_FUEL_1_NAME_L\" />\n" +
            "      <Property name=\"ID\" value=\"FUEL1\" />\n" +
            "      <Property name=\"Symbol\" value=\"UI_FUEL1_SYM\" />\n" +
            "      <Property name=\"Icon\" value=\"TkTextureResource.xml\">\n" +
            "        <Property name=\"Filename\" value=\"TEXTURES/UI/FRONTEND/ICONS/U4SUBSTANCES/SUBSTANCE.FUEL.1.DDS\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"DebrisFile\" value=\"TkTextureResource.xml\">\n" +
            "        <Property name=\"Filename\" value=\"MODELS/EFFECTS/DEBRIS/RESOURCEDEBRIS.SCENE.MBIN\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"Subtitle\" value=\"VariableSizeString.xml\">\n" +
            "        <Property name=\"Value\" value=\"UI_FUEL1_SUB\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"Description\" value=\"VariableSizeString.xml\">\n" +
            "        <Property name=\"Value\" value=\"UI_FUEL_1_DESC\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"Colour\" value=\"Colour.xml\">\n" +
            "        <Property name=\"R\" value=\"0.7333333\" />\n" +
            "        <Property name=\"G\" value=\"0.2196078\" />\n" +
            "        <Property name=\"B\" value=\"0.1882353\" />\n" +
            "        <Property name=\"A\" value=\"1\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"WorldColour\" value=\"Colour.xml\">\n" +
            "        <Property name=\"R\" value=\"0.7333333\" />\n" +
            "        <Property name=\"G\" value=\"0.2196078\" />\n" +
            "        <Property name=\"B\" value=\"0.1882353\" />\n" +
            "        <Property name=\"A\" value=\"1\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"BaseValue\" value=\"12\" />\n" +
            "      <Property name=\"Category\" value=\"GcRealitySubstanceCategory.xml\">\n" +
            "        <Property name=\"SubstanceCategory\" value=\"Fuel\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"Rarity\" value=\"GcRarity.xml\">\n" +
            "        <Property name=\"Rarity\" value=\"Common\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"Legality\" value=\"GcLegality.xml\">\n" +
            "        <Property name=\"Legality\" value=\"Legal\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"ChargeValue\" value=\"1\" />\n" +
            "      <Property name=\"StackMultiplier\" value=\"1\" />\n" +
            "      <Property name=\"Cost\" value=\"GcItemPriceModifiers.xml\">\n" +
            "        <Property name=\"SpaceStationMarkup\" value=\"0\" />\n" +
            "        <Property name=\"LowPriceMod\" value=\"-0.1\" />\n" +
            "        <Property name=\"HighPriceMod\" value=\"0.1\" />\n" +
            "        <Property name=\"BuyBaseMarkup\" value=\"0.25\" />\n" +
            "        <Property name=\"BuyMarkupMod\" value=\"0\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"NormalisedValueOnWorld\" value=\"4.487181E-07\" />\n" +
            "      <Property name=\"NormalisedValueOffWorld\" value=\"4.487181E-07\" />\n" +
            "      <Property name=\"tradeCategory\" value=\"GcTradeCategory.xml\">\n" +
            "        <Property name=\"TradingClass\" value=\"None\" />\n" +
            "      </Property>\n" +
            "      <Property name=\"WikiEnabled\" value=\"True\" />\n" +
            "      <Property name=\"EconomyInfluenceMultiplier\" value=\"0.25\" />\n" +
            "      <Property name=\"PinObjective\" value=\"UI_GATHER_OBJ\" />\n" +
            "      <Property name=\"PinObjectiveTip\" value=\"UI_PIN_FUEL1_OBJ_TIP\" />\n" +
            "    </Property>\n" +
            "  </Property>\n" +
            "  <Property name=\"Crafting\" />\n" +
            "</Template>\t";
    @Test
    public void serializeSubstanceXml() throws Exception {
        //prepare
        EXMLReader exmlReader = new EXMLReader();
        //act


        System.out.println(exmlReader.deserialzeExml(substanceXML));
        //assert
    }
}
