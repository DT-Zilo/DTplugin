package me.zilo.DTplugin.CmdStore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Puppet_Cmd 
{
    private int minLenght;
    private int maxLenght;
    
    public Puppet_Cmd(int minLen, int maxLen)
    {
        minLenght = minLen;
        
        maxLenght = (maxLen == -1) ? Integer.MAX_VALUE : maxLen;
    }
    
    public Boolean RunCmd(CommandSender sender, String[] args)
    {
        int argsLen = args.length;
        
        if (argsLen < minLenght)
        {
            sender.sendMessage(ChatColor.RED + "ข้อมูลไม่ครบ!");
            return false;
        }
        else if (argsLen > maxLenght)
        {
            sender.sendMessage(ChatColor.RED + "ข้อมูลเกิน!");
            return false;
        }
        else
        {
            if(sender.hasPermission("DTcmd.puppet")) 
            {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                
                if (target == null)
                {
                    sender.sendMessage(ChatColor.RED + "ผู้เล่น [ " + args[0] + " ] ไม่อยู่ในเกม");
                }
                else if (target.hasPermission("DTcmd.aitiPuppet"))
                {
                    sender.sendMessage(ChatColor.RED + "คุณไม่สามารถควบคุม [ " + args[0] + " ] ได้");
                }
                else
                {
                    String msg = "";
                    for (int i = 1 ; i < args.length ; i++)
                    {
                        msg += args[i] + " ";
                    }
                    target.chat(msg);
                }
            }
            else
            {
                sender.sendMessage(ChatColor.RED + "คุณไม่มีสิทธิใช้คำสั่งนี้");
            }
            
            return true;
        }
    }
}
