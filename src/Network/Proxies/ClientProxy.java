package Network.Proxies;


import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initSounds()
	{
		
	}
	
	
	@Override
	public void initRenders()
	{
		
	}
	

	public void registerRenderThings() 
	{
	
	}

    public boolean shiftPressed()
    {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
    }
}