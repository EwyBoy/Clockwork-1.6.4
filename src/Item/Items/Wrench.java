package Item.Items;

import java.util.List;

import Tech.CWCreativeTabs;
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
		setCreativeTab(CWCreativeTabs.ClockworkTab);
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

	@Override
	public ItemStack onItemRightClick(ItemStack item, World world,EntityPlayer player) 
	{
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