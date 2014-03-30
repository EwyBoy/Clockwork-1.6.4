package KeyBindings;

import Item.Items.Wrench;
import Item.Technical.Items;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;

import java.util.EnumSet;

public class WrenchKeyBind extends KeyHandler{

		private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
         
         boolean canPress = true;
         
         public WrenchKeyBind(KeyBinding[] keyBindings, boolean[] repeatings)
         {
                 super(keyBindings, new boolean[]{false});
         }
         @Override
         public String getLabel()
         {
                 return "TutorialKey";
         }
         @Override
         public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
         {
        	 if(canPress){
        		 canPress = false;
        		 ((Wrench) Items.Wrench).changeWrench();
        	 }
         }
         @Override
         public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
         {
        	canPress = true; 
         }
         @Override
         public EnumSet<TickType> ticks()
         {
                 return tickTypes;
         }
}

