/**package Tile.TileEntity;

import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class PowerNetworkCabel extends TileEntity
{

    private boolean[] isConnected;

    public PowerNetworkCabelModel(){
            model = new PowerNetworkCabelModel();
        }

        public void renderAModelAt(PowerNetworkCabel tileEntity, double d, double d1, double d2, float f) {

            int rotation = 0;
            if(tileEntity.worldObj != null)
            {
                rotation = tileEntity.getBlockMetadata();
            }

            GL11.glPushMatrix();
            GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
            GL11.glScalef(1.0F, -1F, -1F);
            GL11.glRotatef(rotation*90, 0.0F, 1.0F, 0.0F);

            if (tileEntity.isConnected[0])
            {
                model.renderBottom();
            }
            if (tileEntity.isConnected[1])
            {
                model.renderTop();
            }
            if (tileEntity.isConnected[2])
            {
                model.renderFront();
            }
            if (tileEntity.isConnected[3])
            {
                model.renderBack();
            }
            if (tileEntity.isConnected[4])
            {
                model.renderRight();
            }
            if (tileEntity.isConnected[5])
            {
                model.renderLeft();
            }

            model.renderMiddle();
            GL11.glPopMatrix();
        }

        private PowerNetworkCabelModel model;

        public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
        {
            this.renderAModelAt((PowerNetworkCabel)par1TileEntity, par2, par4, par6, par8);
        }
    }

**/