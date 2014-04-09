package WorldGen.Ores;

import CreativeTabs.CWCreativeTabs;
import Textures.TexturePath;
import WorldGen.Technical.OreInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class OreTin extends Block
{
    public OreTin(int par1, boolean par2)
    {
        super(par1, Material.rock);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
        setUnlocalizedName(OreInfo.OreTinUnlocalized);
        setHardness(5.0F);
    }

    @SideOnly(Side.CLIENT)
    private Icon TextureIcon;

    public void registerIcons(IconRegister register)
    {
        TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  OreInfo.OreTinTexture);
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