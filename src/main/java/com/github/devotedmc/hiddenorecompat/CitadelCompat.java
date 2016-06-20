package com.github.devotedmc.hiddenorecompat;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import vg.civcraft.mc.citadel.Citadel;
import vg.civcraft.mc.citadel.ReinforcementManager;
import vg.civcraft.mc.citadel.reinforcement.Reinforcement;

import com.github.devotedmc.hiddenore.events.HiddenOreGenerateEvent;

/**
 * Simple Compatibility listener for Citadel; if transformation is requested
 * for a block protected by citadel, cancel.
 * 
 * @author ProgrammerDan <programmerdan@gmail.com>
 *
 */
public class CitadelCompat implements Listener {

	/**
	 *  Capture HOGE event and cancel if it would result in a reinforced
	 *  block transforming
	 * @param hoge the ore generating event.
	 */
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled = true)
	public void captureHiddenOreGenerate(HiddenOreGenerateEvent hoge) {
		ReinforcementManager rm = Citadel.getReinforcementManager();
		Reinforcement rein = rm.getReinforcement(hoge.getBlock());
		if (rein != null) {
			hoge.setCancelled(true);
		}
	}
}
