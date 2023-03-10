package xyz.imdafatboss.notables.events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import xyz.imdafatboss.notables.Home;

public class EventManager {

    Home plugin;
    public EventManager(Home instance){

        this.plugin = instance;

    }

    public void registerEvents(Home jp){

        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new AnvilEvent(jp), jp);
        pm.registerEvents(new CraftEvent(jp), jp);
        pm.registerEvents(new EnchantEvent(jp), jp);

    }

}
