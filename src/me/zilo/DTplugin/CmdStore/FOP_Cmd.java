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

public class FOP_Cmd
{
    private int minLenght;
    private int maxLenght;
    
    public FOP_Cmd(int minLen, int maxLen)
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
            if(sender.hasPermission("DTplugin.fakeOP")) 
            {
                Player target = Bukkit.getServer().getPlayer(args[0]);

                if (target == null)
                {
                    sender.sendMessage(ChatColor.RED + "ผู้เล่น [ " + args[0] + " ] ไม่อยู่ในเกม");
                }
                else if (target.hasPermission("DTplugin.aitiFakeOP"))
                {
                    sender.sendMessage(ChatColor.RED + "คุณไม่สามารถควบคุม [ " + args[0] + " ] ได้");
                }
                else
                {
                    sender.sendMessage(ChatColor.GREEN + "ส่งเรียบร้อย");
                    target.sendMessage(ChatColor.YELLOW + "You are now op!");
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
