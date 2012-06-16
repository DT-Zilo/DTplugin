package me.zilo.DTcmd;

import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;
import me.zilo.DTcmd.cmdStore.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DTmain extends JavaPlugin implements Listener
{
    private File yml = null;
    private FileConfiguration config = null;
    
    private CmdExe cmdExe;
    
    @Override
    public void onEnable(){
        cmdExe = new CmdExe();
        getServer().getPluginManager().registerEvents(this, this);
        
        ReLoadConfig();
    }
    
    private void ReLoadConfig()
    {
        if (yml == null)
        {
            yml = new File(getDataFolder(),"config.yml");
        }
        config = YamlConfiguration.loadConfiguration(yml);
        
        InputStream defConfing = getResource("config.yml");
        
        if (defConfing != null)
        {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfing);
            config.setDefaults(defConfig);
        }
    }
    
    private void SaveConfig()
    {
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return cmdExe.CheckCmd(sender, cmd, commandLabel, args);
    }
    
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        //entity.BigCat.name
        String newDeathMsg = event.getDeathMessage();
        newDeathMsg = newDeathMsg.replace("entity.", "");
        newDeathMsg = newDeathMsg.replace(".name", "");
        event.setDeathMessage(newDeathMsg);
    }
    
    private Logger Log()
    {
        return getLogger();
    }
}
