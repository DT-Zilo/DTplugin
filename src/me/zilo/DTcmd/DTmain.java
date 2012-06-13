package me.zilo.DTcmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DTmain extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        
    }
    
    @Override
    public void onDisable()
    {
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("puppet") || cmd.getName().equalsIgnoreCase("pup"))
        {
            if (args.length < 2)
            {
                sender.sendMessage(ChatColor.RED + "ข้อมูลไม่ครบ!");
                return false;
            }
            else
            {
                Player target = getServer().getPlayer(args[0]);
                if (target == null)
                {
                    sender.sendMessage(ChatColor.RED + "ผู้เล่น [ " + args[0] + " ] ไม่อยู่ในเกม");
                }
                else
                {
                    String msg = "";
                    try
                    {
                        for (int i = 1 ; i < args.length ; i++)
                        {
                            msg += args[i] + " ";
                        }
                        target.sendMessage(msg);
                    }
                    catch (Exception e)
                    {
                        sender.sendMessage(ChatColor.RED + "เกิดข้อผิดพลาดบางอย่าง");
                    }
                }
                return true;
            }
        }
        return false;
    }
}
