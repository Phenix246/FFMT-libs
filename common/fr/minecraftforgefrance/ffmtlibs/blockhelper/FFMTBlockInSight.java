package fr.minecraftforgefrance.ffmtlibs.blockhelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;

/**
 * @author letherman255, robin4002
 */

public class FFMTBlockInSight
{
	/**
	 * 
	 * @param distance - the distance  
	 * @param player - the player's object
	 * @return an array of int, 0 = x, 1 = y, 2 = z
	 */
	@Deprecated // TODO fix (this never really work)
	public static int[] getBlockInSight(int distance, EntityPlayer player)
	{
		@SuppressWarnings("unused")
		MovingObjectPosition objectMouseOver = player.rayTrace(distance, 1);

		/*if(objectMouseOver != null && objectMouseOver.typeOfHit == EnumMovingObjectType.TILE)
		{
			int x = objectMouseOver.blockX;
			int y = objectMouseOver.blockY;
			int z = objectMouseOver.blockZ;
			return new int[] {x, y, z};
		}*/
		
		// error
		return new int[] {0, 0, 0};
	}
}