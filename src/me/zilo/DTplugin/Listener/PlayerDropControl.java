/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.Listener;

import java.util.List;
import me.zilo.DTplugin.Utility.SettingManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Zilo
 */
public class PlayerDropControl implements Listener
{
    List<Integer> disableDropList = SettingManager.disableDropList;
    
    String msg = ChatColor.YELLOW + "["    +
                 ChatColor.GREEN  + "Disable Drop" +
                 ChatColor.YELLOW + "] " +
                 ChatColor.RED  + " คุณไม่สามารถทิ้งไอเทมนี้ได้";
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDrop(PlayerDropItemEvent event)
    {
        ItemStack item = event.getItemDrop().getItemStack();
        Player player = event.getPlayer();
        
        if (!player.hasPermission("DTplugin.bypassDrop"))
        {
            if (disableDropList.contains(item.getTypeId()))
            {
                player.sendMessage(msg);
                event.setCancelled(true);
            }
        }
    }
}
