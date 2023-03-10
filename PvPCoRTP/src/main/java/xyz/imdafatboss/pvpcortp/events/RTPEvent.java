package xyz.imdafatboss.pvpcortp.events;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import xyz.imdafatboss.pvpcortp.Home;
import xyz.imdafatboss.pvpcortp.config.ConfigYML;
import xyz.imdafatboss.pvpcortp.gui.RTPGui;
import xyz.imdafatboss.pvpcortp.utils.Economy;
import xyz.imdafatboss.pvpcortp.utils.Locations;

public class RTPEvent implements Listener{

    Home plugin;
    public RTPEvent(Home instance){

        this.plugin = instance;

    }
    RTPGui gui;

    @EventHandler
    public void onClick(InventoryClickEvent e){

        gui = new RTPGui(plugin);
        if(e.getWhoClicked() instanceof Player){

            Player p = (Player) e.getWhoClicked();
            if(e.getInventory().getName().equals(gui.rtpGUI().getName())){

                if(e.getCurrentItem() == null || !e.getCurrentItem().hasItemMeta()){ e.setCancelled(true); return; }

                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")){ e.setCancelled(true) ;return; }

                // Near TP
                if(e.getCurrentItem().getItemMeta().getDisplayName().contains(gui.getNearTP().getItemMeta().getDisplayName())){

                    String prefix = new ConfigYML(plugin, ConfigYML.Value.PREFIX).getString();
                    String perm = new ConfigYML(plugin, ConfigYML.Value.NEAR_PERM).getString();
                    if(!p.hasPermission(perm)){

                        e.setCancelled(true);
                        p.closeInventory();

                        String noperm = new ConfigYML(plugin, ConfigYML.Value.NO_PERM).getString();
                        p.sendMessage(prefix + " " + noperm);

                        return;

                    }
                    else{

                        int cost = new ConfigYML(plugin, ConfigYML.Value.NEAR_COST).getInt();
                        try{

                            if(!Economy.hasEnough(p, cost)){

                                String notEnough = new ConfigYML(plugin, ConfigYML.Value.NOT_ENOUGH).getString();
                                e.setCancelled(true);
                                p.closeInventory();
                                p.sendMessage(prefix + " " + notEnough);

                            }
                            else{

                                try{

                                    Economy.removeMoney(p, cost);

                                }catch (Exception e2){

                                    e2.printStackTrace();

                                }

                                int range = new ConfigYML(plugin, ConfigYML.Value.NEAR_RANGE).getInt();
                                e.setCancelled(true);
                                Location ol = p.getLocation();
                                Location loc = Locations.newLocation(p.getWorld(), range);
                                p.closeInventory();
                                p.teleport(loc);
                                p.playSound(loc, Sound.EXPLODE, 1.0F, 1.0F);
                                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 100));

                                String msg = new ConfigYML(plugin, ConfigYML.Value.TP_MSG).getString();
                                double distance = ol.distance(loc);
                                String tpMsg = msg.replaceAll("%distance%", distance + "");
                                p.sendMessage(prefix + " " + tpMsg);
                                return;

                            }

                        }catch(Exception e1){

                            e1.printStackTrace();

                        }

                    }

                }

                // Medium TP
                if(e.getCurrentItem().getItemMeta().getDisplayName().contains(gui.getMediumTP().getItemMeta().getDisplayName())){

                    String prefix = new ConfigYML(plugin, ConfigYML.Value.PREFIX).getString();
                    String perm = new ConfigYML(plugin, ConfigYML.Value.MEDIUM_PERM).getString();
                    if(!p.hasPermission(perm)){

                        e.setCancelled(true);
                        p.closeInventory();

                        String noperm = new ConfigYML(plugin, ConfigYML.Value.NO_PERM).getString();
                        p.sendMessage(prefix + " " + noperm);

                        return;

                    }
                    else{

                        int cost = new ConfigYML(plugin, ConfigYML.Value.MEDIUM_COST).getInt();
                        try{

                            if(!Economy.hasEnough(p, cost)){

                                String notEnough = new ConfigYML(plugin, ConfigYML.Value.NOT_ENOUGH).getString();
                                e.setCancelled(true);
                                p.closeInventory();
                                p.sendMessage(prefix + " " + notEnough);

                            }
                            else{

                                try{

                                    Economy.removeMoney(p, cost);

                                }catch (Exception e2){

                                    e2.printStackTrace();

                                }

                                int range = new ConfigYML(plugin, ConfigYML.Value.MEDIUM_RANGE).getInt();
                                e.setCancelled(true);
                                Location ol = p.getLocation();
                                Location loc = Locations.newLocation(p.getWorld(), range);
                                p.closeInventory();
                                p.teleport(loc);
                                p.playSound(loc, Sound.EXPLODE, 1.0F, 1.0F);
                                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 100));

                                String msg = new ConfigYML(plugin, ConfigYML.Value.TP_MSG).getString();
                                double distance = ol.distance(loc);
                                String tpMsg = msg.replaceAll("%distance%", distance + "");
                                p.sendMessage(prefix + " " + tpMsg);
                                return;

                            }

                        }catch(Exception e1){

                            e1.printStackTrace();

                        }

                    }

                }

                if(e.getCurrentItem().getItemMeta().getDisplayName().contains(gui.getExtremeTP().getItemMeta().getDisplayName())){

                    String prefix = new ConfigYML(plugin, ConfigYML.Value.PREFIX).getString();
                    String perm = new ConfigYML(plugin, ConfigYML.Value.EXTREME_PERM).getString();
                    if(!p.hasPermission(perm)){

                        e.setCancelled(true);
                        p.closeInventory();

                        String noperm = new ConfigYML(plugin, ConfigYML.Value.NO_PERM).getString();
                        p.sendMessage(prefix + " " + noperm);

                        return;

                    }
                    else{

                        int cost = new ConfigYML(plugin, ConfigYML.Value.EXTREME_COST).getInt();
                        try{

                            if(!Economy.hasEnough(p, cost)){

                                String notEnough = new ConfigYML(plugin, ConfigYML.Value.NOT_ENOUGH).getString();
                                e.setCancelled(true);
                                p.closeInventory();
                                p.sendMessage(prefix + " " + notEnough);

                            }
                            else{

                                try{

                                    Economy.removeMoney(p, cost);

                                }catch (Exception e2){

                                    e2.printStackTrace();

                                }

                                int range = new ConfigYML(plugin, ConfigYML.Value.EXTREME_RANGE).getInt();
                                e.setCancelled(true);
                                Location ol = p.getLocation();
                                Location loc = Locations.newLocation(p.getWorld(), range);
                                p.closeInventory();
                                p.teleport(loc);
                                p.playSound(loc, Sound.EXPLODE, 1.0F, 1.0F);
                                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 100));

                                String msg = new ConfigYML(plugin, ConfigYML.Value.TP_MSG).getString();
                                double distance = ol.distance(loc);
                                String tpMsg = msg.replaceAll("%distance%", distance + "");
                                p.sendMessage(prefix + " " + tpMsg);
                                return;

                            }

                        }catch(Exception e1){

                            e1.printStackTrace();

                        }

                    }

                }

            }

        }

    }

}
