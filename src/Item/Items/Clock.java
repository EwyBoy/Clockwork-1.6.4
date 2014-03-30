package Item.Items;

import Item.Technical.ItemInfo;
import Tech.CWCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Clock extends Item
{
    private int counter = 20;

    public Clock(int id) 
	{
		super(id);
		setCreativeTab(CWCreativeTabs.ClockworkTab);
		setMaxStackSize(1);
		setMaxDamage(5);
		setUnlocalizedName(ItemInfo.ClockUnlocalized);
	}
	
	 public int getItemEnchantability()
	    {
	        return 1;
	    }
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 72000;
	    }
	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        return par1ItemStack;
	    }
	 
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean  itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase target)
	{	
		if (!target.worldObj.isRemote) 
		{
			target.motionX = (target.posX - player.posX / 1);
			target.motionZ = (target.posZ - player.posZ / 1);
			target.motionY = (target.posY - player.posY / 1);
		}
		
		return false;
	}



    @Override
	@SideOnly(Side.CLIENT)
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit) 
	{

        counter--;
        if(counter == 0){
            counter=20;
            player.addChatMessage("§3§lFlash §3§5Activated");
            player.inventory.consumeInventoryItem(Item.enderPearl.itemID);

            double X = player.posX;
            double Z = player.posZ;

            int test = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
            if (test == 1) {
                X = X - 1.75;
            }
            if (test == 3) {
                X = X + 1.75;
            }
            if (test == 2) {
                Z = Z - 1.75;
            }
            if (test == 0) {
                Z = Z + 1.75;
            }
            player.moveEntity(X, 0.0, Z);
            player.setPosition(X, player.posY, Z);

            if (player.onGround = true)
            {
                player.fallDistance = 0;
            }


        }

        return true;
    }

	
	@SideOnly(Side.CLIENT)
	private Icon ClockIcons;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		ClockIcons = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.ClockTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage (int dmg)
	{
		return ClockIcons;
	}
}
