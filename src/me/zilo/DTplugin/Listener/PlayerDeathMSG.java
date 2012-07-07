package me.zilo.DTplugin.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathMSG implements Listener
{
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        String newDeathMsg = event.getDeathMessage();
        newDeathMsg = newDeathMsg.replace("entity.", "");
        newDeathMsg = newDeathMsg.replace(".name", "");
        event.setDeathMessage(newDeathMsg);
    }
}
