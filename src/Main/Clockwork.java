package Main;

    import Block.Technical.Blocks;
import Config.ConfigHandler;
import CreativeTabs.CWCreativeTabs;
import Info.ModInfo;
import Item.Technical.Items;
import Network.PacketHandler;
import Network.Proxies.CommonProxy;
import Crafting.registerRecipies;
import Crafting.registerSmelting;
import TechnicalTools.TickHandler;
import WorldGen.Technical.Ores;
import WorldGen.WorldGenerator.WorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

    @Mod (modid = ModInfo.ID, name = ModInfo.Name, version = ModInfo.Version)
    @NetworkMod (channels = {ModInfo.Channel}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

    public class Clockwork
    {
	    @Instance (ModInfo.ID)
	    public static Clockwork instance;
	
	    @SidedProxy(bukkitSide = "", modId = ModInfo.ID, clientSide = "Network.Proxies.ClientProxy", serverSide = "Network.Proxies.CommonProxy")
	    public static CommonProxy proxy;

	@EventHandler
	public void PreInit (FMLPreInitializationEvent event)
	{
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		proxy.initSounds();
		proxy.initRenders();
		proxy.registerRenderers();
		proxy.registerRenderThings();
		Blocks.init();
        Items.init();
        Ores.init();
        WorldGenerator.init();

    }

	@EventHandler
	public void load (FMLInitializationEvent event)
	{
        Blocks.addNames();
        Ores.addNames();
		registerRecipies.registerRecipe();
        registerSmelting.registerSmelting();
        Items.RegisterItems();
        Items.addNames();
        CWCreativeTabs.AddCreativeTabs();
        TickRegistry.registerTickHandler(new TickHandler(), Side.CLIENT);
	}
	
	
	@EventHandler
	public void ModsLoaded (FMLPreInitializationEvent event)
	{}


}
