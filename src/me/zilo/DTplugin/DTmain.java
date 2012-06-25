package me.zilo.DTplugin;

import me.zilo.DTplugin.CmdStore.CmdExe;
import java.util.logging.Logger;
import me.zilo.DTplugin.Listener.*;
import me.zilo.DTplugin.Utility.DeathData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DTmain extends JavaPlugin
{
    private CmdExe cmdExe;
    public static Logger log;
    public static FileConfiguration config;
    
    @Override
    public void onEnable()
    {
        cmdExe = new CmdExe();
        log = getLogger();
        initialConfig();
        initialEvent();
    }
    
    @Override
    public void onDisable() 
    {
        for (DeathData dd : PlayerDeathDropControl.dds.values())
        {
            dd.dropItem();
        }
        PlayerDeathDropControl.dds.clear();
        AdminChatChannel.playerName.clear();
    }
    
    private void initialConfig()
    {
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
    
    private void initialEvent()
    {
        PluginManager pm = getServer().getPluginManager();
        
        pm.registerEvents(new PlayerDeathMSG(), this);
        pm.registerEvents(new PlayerDeathDropControl(), this);
        pm.registerEvents(new AdminChatChannel(), this);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        return cmdExe.CheckCmd(sender, cmd, commandLabel, args);
    }
}
