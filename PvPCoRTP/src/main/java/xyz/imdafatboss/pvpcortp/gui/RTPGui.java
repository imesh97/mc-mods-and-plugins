package xyz.imdafatboss.pvpcortp.gui;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;
import xyz.imdafatboss.pvpcortp.Home;
import xyz.imdafatboss.pvpcortp.config.ConfigYML;
import xyz.imdafatboss.pvpcortp.utils.Msg;

import java.util.ArrayList;
import java.util.List;

public class RTPGui {

    Home plugin;
    public RTPGui(Home instance){

        this.plugin = instance;

    }
    ConfigYML cfg;

    public static ItemStack emptyItem(){

        ItemStack ei = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        ItemMeta eim = ei.getItemMeta();
        eim.setDisplayName(" ");
        ei.setItemMeta(eim);

        return ei;

    }

    public ItemStack getNearTP(){

        int range = new ConfigYML(plugin, ConfigYML.Value.NEAR_RANGE).getInt();
        int cost = new ConfigYML(plugin, ConfigYML.Value.NEAR_COST).getInt();

        ItemStack is = new Wool(DyeColor.GREEN).toItemStack(1);
        ItemMeta im = is.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(Msg.translate("&7-----------------"));
        lore.add(" ");
        lore.add(Msg.translate("&cRadius: " + range + " x " + range));
        lore.add(Msg.translate("&aCost: " + cost));
        lore.add(" ");
        lore.add(Msg.translate("&7-----------------"));

        im.setDisplayName(Msg.translate("&a&lNEAR TP"));
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

    public ItemStack getMediumTP(){

        int range = new ConfigYML(plugin, ConfigYML.Value.MEDIUM_RANGE).getInt();
        int cost = new ConfigYML(plugin, ConfigYML.Value.MEDIUM_COST).getInt();

        ItemStack is = new Wool(DyeColor.ORANGE).toItemStack(1);
        ItemMeta im = is.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(Msg.translate("&7-----------------"));
        lore.add(" ");
        lore.add(Msg.translate("&cRadius: " + range + " x " + range));
        lore.add(Msg.translate("&aCost: " + cost));
        lore.add(" ");
        lore.add(Msg.translate("&7-----------------"));

        im.setDisplayName(Msg.translate("&6&lMEDIUM TP"));
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

    public ItemStack getExtremeTP(){

        int range = new ConfigYML(plugin, ConfigYML.Value.EXTREME_RANGE).getInt();
        int cost = new ConfigYML(plugin, ConfigYML.Value.EXTREME_COST).getInt();

        ItemStack is = new Wool(DyeColor.RED).toItemStack(1);
        ItemMeta im = is.getItemMeta();

        List<String> lore = new ArrayList<String>();
        lore.add(Msg.translate("&7-----------------"));
        lore.add(" ");
        lore.add(Msg.translate("&cRadius: " + range + " x " + range));
        lore.add(Msg.translate("&aCost: " + cost));
        lore.add(" ");
        lore.add(Msg.translate("&7-----------------"));

        im.setDisplayName(Msg.translate("&c&lEXTREME TP"));
        im.setLore(lore);
        is.setItemMeta(im);

        return is;

    }

    public Inventory rtpGUI(){

        Inventory inv = Bukkit.createInventory(null, 45, Msg.translate("&6&lPvP &e&lCorporation"));

        inv.setItem(20, getNearTP());
        inv.setItem(22, getMediumTP());
        inv.setItem(24, getExtremeTP());

        for(int i = 0; i < inv.getSize(); i++){

            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR){

                inv.setItem(i, emptyItem());

            }

        }

        return inv;

    }

}
