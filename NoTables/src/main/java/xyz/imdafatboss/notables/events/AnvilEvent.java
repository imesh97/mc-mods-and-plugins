package xyz.imdafatboss.notables.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import xyz.imdafatboss.notables.Home;
import xyz.imdafatboss.notables.config.ConfigYML;
import xyz.imdafatboss.notables.utils.Msg;

public class AnvilEvent implements Listener{
    Home plugin;
    public AnvilEvent(Home instance){

        this.plugin = instance;

    }
    ConfigYML cfg;

    @EventHandler
    public void onAnvil(PlayerInteractEvent e){

        cfg = new ConfigYML(plugin);
        Action a = e.getAction();
        Player p = e.getPlayer();

        if(!cfg.canAnvil()) {

            if (a == Action.RIGHT_CLICK_BLOCK) {

                if (e.getClickedBlock() != null) {

                    Block b = e.getClickedBlock();
                    if (b.getType() != null || b.getType() != Material.AIR) {

                        if (b.getType() == Material.ANVIL) {

                            e.setCancelled(true);
                            for (String s : cfg.getMessages()) {

                                p.sendMessage(Msg.translate(s));

                            }

                        }

                    }

                }

            }

        }

    }

}