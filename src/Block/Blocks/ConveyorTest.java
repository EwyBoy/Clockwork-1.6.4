package Block.Blocks;

import Block.Technical.BlockInfo;
import Block.Texture.TextureHandler;
import CreativeTabs.CWCreativeTabs;
import TechnicalTools.Coordinate;
import Tile.TileEntity.TileEntityConveyor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class ConveyorTest extends BlockRail
{
    public ConveyorTest(int par1, boolean par2)
    {
        super(par1);
        setHardness(1.0F);
        setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
        setBlockBounds(0.0F, 0F, 0.0F, 1.0F, 1F, 1.0F);
        setUnlocalizedName(BlockInfo.ConveyorUnlocalized);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.975F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        double MovementSpeed = 0.05;
        int a = world.getBlockMetadata(x, y, z);
        int ax[] = {0, 1, 0, -1};
        int az[] = { -1, 0, 1, 0};

        //if (entity != null && entity.posY > (y + 0.5)  && !entity.isSneaking())
        {
            entity.addVelocity(MovementSpeed, 0.0, 0.0);
            entity.stepHeight = 1.0F;
        }
        //Move to center of conveyor
        if (ax[a] == 0 & Math.abs(x + 0.5 - entity.posX) < 0.5 & Math.abs(x + 0.5 - entity.posX) > 0.1)
        {
            entity.motionX += Math.signum(x + 0.5 - entity.posX) * Math.min(MovementSpeed, Math.abs(x + 0.5 - entity.posX)) / 1.2;
        }

        if (az[a] == 0 & Math.abs(z + 0.5 - entity.posZ) < 0.5 & Math.abs(z + 0.5 - entity.posZ) > 0.1)
        {
            entity.motionZ += Math.signum(z + 0.5 - entity.posZ) * Math.min(MovementSpeed, Math.abs(z + 0.5 - entity.posZ)) / 1.2;
        }

        //Jump entities up
        if (entity instanceof EntityItem)
            if (world.getBlockId(x, y + 2, z) == 0 & world.getBlockId(x + ax[a], z + 1, y + az[a]) == this.blockID)
            {
                double progress = (entity.posX - x - 0.5) * ax[a] + (entity.posZ - y - 0.5) * az[a];
                double prog_speed = entity.motionX * ax[a] + entity.motionZ * az[a];
                double prog_counterspeed = Math.abs(entity.motionX * az[a] + entity.motionZ * ax[a]);

                if (progress > 0 | (progress > -0.2 & prog_speed < 0))
                {
                    a = (a + 2) % 4;
                }
                else if (progress + 1.5 * prog_speed > 0 & prog_speed >= MovementSpeed & prog_counterspeed < 0.2)
                {
                    entity.moveEntity(0, 0.05, 0);
                    entity.isAirBorne = true;

                    if (ax[a] == 0)
                    {
                        entity.motionX = 0;
                    }

                    if (az[a] == 0)
                    {
                       entity.motionZ = 0;
                    }

                    //par5Entity.motionX = ax[a] * m_speed;
                    //par5Entity.motionY = 0.2;
                    //par5Entity.motionZ = az[a] * m_speed;
                    entity.addVelocity(0, 0.19, 0);
                    entity.setVelocity(entity.motionX, entity.motionY, entity.motionZ);
                    return;
                }
            }


    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,EntityLivingBase entity, ItemStack par6ItemStack) {
        int facing = MathHelper.floor_double((entity.rotationYaw * 4F) / 360F + 0.5D) & 3;
        System.out.println(facing);
        new TileEntityConveyor().setDir(facing, new Coordinate(par2, par3, par4));
    }

    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean isOpaqueCube()
    {
        return false;
        //return true;
    }
    public boolean isBlockSolid()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    private Icon Texture;

    @SideOnly(Side.CLIENT)
    private Icon TextureTurn;

    @SideOnly(Side.CLIENT)
    private Icon Textures;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register)
    {
        Texture = register.registerIcon(TextureHandler.TextureLocation + ":" +  BlockInfo.ConveyorTexture);
        TextureTurn = register.registerIcon(TextureHandler.TextureLocation + ":" +  BlockInfo.ConveyorTextureTurn);
    }



    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean useExtraInformation)
    {
        info.add("Used for transporing,");
        info.add("varius stuff around your world");
    }


    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta)
    {
        if (meta >= 6)
        {
            return TextureTurn;
        }
        else if (meta <= 6)
        {
            return Texture;
        }
        return Texture;

    }


}