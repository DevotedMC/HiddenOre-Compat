package com.github.devotedmc.hiddenorecompat;

import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Simple compatibility layer, leverages HiddenOre's event system to prevent 
 * issues with Citadel (converting reinforced blocks) and Orebfuscator
 * (failing to deobfuscate blocks sometimes since break event is cancelled).
 * 
 * @author ProgrammerDan <programmerdan@gmail.com>
 */
public class HiddenOreCompat extends JavaPlugin implements Listener {

	CitadelCompat citadel = null;
	//OrebfuscatorCompat orebfuscator = null;
	
	@Override
	public void onEnable() {
		PluginManager manager = this.getServer().getPluginManager();
		if (manager.isPluginEnabled("Citadel")) {
			this.getLogger().log(Level.INFO, "Preparing HiddenOre-Citadel compatibility extender");
			citadel = new CitadelCompat();
			manager.registerEvents(citadel, this);
		} else {
			this.getLogger().log(Level.INFO, "HiddenOre-Citadel compatibility skipped.");
		}
		/* TODO: Orebfuscator is not exposing an interface for compat yet?
		  if (manager.isPluginEnabled("Orebfuscator4")) {
			this.getLogger().log(Level.INFO, "Preparing HiddenOre-Orebfuscator compatibility extender");
			orebfuscator = new OrebfuscatorCompat();
			manager.registerEvents(orebfuscator, this);
		} else {
			this.getLogger().log(Level.INFO, "HiddenOre-Orebfuscator compatibility skipped.");
		}*/
	}
}
