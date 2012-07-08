/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.zilo.DTplugin.Utility;

import java.util.List;
import me.zilo.DTplugin.DTmain;

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
    
    public static void LoadConfig()
    {
        clearDropList = DTmain.config.getIntegerList("cleardrop-onbreak");
        keepDropList = DTmain.config.getIntegerList("nodrop-ondeath");
        disableDropList = DTmain.config.getIntegerList("disable-drop");
        disableInteractList = DTmain.config.getIntegerList("disable-interact");
        disablePickupList = DTmain.config.getIntegerList("disable-pickup");
    }
}
