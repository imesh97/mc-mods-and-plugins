package xyz.imdafatboss.sesamebans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.config.ConfigYML;

public class MuteEvents implements Listener{

    Home plugin;
    public MuteEvents(Home instance){

        this.plugin = instance;

    }
    PlayerAPI papi;
    ConfigYML cfg;

    @EventHandler
    public void onPlayerIsMuted(AsyncPlayerChatEvent e){

        papi = new PlayerAPI(plugin);
        cfg = new ConfigYML(plugin);
        Player p = e.getPlayer();
        if(papi.isMuted(p)){

            e.setCancelled(true);
            String banscreen = cfg.muteScreen(p);
            p.sendMessage(cfg.prefix() + banscreen);

        }

    }

}
