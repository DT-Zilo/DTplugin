/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.CmdStore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Zilo
 */
public class AdminChat_Cmd 
{
    private int minLenght;
    private int maxLenght;
    
    private String prefix;
    
    public AdminChat_Cmd(int minLen, int maxLen)
    {
        minLenght = minLen;
        
        maxLenght = (maxLen == -1) ? Integer.MAX_VALUE : maxLen;
        
        prefix = ChatColor.YELLOW + "[" + 
                 ChatColor.GREEN  + "Admin Chat" +
                 ChatColor.YELLOW + "]" + 
                 ChatColor.WHITE  + " ";
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
            if(sender.hasPermission("DTplugin.adminChat")) 
            {
                String msg = prefix + sender.getName() + " : ";
                
                for (int i = 0 ; i < args.length ; i++)
                {
                    msg += args[i] + " ";
                }
                
                for(Player p:Bukkit.getServer().getOnlinePlayers())
                {
                    if (p.hasPermission("DTplugin.adminChat"))
                    {
                        p.sendMessage(msg);
                    }
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
