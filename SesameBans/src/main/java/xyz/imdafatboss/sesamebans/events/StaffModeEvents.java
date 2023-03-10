package xyz.imdafatboss.sesamebans.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.Locations;
import xyz.imdafatboss.sesamebans.utils.StaffMode;

public class StaffModeEvents implements Listener{

    Home plugin;
    public StaffModeEvents(Home instance){

        this.plugin = instance;

    }
    MessagesYML msg;
    ConfigYML cfg;

    // General
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){

        if(e.getItemInHand() != null || e.getItemInHand().getType() != Material.AIR){

            if(StaffMode.isStaffStack(e.getItemInHand())){

                e.setCancelled(true);

            }

            return;

        }

        return;

    }

    // FLY
    @EventHandler
    public void onPlayerFly(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){

            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isFlyStack(p.getItemInHand())){

                        if(!StaffMode.fly.contains(p)) {

                            p.setAllowFlight(true);
                            p.setFlying(true);
                            StaffMode.fly.add(p);
                            return;

                        }
                        p.setFlying(false);
                        StaffMode.fly.remove(p);
                        return;

                    }

                }

            }

        }

    }

    // VANISH
    @EventHandler
    public void onPlayerVanish(PlayerInteractEvent e){

        msg = new MessagesYML(plugin);
        Player p = e.getPlayer();
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){

            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isVanishStack(p.getItemInHand())){

                        if(!StaffMode.vanished.contains(p)) {

                            for (Player online : Bukkit.getOnlinePlayers()) {

                                online.hidePlayer(p);

                            }
                            StaffMode.vanished.add(p);
                            p.sendMessage(msg.prefix() + msg.getVanished());
                            return;

                        }
                        for(Player online : Bukkit.getOnlinePlayers()){

                            online.showPlayer(p);

                        }
                        StaffMode.vanished.remove(p);
                        p.sendMessage(msg.prefix() + msg.getUnvanished());
                        return;

                    }

                }

            }

        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        for(Player online : Bukkit.getOnlinePlayers()){

            for(Player p : StaffMode.vanished){

                online.hidePlayer(p);

            }

        }

    }

    // FREEZE
    @EventHandler
    public void onPlayerRC(PlayerInteractEntityEvent e){

        msg = new MessagesYML(plugin);
        if(e.getRightClicked() instanceof Player){

            Player t = (Player) e.getRightClicked();
            Player p = e.getPlayer();
            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isFreezeStack(p.getItemInHand())){

                        if(!StaffMode.freeze.contains(t)){

                            StaffMode.freeze.add(t);
                            t.sendMessage(msg.prefix() + msg.getFrozen());
                            return;

                        }
                        else {

                            StaffMode.freeze.remove(t);
                            t.sendMessage(msg.prefix() + msg.getUnfrozen());
                            return;

                        }

                    }

                }

            }

        }

    }

    @EventHandler
    public void playerFrozen(PlayerMoveEvent e){

        Player p = e.getPlayer();
        if(StaffMode.freeze.contains(p)){

            Location loc = e.getFrom();
            p.teleport(loc);

        }

    }

    // RANDOM TP
    @EventHandler
    public void onRandomTP(PlayerInteractEvent e){

        cfg = new ConfigYML(plugin);
        Player p = e.getPlayer();
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){

            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isRandomStack(p.getItemInHand())){

                        e.setCancelled(true);
                        p.getInventory().setItem(3, StaffMode.getRandomTP());
                        Locations.randomPlayer(p);
                        return;

                    }

                }

            }

        }

    }

    // INVSEE
    @EventHandler
    public void onPlayerInvsee(PlayerInteractEntityEvent e){

        if(e.getRightClicked() instanceof Player){

            Player t = (Player) e.getRightClicked();
            Player p = e.getPlayer();
            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isInvStack(p.getItemInHand())){

                        Inventory inv = t.getInventory();
                        p.openInventory(inv);
                        return;

                    }

                }

            }

        }

    }

    // COMPASS
    @EventHandler
    public void onThroughCompass(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Action a = e.getAction();
        if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){

            if(p.getItemInHand() != null || p.getItemInHand().getType() != Material.AIR){

                if(StaffMode.isStaffStack(p.getItemInHand())){

                    if(StaffMode.isThroughStack(p.getItemInHand())){

                        StaffMode.thru(p);
                        return;

                    }

                }

            }

        }

    }

}
