    package Tech;

    import cpw.mods.fml.common.ITickHandler;
    import cpw.mods.fml.common.TickType;
    import net.minecraft.client.Minecraft;
    import net.minecraft.client.gui.GuiScreen;
    import Block.Blocks.Fan;

    import java.util.EnumSet;



    public class TickHandler implements ITickHandler {



        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
        }
        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
            if(type.equals(EnumSet.of(TickType.RENDER)))
            {
                onRenderTick();
            }
            else
            if(type.equals(EnumSet.of(TickType.CLIENT)))
            {
                Minecraft mc = Minecraft.getMinecraft();
                GuiScreen gui = mc.currentScreen;
                if(gui != null)
                {
                    onTickInGui(mc, gui);
                }
                else
                {
                    onTickInGame(mc);
                }
            }
        }
        private void onTickInGame(Minecraft mc)
        {
            // DO STUFF HERE

           Block.Blocks.Fan.UpdateTexture();
        }
        private void onTickInGui(Minecraft mc, GuiScreen gui)
        {
        }
        private void onRenderTick()
        {

        }
        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.CLIENT, TickType.RENDER);
        }
        @Override
        public String getLabel()
        {
            return "TickHandler.CLIENT";
        }
    }
