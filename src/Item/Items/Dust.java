package Item.Items;

import java.util.List;

import Item.Technical.ItemInfo;
import CreativeTabs.CWCreativeTabs;
import Item.Technical.Items;
import Main.Clockwork;
import Network.Proxies.ClientProxy;
import Network.Proxies.CommonProxy;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkListenThread;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Dust extends Item
{
    @SideOnly (Side.CLIENT)
    private Icon [] icons;

    public Dust(int id)
    {
        super(id);
        setCreativeTab(CWCreativeTabs.ClockworkItemTab);
        setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName (ItemStack itemstack)
    {
        return ItemInfo.DustUnlocalized + itemstack.getItemDamage();
    }


    @Override
    @SideOnly (Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        icons = new Icon [ItemInfo.DustTexture.length];
        for (int i = 0; i < icons.length; i++)
        {
            icons [i] = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.DustTexture[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("§eA dust added by §6§o§lClockwork");

       if (Clockwork.proxy.shiftPressed() == true)
            {
                info.add("Piles of dust can be crafted using ingots");
                info.add("they can also be smelted back into ingots");
            }

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
        for (int i = 0; i < ItemInfo.DustNames.length; i ++)
        {
            ItemStack stack = new ItemStack (id, 1, i);
            list.add(stack);
        }
    }


}
