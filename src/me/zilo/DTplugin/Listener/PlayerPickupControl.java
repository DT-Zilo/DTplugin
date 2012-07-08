/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.Listener;

import java.util.List;
import me.zilo.DTplugin.DTmain;
import me.zilo.DTplugin.Utility.SettingManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Zilo
 */
public class PlayerPickupControl implements Listener
{
    List<Integer> disablePickupList = SettingManager.disablePickupList;
    
    String msg = ChatColor.YELLOW + "["    +
                 ChatColor.GREEN  + "Disable Pickup" +
                 ChatColor.YELLOW + "] " +
                 ChatColor.RED + " คุณไม่สามารถเก็บไอเทมนี้ได้";
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerPickup(PlayerPickupItemEvent event)
    {
        ItemStack item = event.getItem().getItemStack();
        Player player = event.getPlayer();
        
        if (!player.hasPermission("DTplugin.bypassPickup"))
        {
            if (disablePickupList.contains(item.getTypeId()))
            {
                event.getItem().setPickupDelay(200);
                player.sendMessage(msg);
                event.setCancelled(true);
            }
        }
    }
}
