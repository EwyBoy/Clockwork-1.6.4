package Item.Items;

import java.util.List;

import Item.Technical.ItemInfo;
import CreativeTabs.CWCreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Ingot extends Item
{
    @SideOnly (Side.CLIENT)
    private Icon [] icons;

    public Ingot(int id)
    {
        super(id);
        setCreativeTab(CWCreativeTabs.ClockworkItemTab);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return ItemInfo.IngotUnlocalized + itemstack.getItemDamage();
    }


    @Override
    @SideOnly (Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        icons = new Icon [ItemInfo.IngotTexture.length];
        for (int i = 0; i < icons.length; i++)
        {
            icons [i] = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.IngotTexture[i]);
        }
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("§eUsed for Crafting,");
        info.add("§evarious stuff in §6§o§lClockwork");
    }

    @Override
    @SideOnly (Side.CLIENT)
    public Icon getIconFromDamage (int dmg)
    {
        return icons [dmg];
    }

    @SideOnly (Side.CLIENT)
    public void getSubItems ( int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < ItemInfo.IngotNames.length; i ++)
        {
            ItemStack stack = new ItemStack (id, 1, i);
            list.add(stack);
        }
    }


}