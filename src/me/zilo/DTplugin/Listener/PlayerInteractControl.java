/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.Listener;

import java.util.List;
import me.zilo.DTplugin.Utility.SettingManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Zilo
 */
public class PlayerInteractControl implements Listener
{
    List<Integer> disableInteractList = SettingManager.disableInteractList;
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        if (disableInteractList.contains(event.getClickedBlock().getTypeId()))
        {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
            {
                event.setCancelled(true);
            }
        }
    }
}
