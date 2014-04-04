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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import java.util.Random;

public class Fan extends Block {

    private static String Fan_Texture = TexturePath.TextureLocation + ":" + BlockInfo.FanTexture01;

    public Fan(int par1, boolean par2)
    {
        super(par1, Material.anvil);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
        setUnlocalizedName(BlockInfo.FanUnlocalized);
        setLightValue(0.750F);
        setLightOpacity(1);
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        double d0 = (double) ((float) par2 + 0.5F);
        double d1 = (double) ((float) par3 + 0.7F);
        double d2 = (double) ((float) par4 + 0.5F);

        if (l == 1) {
        } else {
            par1World.spawnParticle("lava", d0, d1, d2, 100.0D, 100.0D, 100.0D);
            par1World.spawnParticle("lava", d0, d1, d2, 100.0D, 100.0D, 100.0D);
            par1World.spawnParticle("lava", d0, d1, d2, 100.0D, 100.0D, 100.0D);
        }

    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
        float f = 0.01F;
        return AxisAlignedBB.getAABBPool().getAABB((double) par2, (double) par3, (double) par4, (double) (par2 + 1), (double) ((float) (par3 + 1) - f), (double) (par4 + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            ((EntityPlayer) entity).addChatMessage("§6§lFly! Fly little bird! Fly!");
        }

        if (entity.onGround = true) {
            entity.addVelocity(0.0, 0.75, 0.0);
        }

    }

    private static int texture_clock = 0;

    @SideOnly(Side.CLIENT)
    static
    String[] FanTexture = new String[]{
            TexturePath.TextureLocation + ":" + BlockInfo.FanTexture01, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture02,
            TexturePath.TextureLocation + ":" + BlockInfo.FanTexture03, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture04, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture05,
            TexturePath.TextureLocation + ":" + BlockInfo.FanTexture06, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture07, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture08,
            TexturePath.TextureLocation + ":" + BlockInfo.FanTexture09, TexturePath.TextureLocation + ":" + BlockInfo.FanTexture10};



    public static void UpdateTexture() {
        if(texture_clock >= 10){
            texture_clock = 0;
        }else if(texture_clock == 0){
            texture_clock++;
        }else{
            Fan_Texture = FanTexture[texture_clock];
            texture_clock++;
        }
    }

    @SideOnly(Side.CLIENT)
    private static Icon Fan01;

    @SideOnly(Side.CLIENT)
    private Icon TextureIconSide;


    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        TextureIconSide = register.registerIcon(TexturePath.TextureLocation + ":" + BlockInfo.TransTextureSide);
        Fan01 = register.registerIcon(Fan_Texture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {

        if (side == 1) {
            return Fan01; //Update this texture 10 times a second, thats a new texture update every 2 minecraft tick!
        } else if (side == 0) {
            return TextureIconSide;
        }
        return TextureIconSide;
    }

}