package me.zilo.DTcmd;

import me.zilo.DTcmd.cmdStore.Puppet_Cmd;
import me.zilo.DTcmd.cmdStore.fakeOP_Cmd;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class DTmain extends JavaPlugin
{
    private Puppet_Cmd pupCmd;
    private fakeOP_Cmd fOpCmd;
    
    @Override
    public void onEnable()
    {
        pupCmd = new Puppet_Cmd(2, -1);
        fOpCmd = new fakeOP_Cmd(1, -1);
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("puppet") || cmd.getName().equalsIgnoreCase("pup"))
        {
            return pupCmd.RunCmd(sender, args);
        }
        else if (cmd.getName().equalsIgnoreCase("fakeop") || cmd.getName().equalsIgnoreCase("fop"))
        {
            return fOpCmd.RunCmd(sender, args);
        }
        return true;
    }
}
