package me.zilo.DTcmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DTmain extends JavaPlugin
{
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
                String msg = "";
                for (int i = 1 ; i < args.length ; i++)
                {
                    msg += args[i] + " ";
                }
                CmdPuppet(sender, msg, args[0]);
            }
            return true;
        }
        else
        {
            sender.sendMessage("/puppet <TargetUser> <MSG>");
        }
        return true;
    }
    
    private void CmdPuppet(CommandSender sender, String msg, String targetName)
    {
        if(sender.hasPermission("DTcmd.puppet")) 
        {
            Player target = getServer().getPlayer(targetName);
            if (target == null)
            {
                sender.sendMessage(ChatColor.RED + "ผู้เล่น [ " + targetName + " ] ไม่อยู่ในเกม");
            }
            else if (target.hasPermission("DTcmd.aitiPuppet"))
            {
                sender.sendMessage(ChatColor.RED + "คุณไม่สามารถควบคุม [ " + targetName + " ] ได้");
            }
            else
            {
                target.chat(msg);
            }
        }
        else
        {
            sender.sendMessage(ChatColor.RED + "คุณไม่มีสิทธิใช้คำสั่งนี้");
        }
    }    
}
