/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.CmdStore;

import java.util.ArrayList;
import java.util.List;
import me.zilo.DTplugin.Listener.AdminChatChannel;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Zilo
 */
public class AdminChannel_Cmd 
{
    
    private int minLenght;
    private int maxLenght;
    
    public AdminChannel_Cmd(int minLen, int maxLen)
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
            if(sender.hasPermission("DTplugin.adminChannel")) 
            {
                if (AdminChatChannel.playerName.contains(sender.getName()))
                {
                    sender.sendMessage(
                            ChatColor.YELLOW + "["  + 
                            ChatColor.GREEN  + "Admin Ch"  +
                            ChatColor.YELLOW + "] " +
                            ChatColor.WHITE  + "ปิดการคุย Admin Channel");
                    AdminChatChannel.playerName.remove(sender.getName());
                }
                else
                {
                    sender.sendMessage(
                            ChatColor.YELLOW + "["  + 
                            ChatColor.GREEN  + "Admin Ch"  +
                            ChatColor.YELLOW + "] " +
                            ChatColor.WHITE  + "เปิดการคุย Admin Channel");
                    AdminChatChannel.playerName.add(sender.getName());
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
