package com.github.devotedmc.hiddenorecompat;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import vg.civcraft.mc.citadel.Citadel;
import vg.civcraft.mc.citadel.ReinforcementManager;
import vg.civcraft.mc.citadel.reinforcement.Reinforcement;

import com.github.devotedmc.hiddenore.events.HiddenOreEvent;
import com.github.devotedmc.hiddenore.events.HiddenOreGenerateEvent;

public class HiddenOreCompat extends JavaPlugin implements Listener {

	boolean citadelEnabled = false;
	boolean orebfuscatorEnabled = false;
	
	@Override
	public void onEnable() {
		citadelEnabled = this.getServer().getPluginManager().isPluginEnabled("Citadel");
		orebfuscatorEnabled = this.getServer().getPluginManager().isPluginEnabled("orebfuscator");
	}

	/**
	 *  Capture HOGE event and cancel if it would result in a reinforced
	 *  block transforming
	 * @param hoge the ore generating event.
	 */
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled = true)
	public void captureHiddenOreGenerate(HiddenOreGenerateEvent hoge) {
		if (citadelEnabled) {
			ReinforcementManager rm = Citadel.getReinforcementManager();
			Reinforcement rein = rm.getReinforcement(hoge.getBlock());
			if (rein != null) {
				hoge.setCancelled(true);
			}
		}
	}
	
	/**
	 *  Capture normal HOE event and trigger an orebfuscator update.
	 * @param hoe The HiddenOre break event.
	 */
	public void captureHiddenOreBreak(HiddenOreEvent hoe) {
		if (orebfuscatorEnabled) {
			
		}
	}
}
