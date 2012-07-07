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
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Zilo
 */
public class ClearBlockDrop implements Listener
{
    List<Integer> clearDropList = SettingManager.clearDropList;
    
    @EventHandler(priority = EventPriority.LOW)
    public void onItemSpawn(ItemSpawnEvent event)
    {
        ItemStack item = event.getEntity().getItemStack();
        
        if (clearDropList.contains(item.getTypeId()))
        {
            event.setCancelled(true);
        }
    }
}
