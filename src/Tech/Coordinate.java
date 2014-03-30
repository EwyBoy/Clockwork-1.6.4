package Tech;

public class Coordinate {
	int x;
	int y;
	int z;
	
	public Coordinate(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getZ(){
		return z;
	}

	public boolean isRemote(int x2, int y2, int z2) 
	{
		return false;
	}
	
}
