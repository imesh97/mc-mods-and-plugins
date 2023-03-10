package xyz.imdafatboss.notables;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.notables.config.FileManager;
import xyz.imdafatboss.notables.events.EventManager;

public class Home extends JavaPlugin implements Listener{

    FileManager fm = new FileManager(this);
    EventManager evt;

    @Override
    public void onEnable(){

        evt = new EventManager(this);

        this.getLogger().info("Created by imdafatboss.");
        fm.getConfig("config.yml").saveDefaultConfig();

        evt.registerEvents(this);

    }

}
