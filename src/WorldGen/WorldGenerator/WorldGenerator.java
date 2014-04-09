package WorldGen.WorldGenerator;

import WorldGen.WorldGenerator.OreWorldGen.WorldGeneratorCopper;
import WorldGen.WorldGenerator.OreWorldGen.WorldGeneratorTin;
import WorldGen.WorldGenerator.OreWorldGen.WorldGeneratorZinc;
import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGenerator
{
    public static void init()
    {
        registerWorldGen();
    }

    public static void registerWorldGen()
    {
        GameRegistry.registerWorldGenerator(new WorldGeneratorCopper());
        GameRegistry.registerWorldGenerator(new WorldGeneratorTin());
        GameRegistry.registerWorldGenerator(new WorldGeneratorZinc());
    }


}
