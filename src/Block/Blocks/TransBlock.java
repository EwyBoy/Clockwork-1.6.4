package Block.Blocks;

import Block.Technical.BlockInfo;
import CreativeTabs.CWCreativeTabs;
import Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class TransBlock extends Block
{
	public TransBlock(int par1, boolean par2) 
	{
		super(par1, Material.glass);
		setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
		setUnlocalizedName(BlockInfo.TransUnlocalized);
		setLightValue(0.750F);
		setLightOpacity(1);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
	    float f = 0.05F;
	    return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
	}

	public String posToString(int x, int y, int z) 
	{
        return x + " " + y + " " + z;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{

        int l = world.getBlockMetadata(x,y,z);
        double d0 = (double)((float)x + 0.5F);
        double d1 = (double)((float)y + 0.7F);
        double d2 = (double)((float)z + 0.5F);
        double d3 = 0.2199999988079071D;
        double d4 = 0.27000001072883606D;

		if(entity instanceof EntityPlayer) 
		   {
               EntityPlayer player = (EntityPlayer) entity;    
             ((EntityPlayer) entity).addChatMessage("§3§1Just telling you I'am working");
		   }    
		int fCoord = 0;
	       
        if(entity instanceof EntityPlayer)
        {
                EntityPlayer player = (EntityPlayer) entity;
                fCoord = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
        }

        if(entity instanceof EntityItem){

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

                boolean isFound = false;
                ArrayList<String> test = new ArrayList<String>();
                Random random = new Random();
                
 
                EntityItem item = (EntityItem)entity;

                if(world.getBlockId(x - 2, y, z) == this.blockID ) test.add(posToString(x-2, y, z));
                if(world.getBlockId(x + 2, y, z) == this.blockID){  test.add(posToString(x+2, y, z)); }
                if(world.getBlockId(x, y, z - 2) == this.blockID){ test.add(posToString(x, y, z-2)); }
                if(world.getBlockId(x, y, z + 2) == this.blockID){ test.add(posToString(x, y, z+2)); }
                if(world.getBlockId(x + 2, y, z + 2) == this.blockID){ test.add(posToString(x+2, y, z + 2)); }
                if(world.getBlockId(x - 2, y, z + 2) == this.blockID){  test.add(posToString(x-2, y, z+2)); }
                if(world.getBlockId(x + 2, y, z - 2) == this.blockID){  test.add(posToString(x+2, y, z-2)); }
                if(world.getBlockId(x - 2, y, z - 2) == this.blockID){  test.add(posToString(x-2, y, z-2)); }

                int selection = random.nextInt(test.size());
                String posString = test.get(selection);
                String[] POS = posString.split(" ");
                String X = POS[0], Y = POS[1], Z = POS[2];
                int iX = Integer.parseInt(X), iY = Integer.parseInt(Y), iZ = Integer.parseInt(Z);
                entity.setPosition(iX, iY, iZ);
          
        }
         
	}

	@SideOnly(Side.CLIENT)
	private Icon TextureIcon;

	@SideOnly(Side.CLIENT)
	private Icon TextureIconSide;

	@SideOnly(Side.CLIENT)
	@Override
	
	public void registerIcons(IconRegister register)
		{
			TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.TransTexture);
			TextureIconSide = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.TransTextureSide);
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
		return TextureIconSide;
	}
	return TextureIconSide;
	}	

}
