package Item.Items;

import CreativeTabs.CWCreativeTabs;
import Item.Technical.ItemInfo;
import Main.Clockwork;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class Clock extends Item
{
    public Clock(int id) 
	{
		super(id);
		setCreativeTab(CWCreativeTabs.ClockworkItemTab);
		setMaxStackSize(1);
		setMaxDamage(5);
		setUnlocalizedName(ItemInfo.ClockUnlocalized);
    }

    public static final String[] ClockActivated = new String[] {"Clock", "Clock 1", "Clock 2"};
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("§e§oNo time to lose?");
        info.add("§eThis clock will fix that!");

        if (Clockwork.proxy.shiftPressed() == true)
        {
            info.add("Who the hell wants doors inside their house?");
            info.add("This item allows you to swap through the wall");
            info.add("and maybe back again?");
        }
    }
    public int getItemEnchantability()
	    {
	        return 1;
	    }
    public Icon getItemIconForUseDuration(int par1)
    {
        return this.iconArray[par1];
    }
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 72000;
	    }
	 public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        return par1ItemStack;
	    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
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

	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit)
	{
             int l = world.getBlockMetadata(x,y,z);
             double d0 = (double)((float)x + 0.5F);
             double d1 = (double)((float)y + 0.7F);
             double d2 = (double)((float)z + 0.5F);
             double d3 = 0.2199999988079071D;
             double d4 = 0.27000001072883606D;

            world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "mob.endermen.portal", 0.5F, hitY * 0.4F + 0.8F, false);

           /** world.spawnParticle("mobSpellAmbient",  d0, d1 - d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("magicCrit",        d0, d1 - d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("crit",             d0, d1 + d3, d4 - d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("depthsuspend",     d0, d1 + d3, d4 - d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("mobSpell",         d0, d1 - d3, d4 + d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("instantSpell",     d0, d1 - d3, d4 + d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("happyVillager",    d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("snowballpoof",     d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("reddust",          d0, d3 - d1, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("cloud",            d0, d3 - d1, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("witchMagic",       d0, d3 + d1, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("mobSpellAmbient",  d0, d1 - d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("magicCrit",        d0, d1 - d3, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("crit",             d0, d1 + d3, d4 - d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("depthsuspend",     d0, d1 + d3, d4 - d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("mobSpell",         d0, d1 - d3, d4 + d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("instantSpell",     d0, d1 - d3, d4 + d2, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("happyVillager",    d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("snowballpoof",     d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("reddust",          d0, d3 - d1, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("cloud",            d0, d3 - d1, d2 + d4, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("witchMagic",       d0, d3 + d1, d2 - d4, 0.0D, 0.0D, 0.0D);
*/
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);
            world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, player.posX, player.posY, player.posZ);


        player.addChatMessage("§6§oFlash §e§oActivated");
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

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
    }
}
