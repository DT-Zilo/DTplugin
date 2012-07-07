package me.zilo.DTplugin.Listener;

import java.util.*;
import me.zilo.DTplugin.Utility.DeathData;
import me.zilo.DTplugin.Utility.SettingManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathDropControl implements Listener
{
    public static Map<String, DeathData> dds = new HashMap<String, DeathData>();
    List<Integer> keepDropList = SettingManager.keepDropList;
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        
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
        
        dds.put(player.getName(),new DeathData(player, player.getLocation(), dropItem, armorItem));
    }
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerRespawn(PlayerRespawnEvent event) 
    {
        Player player = event.getPlayer();
        
        DeathData dd = dds.remove(player.getName());
        
        if (dd != null)
        {
            dd.giveKeepItemToPlayer();
        }
    }
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        
        if (dds.containsKey(player.getName()))
        {
            DeathData tdd = dds.remove(player.getName());
            tdd.setPlayer(player);
            dds.put(player.getName(), tdd);
        }
    }
    
    private boolean checkDeathDrop(int itemID)
    {
        if (keepDropList.contains(itemID))
        {
            return true;
        }
        return false;
    }
}
