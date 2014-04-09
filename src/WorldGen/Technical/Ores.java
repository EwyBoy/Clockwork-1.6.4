package WorldGen.Technical;

import WorldGen.Ores.OreCopper;
import WorldGen.Ores.OreTin;
import WorldGen.Ores.OreZinc;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class Ores
  {
        public static Block OreCopper;
        public static Block OreTin;
        public static Block OreZinc;

        public static void init()
        {
            registerOres();
            addNames();
        }

        private static void registerOres()
        {
            OreCopper = new OreCopper (OreInfo.OreCopperID, false).setUnlocalizedName(OreInfo.OreCopperUnlocalized);
            GameRegistry.registerBlock(OreCopper, OreInfo.OreCopperKey);
           // OreDictionary.registerOre(OreInfo.OreTinName,OreTin);

            OreTin = new OreTin (OreInfo.OreTinID, false).setUnlocalizedName(OreInfo.OreTinUnlocalized);
            GameRegistry.registerBlock(OreTin, OreInfo.OreTinKey);
            //OreDictionary.registerOre(OreInfo.OreCopperName,OreCopper);

            OreZinc = new OreZinc (OreInfo.OreZincID, false).setUnlocalizedName(OreInfo.OreZincUnlocalized);
            GameRegistry.registerBlock(OreZinc, OreInfo.OreZincKey);
            //OreDictionary.registerOre(OreInfo.OreZincName,OreTin);
        }

        public static void addNames()
        {
            LanguageRegistry.addName(OreCopper, OreInfo.OreCopperName);
            LanguageRegistry.addName(OreTin, OreInfo.OreTinName);
            LanguageRegistry.addName(OreZinc, OreInfo.OreZincName);
        }
  }
