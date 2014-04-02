package Item.Items;

import java.util.List;

import CreativeTabs.CWCreativeTabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import Item.Technical.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Wrench extends Item 
{
	@SideOnly(Side.CLIENT)
	private Icon WrenchActivatedIcon1;
	private Icon WrenchActivatedIcon2;
	private Icon WrenchActivatedIcon3;
	
	@SideOnly(Side.CLIENT)
	private Icon WrenchDeactivatedIcon;
	
	private String WrenchType;
	private int WrenchTypeID;
	
	private int MODE_Deactivaed = 0;
	private int MODE_TimeShifting = 1;
	private int MODE_CwMachine = 2;
	
	
	public Wrench (int id) 
	{
		super (id);
		setCreativeTab(CWCreativeTabs.ClockworkItemTab);
		setMaxStackSize(1);
		setUnlocalizedName(ItemInfo.WrenchUnlocalized);
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		WrenchDeactivatedIcon = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.WrenchTextureDeactivated);
		WrenchActivatedIcon1 = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.WrenchTextureActivated01);
		WrenchActivatedIcon2 = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.WrenchTextureActivated02);
		WrenchActivatedIcon3 = register.registerIcon(ItemInfo.Texture_Location + ":" + ItemInfo.WrenchTextureActivated03);
	}


    @SideOnly(Side.CLIENT)
	public ItemStack onItemRightClick(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hit)
    {

        int l = world.getBlockMetadata(x,y,z);
        double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.7F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

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
        world.spawnParticle("spell",            d0, d3 + d1, d2 - d4, 0.0D, 0.0D, 0.0D);

		if (isActivated(item.getItemDamage()))
		{
			player.addChatMessage("Im activated");
		}
		if (isDeactivated(item.getItemDamage()))
		{
			player.addChatMessage("Im Deactivated");
		}
		
		return item;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation) 
	{
		info.add("Wrench Mode: " + getWrenchType() + " ("+ getWrenchTypeID() + ")");
	}
	
	public String getWrenchType() {
		return WrenchType;
	}
			
	public int getWrenchTypeID(){
		return WrenchTypeID;
	}
	
	public void setWrenchType(String type){
		WrenchType = type;
	}
	
	private void setWrenchTypeID(int type){
		WrenchTypeID = type;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		if(getWrenchTypeID() == MODE_TimeShifting){
			return WrenchActivatedIcon1;
		}else if(getWrenchTypeID() == MODE_CwMachine){
			return WrenchActivatedIcon2;
		}
		return WrenchDeactivatedIcon;
	}
	
	private boolean isActivated(int dmg)
	{
		return dmg >= 2;
	}
	private boolean isDeactivated(int dmg)
	{
		return dmg <= 2;
	}
	
	public void changeWrench(){
		if(getWrenchTypeID() == 0){
			setWrenchType("Time Shifter");
			setWrenchTypeID(MODE_TimeShifting);
			
		}else if(getWrenchTypeID() == 1){
			setWrenchType("Machine Mode");
			setWrenchTypeID(MODE_CwMachine);
			
		}else if(getWrenchTypeID() == 2){
			setWrenchType("Deactivated");
			setWrenchTypeID(MODE_Deactivaed);
		}
	}
}