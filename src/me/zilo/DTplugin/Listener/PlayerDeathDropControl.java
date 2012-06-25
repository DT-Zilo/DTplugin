package me.zilo.DTplugin.Listener;

import java.util.*;
import me.zilo.DTplugin.DTmain;
import me.zilo.DTplugin.Utility.DeathData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathDropControl implements Listener
{
    public static Map<Player, DeathData> dds = new HashMap<Player, DeathData>();
        
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        
        DeathData dd = dds.get(player);
        
        if (dd != null)
        {
            dd.dropItem();
        }
        
        ItemStack[] dropItem = player.getInventory().getContents();
        ItemStack[] armorItem = player.getInventory().getArmorContents();
        
        for (int i = 0; i < armorItem.length; i++) 
        {
            ItemStack item = armorItem[i];
            
            if (item != null && checkDeathDrop(item.getTypeId()))
            {
                event.getDrops().remove(item);
            }
            else
            {
                armorItem[i] = null;
            }
        }
        
        for (int i = 0; i < dropItem.length; i++)
        {
            ItemStack item = dropItem[i];
            
            if (item != null && checkDeathDrop(item.getTypeId()))
            {
                event.getDrops().remove(item);
            }
            else
            {
                dropItem[i] = null;
            }
        }
        
        dds.put(event.getEntity(),new DeathData(player.getLocation(), dropItem, armorItem));
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerRespawn(final PlayerRespawnEvent event) 
    {
        Player player = event.getPlayer();
        
        DeathData dd = dds.remove(player);
        if (dd != null)
        {
            dd.giveKeepItemToPlayer(player);
        }
    }
    
    private boolean checkDeathDrop(int itemID)
    {
        List<Integer> keepDropList = DTmain.config.getIntegerList("nodrop-ondeath");
        
        for (Integer i:keepDropList)
        {
            if (i == itemID)
            {
                return true;
            }
        }
        return false;
    }
}
