package com.github.devotedmc.hiddenorecompat;

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
	OrebfuscatorCompat orebfuscator = null;
	
	@Override
	public void onEnable() {
		PluginManager manager = this.getServer().getPluginManager();
		if (manager.isPluginEnabled("Citadel")) {
			citadel = new CitadelCompat();
			manager.registerEvents(citadel, this);
		}
		if (manager.isPluginEnabled("Orebfuscator4")) {
			orebfuscator = new OrebfuscatorCompat();
			manager.registerEvents(orebfuscator, this);
		}
	}
}
