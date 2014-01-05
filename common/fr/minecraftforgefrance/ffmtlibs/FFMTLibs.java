package fr.minecraftforgefrance.ffmtlibs;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.minecraftforgefrance.ffmtlibs.renderer.TESRInventoryRenderHandler;

@Mod(modid = "FFMTLIBS", name = "FFMT Library", version = "@VERSION@", useMetadata = true)
/**
 * @authors kevin_68, elias54, robin4002
 */
public class FFMTLibs
{
	public static Logger FFMTlog;
	public static FFMTColor getColor = new FFMTColor();

	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		FFMTlog = event.getModLog();
		event.getModMetadata().version = "@VERSION@";

		// TODO: fix version check
		// FFMTRegistry.registerVersionCheck("http://dl.mcnanotech.fr/FFMT/libs/version.txt",
		// "http://ci.mcnanotech.fr/job/FFMT-libs/", "FFMT Library",
		// "@VERSION@");
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		if(event.getSide().isClient())
		{
			FFMTClientRegistry.tesrRenderId = RenderingRegistry.getNextAvailableRenderId();
			RenderingRegistry.registerBlockHandler(new TESRInventoryRenderHandler());
		}
	}
}
