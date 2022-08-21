package minecrafttransportsimulator.mcinterface;

import minecrafttransportsimulator.items.components.AItemBase;

import java.util.List;

/**
 * Interface to the core MC system.  This class has methods for registrations
 * file locations, and other core things that are common to clients and servers.
 * Client-specific things go into {@link InterfaceManager.clientInterface}, rendering goes into
 * {@link InterfaceManager.renderingInterface}.
 *
 * @author don_bruce
 */
public interface IInterfaceCore {

    /**
     * Returns the game version for this current instance.
     */
    String getGameVersion();

    /**
     * Returns true if the mod with the passed-in modID is present.
     */
    boolean isModPresent(String modID);

    /**
     * Returns true if there is a fluid registered with the passed-in name, false otherwise.
     */
    boolean isFluidValid(String fluidID);

    /**
     * Returns the text-based name for the passed-in mod.
     */
    String getModName(String modID);

    /**
     * Returns a new NBT IWrapper instance with no data.
     */
    IWrapperNBT getNewNBTWrapper();

    /**
     * Returns a new stack for the passed-in item.  Note that this is only valid for items
     * that have {@link AItemBase#autoGenerate()} as true.
     */
    IWrapperItemStack getAutoGeneratedStack(AItemBase item, IWrapperNBT data);

    /**
     * Returns a new stack for the item properties.  Or an empty stack if the name is invalid.
     */
    IWrapperItemStack getStackForProperties(String name, int meta, int qty);

    /**
     * Returns the registry name for the passed-in stack.  Can be used in conjunction with
     * {@link #getStackForProperties(String, int, int)} to get a new stack later.
     */
    String getStackItemName(IWrapperItemStack stack);

    /**
     * Returns true if both stacks are Oredict compatible.
     */
    boolean isOredictMatch(IWrapperItemStack stackA, IWrapperItemStack stackB);

    /**
     * Returns all possible stacks that could be used for the passed-in OreDict name.
     */
    List<IWrapperItemStack> getOredictMaterials(String oreName);
}
