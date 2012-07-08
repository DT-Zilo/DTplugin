package me.zilo.DTplugin.Utility;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DeathData 
{
    private ItemStack[] itemInv;
    private ItemStack[] armInv;
    private Location location;
    private Player thisPlayer;
    
    public DeathData(Player player, Location loc, ItemStack[] item, ItemStack[] arm)
    {
        location = loc;
        itemInv = item;
        armInv = arm;
        thisPlayer = player;
    }
    
    public void dropItem()
    {
        for (ItemStack item : itemInv)
        {
            if (item != null && item.getType() != Material.AIR)
            {
                location.getWorld().dropItem(location, item);
            }
        }
        
        for (ItemStack item : armInv)
        {
            if (item != null && item.getType() != Material.AIR)
            {
                location.getWorld().dropItem(location, item);
            }
        }
    }
    
    public void giveKeepItemToPlayer()
    {
        thisPlayer.getInventory().setContents(itemInv);
        thisPlayer.getInventory().setArmorContents(armInv);
    }
    
    public String getPlayerName()
    {
        return thisPlayer.getName();
    }
    
    public void setPlayer(Player p)
    {
        thisPlayer = p;
    }
    
    public Player getPlayer()
    {
        return thisPlayer;
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public ItemStack[] getItemInv()
    {
        return itemInv;
    }
    
    public ItemStack[] getArmInv()
    {
        return armInv;
    }
}
