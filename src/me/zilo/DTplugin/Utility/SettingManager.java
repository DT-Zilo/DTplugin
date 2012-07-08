/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.Utility;

import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;

/**
 *
 * @author Zilo
 */
public class SettingManager 
{
    public static List<Integer> clearDropList;
    public static List<Integer> keepDropList;
    public static List<Integer> disableDropList;
    public static List<Integer> disableInteractList;
    public static List<Integer> disablePickupList;
    
    public static void LoadConfig(FileConfiguration config)
    {
        clearDropList = config.getIntegerList("cleardrop-onbreak");
        keepDropList = config.getIntegerList("nodrop-ondeath");
        disableDropList = config.getIntegerList("disable-drop");
        disableInteractList = config.getIntegerList("disable-interact");
        disablePickupList = config.getIntegerList("disable-pickup");
    }
}
