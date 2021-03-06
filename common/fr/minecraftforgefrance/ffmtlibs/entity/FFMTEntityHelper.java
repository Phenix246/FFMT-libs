package fr.minecraftforgefrance.ffmtlibs.entity;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * @authors kevin_68, elias54
 */
public class FFMTEntityHelper
{
	protected static Random rand = new Random();

	private static FFMTEntityHelper instance = new FFMTEntityHelper();

	/**
	 * If you want to add a creature come from leave block.
	 * 
	 * @author elias54
	 */
	// Need fix in forge
	// public static EnumCreatureType leafCreature = EnumHelper.addCreatureType("leafCreature", EntityLeafCreature.class, 5, Material.leaves, true);

	/**
	 * Spawn smoke particles(ENTITY ONLY)
	 * 
	 * @param speed
	 * @param entity
	 * @param velX
	 * @param velY
	 * @param velZ
	 */
	public static void spawnSmokeParticles(int speed, EntityLiving entity, double velX, double velY, double velZ)
	{
		for(int i = 0; i < speed; i++)
		{
			entity.worldObj.spawnParticle("smoke", entity.posX, entity.posY, entity.posZ, velX, velY, velZ);
		}
	}

	/**
	 * Spawn smoke particles(ENTITY ONLY)
	 * 
	 * @param speed
	 * @param entity
	 * @param velX
	 * @param velY
	 * @param velZ
	 * @param xPosition
	 *            (If not specified, by default is 0)
	 * @param yPosition
	 *            (If not specified, by default is 0)
	 * @param zPosition
	 *            (If not specified, by default is 0)
	 */
	public static void spawnSmokeParticles(int speed, EntityLiving entity, double xVel, double yVel, double zVel, double xPosition, double yPosition, double zPosition)
	{
		for(int i = 0; i < speed; i++)
		{
			entity.worldObj.spawnParticle("smoke", entity.posX + xPosition, entity.posY + yPosition, entity.posZ + zPosition, xVel, yVel, zVel);
		}
	}

	/**
	 * Add another entity other than mob
	 * 
	 * @param entityClass
	 *            (The entity class)
	 * @param entityName
	 *            (The entity name)
	 * @param id
	 *            (The entity ID)
	 * @param mod
	 *            (Mod instance)
	 * @param trackingRange
	 *            (Number of tracking range)
	 * @param updateFrequency
	 *            (Number update frequency)
	 * @param sendsVelocityUpdates
	 *            (Send velocity updates or not)
	 */
	public static void addOtherEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

	/**
	 * Add a mob too easy
	 * 
	 * @param entityClass
	 *            (The entity class)
	 * @param entityName
	 *            (The entity name)
	 * @param id
	 *            (The entity ID)
	 * @param mod
	 *            (Mod instance)
	 * @param trackingRange
	 *            (Number of tracking range)
	 * @param updateFrequency
	 *            (Number update frequency)
	 * @param sendsVelocityUpdates
	 *            (Send velocity updates or not)
	 * @param backGroundEggColour
	 *            (Background egg color)
	 * @param foreGroundEggColour
	 *            (Foreground egg color)
	 * @param weightedProb
	 *            (Chance to spawn)
	 * @param minSpawn
	 *            (Minimum spawn per chunk)
	 * @param maxSpawn
	 *            (Maximum spawn per chunk)
	 */
	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType);
	}

	/**
	 * Add a mob too easy
	 * 
	 * @param entityClass
	 *            (The entity class)
	 * @param entityName
	 *            (The entity name)
	 * @param id
	 *            (The entity ID)
	 * @param mod
	 *            (Mod instance)
	 * @param trackingRange
	 *            (Number of tracking range)
	 * @param updateFrequency
	 *            (Number update frequency)
	 * @param sendsVelocityUpdates
	 *            (Send velocity updates or not)
	 * @param backGroundEggColour
	 *            (Background egg color)
	 * @param foreGroundEggColour
	 *            (Foreground egg color)
	 * @param weightedProb
	 *            (Chance to spawn)
	 * @param minSpawn
	 *            (Minimum spawn per chunk)
	 * @param maxSpawn
	 *            (Maximum spawn per chunk)
	 * @param biome
	 *            (Biome where you want to spawn the mob)(If not specified, this mob doesn't spawn naturally)
	 */
	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType, BiomeGenBase... biome)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType, biome);
	}

	/**
	 * Set custom attack target ! (PUT THIS FUNCTION IN updateEntityActionState() METHOD !!!!)
	 * 
	 * @param world
	 *            ("worldObj" from the entity)
	 * @param entityHostAttack
	 *            (The entity host the attack(like a entity instance))
	 * @param classToAttack
	 *            (The entity to attack)
	 * @author elias54
	 **/
	public static void targetEntity(World world, EntityCreature entityHostAttack, Class<? extends EntityLivingBase> classToAttack)
	{
		List list = world.getEntitiesWithinAABB(classToAttack, entityHostAttack.boundingBox.getBoundingBox(entityHostAttack.posX, entityHostAttack.posY, entityHostAttack.posZ, entityHostAttack.posX + 1, entityHostAttack.posY + 1, entityHostAttack.posZ + 1).expand(16D, 4D, 16D));
		Entity entityToAttack = (Entity)list.get(rand.nextInt(list.size()));
		if(!list.isEmpty())
		{
			entityHostAttack.setTarget(entityToAttack);
		}
	}

	/**
	 * Return if the entity is in water
	 * 
	 * @param world
	 *            ("worldObj" from the entity)
	 * @param entity
	 *            (Entity instance)
	 * @author elias54
	 */
	public static boolean inWater(World world, Entity entity)
	{
		return world.handleMaterialAcceleration(entity.boundingBox, Material.water, entity);
	}

	/**
	 * Return if the entity is in specified material
	 * 
	 * @param world
	 *            ("worldObj" from the entity)
	 * @param entity
	 *            (Entity instance)
	 * @param material
	 *            (e.g Material.rock)
	 * @author elias54
	 */
	public static boolean isInMaterial(World world, Entity entity, Material material)
	{
		return world.handleMaterialAcceleration(entity.boundingBox, material, entity);
	}

	/**
	 * This is just the famous "onGround" provide from the class Entity
	 * 
	 * @param entity
	 *            (Entity instance)
	 * @author elias54
	 */
	public static boolean entityOnGround(Entity entity)
	{
		return entity.onGround;
	}

	/**
	 * Throw entity problem exception
	 * 
	 * @param message
	 *            (Your message exception)
	 * @param throwable
	 *            (The Throwable instance)
	 * @author elias54
	 */
	public static void throwEntityException(String message, Throwable throwable)
	{
		// is not realy deprecated, just eclipse not reconized the real version
		// of this line :
		ObfuscationReflectionHelper.setPrivateValue(java.lang.Throwable.class, throwable, message, "detailMessage");

		FMLCommonHandler.instance().raiseException(throwable, message, true);
	}

	/**
	 * Remove current listed loaded entity
	 * 
	 * @param world
	 *            (Use worldObj entity)
	 * @param entityToRemove
	 *            (Entity to remove)
	 * @author elias54
	 */
	public void removeLoadedEntityList(World world, Entity entityToRemove)
	{
		List list = world.getLoadedEntityList();
		if(!list.isEmpty())
		{
			list.remove(entityToRemove);
		}
	}

	/**
	 * Set infinite health to specified entity
	 * 
	 * @param entity
	 *            (entity to set infinite health)
	 * @author elias54
	 */
	public static void setInfiniteHealthToEntity(EntityLivingBase entity)
	{
		entity.setHealth(Float.MAX_VALUE);
	}

	public static FFMTEntityHelper instance()
	{
		return instance;
	}
}