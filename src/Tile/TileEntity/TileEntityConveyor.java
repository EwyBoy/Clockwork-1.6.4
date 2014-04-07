package Tile.TileEntity;

import java.util.HashMap;
import java.util.Map;
import TechnicalTools.Coordinate;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityConveyor extends TileEntity
{
	private Map < Coordinate, Integer > hm = new HashMap < Coordinate, Integer >();
	
	public TileEntityConveyor(){}
	
	public void setDir(int newDir , Coordinate c)
	{
		hm.put(c, newDir);
	}
	
	public int getDir(Coordinate c)
	{
		return hm.get(c);
	}
	
	@Override
	public void updateEntity()
	{}

	/** Entity rotation Yaw */
    public float rotationYaw;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
	}

	public boolean getConveyorActive() 
	{
		return false;
	}

	public void updateConveyorActive() 
	{}

}	
