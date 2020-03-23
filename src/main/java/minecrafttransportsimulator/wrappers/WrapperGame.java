package minecrafttransportsimulator.wrappers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Loader;

/**Wrapper for the core MC game.  This class has methods used for determining
 * which mods are loaded, running main init code during boot, and
 * ensuring all other wrappers are running and ready for calls.  This wrapper
 * interfaces with both Forge and MC code, so if it's something that's core to
 * the game and doesn't need an instance of an object to access, it's likely here.
 *
 * @author don_bruce
 */
public class WrapperGame{
	/**
	 *  Returns true if the mod with the passed-in modID is present.
	 */
	public static boolean isModPresent(String modID){
		return Loader.isModLoaded(modID);
	}
	
	/**
	 *  Returns the text-based name for the passed-in mod.
	 */
	public static String getModName(String modID){
		return Loader.instance().getIndexedModList().get(modID).getName();
	}
	
	/**
	 *  Returns the world.  Only valid on CLIENTs as on servers
	 *  there are multiple worlds (dimensions) so a global reference
	 *  isn't possible. 
	 */
	public static WrapperWorld getClientWorld(){
		return new WrapperWorld(Minecraft.getMinecraft().world);
	}
	
	/**
	 *  Returns the player.  Only valid on CLIENTs as on servers
	 *  there are multiple players.
	 */
	public static WrapperPlayer getClientPlayer(){
		return new WrapperPlayer(Minecraft.getMinecraft().player);
	}
}
