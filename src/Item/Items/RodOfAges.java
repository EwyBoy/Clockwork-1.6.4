package Item.Items;

import CreativeTabs.CWCreativeTabs;
import Item.Technical.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import java.util.List;

public class RodOfAges extends Item
{
    public RodOfAges(int id)
    {
        super(id);
        setCreativeTab(CWCreativeTabs.ClockworkItemTab);
        setMaxStackSize(1);
        setUnlocalizedName(ItemInfo.RodOfAgesUnlocalized);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit)
    {
        if (player.isSneaking() == true)
        {
            //Store player pos and draw a texture onto the block im standing on if possible
        }

        // If (player.pos =< within 10 away from stored pos)
        {
            //When right clicking I want to teleport / swap back to the stored location
        }

        if (player.isSneaking() == true)
        {
            player.getPlayerCoordinates();
            player.getPosition(0f);

            double X = player.posX;
            double Y = player.posY;
            double Z = player.posZ;
        }

        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("§e§oEver wanted to travel back in time?");
        info.add("§eThis rod will fix that!");
    }

    public int getItemEnchantability()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    private Icon RodOfAgesIcons;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        RodOfAgesIcons = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.RodOfAgesTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage (int dmg)
    {
        return RodOfAgesIcons;
    }

}