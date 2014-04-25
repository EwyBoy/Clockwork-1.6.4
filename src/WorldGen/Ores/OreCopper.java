package WorldGen.Ores;

import CreativeTabs.CWCreativeTabs;
import Textures.TexturePath;
import WorldGen.Technical.OreInfo;
import WorldGen.Technical.Ores;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import java.util.Random;

public class OreCopper extends Block
{
    public OreCopper(int par1, boolean par2)
    {
        super(par1, Material.rock);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
        setUnlocalizedName(OreInfo.OreCopperUnlocalized);
        setHardness(5.0F);
    }

    @SideOnly(Side.CLIENT)
    private Icon TextureIcon;

    public void registerIcons(IconRegister register)
    {
        TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  OreInfo.OreCopperTexture);
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Ores.OreCopper.blockID;
    }
    public int quantityDropped(Random random)
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {
        if (side == 1)
        {
            return TextureIcon;
        }
        else if (side == 0)
        {
            return TextureIcon;
        }
        return TextureIcon;
    }

}