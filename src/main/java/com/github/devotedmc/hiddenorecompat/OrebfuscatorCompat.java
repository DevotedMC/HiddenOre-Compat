package com.github.devotedmc.hiddenorecompat;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.github.devotedmc.hiddenore.events.HiddenOreEvent;
//import com.lishid.orebfuscator.obfuscation.BlockUpdate;

/**
 * TODO latest Orebfuscator does not appear to expose an equiv notification option. 
 * 
 * Handles the standard hiddenore break event, and triggers an orebfuscator
 * update when one is called.
 * 
 * @author ProgrammerDan <programmerdan@gmail.com>
 */
public class OrebfuscatorCompat implements Listener {
	/**
	 *  Capture normal HOE event and trigger an orebfuscator update.
	 * @param hoe The HiddenOre break event.
	 */
	@EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
	public void captureHiddenOreBreak(HiddenOreEvent hoe) {
		/*List<Location> L= new ArrayList<Location>(1);
		L.add(hoe.getDropLocation());
		BlockUpdate.updateByLocations(L, 1);*/
	}
}
