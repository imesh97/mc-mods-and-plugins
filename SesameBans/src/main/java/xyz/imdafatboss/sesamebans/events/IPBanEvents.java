package xyz.imdafatboss.sesamebans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.FileManager;

public class IPBanEvents implements Listener{

    Home plugin;
    public IPBanEvents(Home instance){

        this.plugin = instance;

    }
    FileManager fm;

    public FileManager.Config cfg(){

        fm = new FileManager(plugin);
        return fm.getConfig("data.yml");

    }

    @EventHandler
    public void registerIP(PlayerJoinEvent e){

        Player p = e.getPlayer();
        String ip = p.getAddress().getAddress().toString().substring(1);

        cfg().get().set("ips." + p.getUniqueId().toString(), ip);
        cfg().save();

    }

}
