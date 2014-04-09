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
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class Router extends Block
    {
        public Router(int par1, boolean par2)
        {
            super(par1, Material.glass);
            setCreativeTab(CWCreativeTabs.ClockworkBlockTab);
            setUnlocalizedName(BlockInfo.RouterUnlocalized);
            setLightValue(0.750F);
            setLightOpacity(1);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
        {

        }

        @SideOnly(Side.CLIENT)
        private Icon TextureIcon;

        @SideOnly(Side.CLIENT)
        private Icon TextureIconSide;

        @SideOnly(Side.CLIENT)
        @Override

        public void registerIcons(IconRegister register)
        {
            TextureIcon = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.RouterTopTexture);
            TextureIconSide = register.registerIcon(TexturePath.TextureLocation + ":" +  BlockInfo.RouterSideTexture);
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


