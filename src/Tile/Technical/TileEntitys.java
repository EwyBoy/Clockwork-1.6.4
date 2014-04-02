/**package Tile.Technical;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.tileentity.TileEntity;
//import Tile.TileEntity.PowerNetworkCabel;

public class TileEntitys
{
    public static TileEntity PowerNetworkCabel;

        public static void registerTileEntities()
        {
            GameRegistry.registerTileEntity(PowerNetworkCabel.class, TileEntityInfo.PowerNetworkCabelKey);
        }

    public static void addNames()
    {
        LanguageRegistry.addName(PowerNetworkCabel, TileEntityInfo.PowerNetworkCabelName);
    }

}
*/