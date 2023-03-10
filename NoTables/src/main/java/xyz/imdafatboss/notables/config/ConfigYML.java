package xyz.imdafatboss.notables.config;

import xyz.imdafatboss.notables.Home;

import java.util.*;

public class ConfigYML {

    Home plugin;
    public ConfigYML(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config getConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("config.yml");

    }

    public boolean canCraft(){

        return this.getConfig().get().getBoolean("crafting-tables");

    }

    public boolean canAnvil(){

        return this.getConfig().get().getBoolean("anvils");

    }

    public boolean canEnchant(){

        return this.getConfig().get().getBoolean("enchantment-tables");

    }

    public List<String> getMessages(){

        return this.getConfig().get().getStringList("messages");

    }

}
