package Block;

import Block.Technical.BlockInfo;
import Item.Technical.ItemInfo;
import Tech.CWCreativeTabs;
import Textures.TexturePath;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Fan extends Block
{

    public Fan(int par1, boolean par2)
    {
        super(par1, Material.glass);
        setCreativeTab(CWCreativeTabs.ClockworkTab);
        setUnlocalizedName(BlockInfo.FanUnlocalized);
        setLightValue(0.750F);
        setLightOpacity(1);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.05F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ((EntityPlayer) entity).addChatMessage("§4Just telling you I'am working");
        }

        if(entity.onGround = true)
        {
            entity.addVelocity(0.0,0.75,0.0);
        }

    }

    @SideOnly(Side.CLIENT)
    private Icon Fan01;
    @SideOnly(Side.CLIENT)
    private Icon Fan02;
    @SideOnly(Side.CLIENT)
    private Icon Fan03;
    @SideOnly(Side.CLIENT)
    private Icon Fan04;
    @SideOnly(Side.CLIENT)
    private Icon Fan05;
    @SideOnly(Side.CLIENT)
    private Icon Fan06;
    @SideOnly(Side.CLIENT)
    private Icon Fan07;
    @SideOnly(Side.CLIENT)
    private Icon Fan08;
    @SideOnly(Side.CLIENT)
    private Icon Fan09;
    @SideOnly(Side.CLIENT)
    private Icon Fan10;

    @SideOnly(Side.CLIENT)
    private Icon TextureIconSide;

    @SideOnly(Side.CLIENT)
    @Override

    public void registerIcons(IconRegister register)
    {
        Fan01 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture01);
        Fan02 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture02);
        Fan03 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture03);
        Fan04 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture04);
        Fan05 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture05);
        Fan06 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture06);
        Fan07 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture07);
        Fan08 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture08);
        Fan09 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture09);
        Fan10 = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.FanTexture10);

        TextureIconSide = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.TransTextureSide);
    }

    public void blabla (){
       int Fan01 = 1;

    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int meta)
    {

        if (side == 1)
        {
            return Fan01;
        }
        else if (side == 0)
        {
            return TextureIconSide;
        }
        return TextureIconSide;
    }

}
