/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTcmd.cmdStore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Zilo
 */
public class CmdExe 
{
    private Puppet_Cmd pupCmd;
    private FOP_Cmd fOpCmd;
    private AdminChat_Cmd admChat;
    
    public CmdExe()
    {
        pupCmd = new Puppet_Cmd(2, -1);
        fOpCmd = new FOP_Cmd(1, 1);
        admChat = new AdminChat_Cmd(1, -1);
    }
    
    public boolean CheckCmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("puppet") || cmd.getName().equalsIgnoreCase("pup"))
        {
            return pupCmd.RunCmd(sender, args);
        }
        else if (cmd.getName().equalsIgnoreCase("fakeop") || cmd.getName().equalsIgnoreCase("fop"))
        {
            return fOpCmd.RunCmd(sender, args);
        }
        else if (cmd.getName().equalsIgnoreCase("adminchat") || cmd.getName().equalsIgnoreCase("ad"))
        {
            return admChat.RunCmd(sender, args);
        }
        return true;
    }
}
