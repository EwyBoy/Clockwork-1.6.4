package Block.Blocks;

import Block.Technical.BlockInfo;
import CreativeTabs.CWCreativeTabs;
import Item.Technical.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

import java.util.List;

public class Metals extends Block
{
    public Metals(int par1, boolean par2)
    {
        super(par1, Material.iron);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
    }

    public int getMetadata (int damageValue)
    {
        return damageValue;
    }

    @Override
    public int damageDropped (int metadata)
    {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1,CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 5; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }

    public String getUnlocalizedName (ItemStack itemstack)
    {
        return ItemInfo.IngotUnlocalized + itemstack.getItemDamage();
    }

    @SideOnly (Side.CLIENT)
    private Icon [] TextureIcons;

    @Override
    @SideOnly (Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        TextureIcons = new Icon[ItemInfo.IngotTexture.length];
        for (int i = 0; i < TextureIcons.length; i++)
        {
            TextureIcons [i] = register.registerIcon(ItemInfo.Texture_Location + ":" + BlockInfo.MetalsTexture[i]);
        }
    }

    @SideOnly (Side.CLIENT)
    public Icon getIconFromDamage (int dmg)
    {
        return TextureIcons [dmg];
    }

}
