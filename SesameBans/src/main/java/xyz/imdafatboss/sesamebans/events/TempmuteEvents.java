package xyz.imdafatboss.sesamebans.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.DataAPI;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.config.ConfigYML;

public class TempmuteEvents implements Listener{

    Home plugin;
    public TempmuteEvents(Home instance){

        this.plugin = instance;

    }
    PlayerAPI papi;
    ConfigYML cfg;
    DataAPI data;

    @EventHandler
    public void onPlayerIsTempmuted(AsyncPlayerChatEvent e){

        papi = new PlayerAPI(plugin);
        cfg = new ConfigYML(plugin);
        data = new DataAPI(plugin);
        Player p = e.getPlayer();
        if(papi.isTempmuted(p)){

            e.setCancelled(true);
            String banscreen = cfg.tempmuteScreen(p);
            p.sendMessage(cfg.prefix() + banscreen);

            data.getData().get().set("tempmutes." + p.getUniqueId().toString(), null);
            data.getData().save();

        }

    }

}
