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

    public Fan(int par1, boolean par2)
    {
        super(par1, Material.anvil);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
        setUnlocalizedName(BlockInfo.FanUnlocalized);
        setLightValue(0.750F);
        setLightOpacity(1);
    }

    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
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

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.01F;
        return AxisAlignedBB.getAABBPool().getAABB((double) par2, (double) par3, (double) par4, (double) (par2 + 1), (double) ((float) (par3 + 1) - f), (double) (par4 + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ((EntityPlayer) entity).addChatMessage("§6§lFly! Fly little bird! Fly!");
            world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "mob.irongolem.throw", 0.5F, 1 * 0.4F + 0.8F, false);
        }

        if (entity.onGround = true)
        {
            entity.addVelocity(0.0, 0.35, 0.0);
            if (entity.posY < entity.posY + 1)
            {
                entity.addVelocity(0.0, 1.0, 0.0);
            }
        }

    }

    @SideOnly(Side.CLIENT)
    private static Icon FanTexture;

    @SideOnly(Side.CLIENT)
    private Icon TextureIconSide;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        TextureIconSide = register.registerIcon(TexturePath.TextureLocation + ":" + BlockInfo.TransTextureSide);
        FanTexture = register.registerIcon(TexturePath.TextureLocation + ":" + BlockInfo.FanTexture);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {

        if (side == 1)
        {
            return FanTexture;
        }

        else if (side == 0)
        {
            return TextureIconSide;
        }
        return TextureIconSide;
    }

}