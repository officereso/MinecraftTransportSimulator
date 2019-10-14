package minecrafttransportsimulator.packets.vehicles;

import minecrafttransportsimulator.vehicles.main.EntityVehicleA_Base;
import minecrafttransportsimulator.vehicles.parts.APart;
import net.minecraft.nbt.NBTTagCompound;

/**Base packet used for part-player interaction.  Use when a
 * player needs to do something to a part, or vice-versa.
 * 
 * @author don_bruce
 */
public abstract class APacketVehiclePartPlayer extends APacketVehiclePart{
	private int playerID;

	public APacketVehiclePartPlayer(){}
	
	public APacketVehiclePartPlayer(EntityVehicleA_Base vehicle, double x, double y, double z, int playerID){
		super(vehicle, x, y, z);
		this.playerID = playerID;
	}
	
	public APacketVehiclePartPlayer(APart part, int playerID){
		super(part);
		this.playerID = playerID;
	}
	
	@Override
	public void parseFromNBT(NBTTagCompound tag){
		super.parseFromNBT(tag);
		playerID = tag.getInteger("playerID");
	}

	@Override
	public void convertToNBT(NBTTagCompound tag){
		super.convertToNBT(tag);
		tag.setInteger("playerID", playerID);
	}
}
