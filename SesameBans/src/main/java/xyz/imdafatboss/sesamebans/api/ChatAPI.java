package xyz.imdafatboss.sesamebans.api;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.Msg;
import xyz.imdafatboss.sesamebans.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatAPI {

    Home plugin;
    public ChatAPI(Home instance){

        this.plugin = instance;

    }
    ConfigYML cfg;
    MessagesYML msg;
    DataAPI data;

    public List<Player> getStaff(){

        cfg = new ConfigYML(plugin);
        List<Player> p = new ArrayList<Player>();

        for(Player o : Bukkit.getOnlinePlayers()){

            if(o.hasPermission("sesamebans.staff")){

                p.add(o);

            }

        }

        return p;

    }

    public void sendStaffMessage(String message, Player p){

        cfg = new ConfigYML(plugin);
        String s = cfg.getStaffChat(message, p);
        for(Player o : getStaff()){

            o.sendMessage(s);

        }
        plugin.getLogger().info(s);

    }

    public void sendStaffMessage(String message, String p){

        cfg = new ConfigYML(plugin);
        String s = cfg.getStaffChat(message, p);
        for(Player o : getStaff()){

            o.sendMessage(s);

        }
        plugin.getLogger().info(s);

    }

    public void broadcastBan(Player p, String banner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        ConfigurationSection c = data.getBan(p);
        String reason = c.getString("reason");
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getBanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", reason);
        String s3 = s2.replaceAll("%date%", date);
        String s4 = s3.replaceAll("%banner%", banner);
        String s5 = Msg.translate(s4);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s5);

        }
        plugin.getLogger().info(s5);

    }

    public void broadcastBan(OfflinePlayer p, String banner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        ConfigurationSection c = data.getBan(p.getUniqueId());
        String reason = c.getString("reason");
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getBanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", reason);
        String s3 = s2.replaceAll("%date%", date);
        String s4 = s3.replaceAll("%banner%", banner);
        String s5 = Msg.translate(s4);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s5);

        }
        plugin.getLogger().info(s5);

    }

    public void broadcastUnban(Player p, String unbanner){

        msg = new MessagesYML(plugin);
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getUnbanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%unbanner%", unbanner);
        String s3 = s2.replaceAll("%date%", date);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s3);

        }
        plugin.getLogger().info(s3);

    }

    public void broadcastUnban(OfflinePlayer p, String unbanner){

        msg = new MessagesYML(plugin);
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getUnbanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%unbanner%", unbanner);
        String s3 = s2.replaceAll("%date%", date);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s3);

        }
        plugin.getLogger().info(s3);

    }

    // Muting
    public void broadcastMute(Player p, String banner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        ConfigurationSection c = data.getMute(p);
        String reason = c.getString("reason");
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getMuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", reason);
        String s3 = s2.replaceAll("%date%", date);
        String s4 = s3.replaceAll("%muter%", banner);
        String s5 = Msg.translate(s4);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s5);

        }
        plugin.getLogger().info(s5);

    }

    public void broadcastMute(OfflinePlayer p, String banner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        ConfigurationSection c = data.getMute(p.getUniqueId());
        String reason = c.getString("reason");
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getMuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", reason);
        String s3 = s2.replaceAll("%date%", date);
        String s4 = s3.replaceAll("%muter%", banner);
        String s5 = Msg.translate(s4);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s5);

        }
        plugin.getLogger().info(s5);

    }

    public void broadcastUnmute(Player p, String unbanner){

        msg = new MessagesYML(plugin);
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getUnmuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%unmuter%", unbanner);
        String s3 = s2.replaceAll("%date%", date);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s3);

        }
        plugin.getLogger().info(s3);

    }

    public void broadcastUnmute(OfflinePlayer p, String unbanner){

        msg = new MessagesYML(plugin);
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getUnmuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%unmuter%", unbanner);
        String s3 = s2.replaceAll("%date%", date);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s3);

        }
        plugin.getLogger().info(s3);

    }

    // Kicking
    public void broadcastKick(Player p, String kicker, String reason){

        msg = new MessagesYML(plugin);
        String date = TimeUtils.getDate(System.currentTimeMillis());

        String s = msg.getKickBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%kicker%", kicker);
        String s3 = s2.replaceAll("%date%", date);
        String s4 = s3.replaceAll("%reason%", reason);
        String s5 = Msg.translate(s4);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s5);

        }
        plugin.getLogger().info(s5);

    }

    // Tempbanning
    public void broadcastTempban(Player p, String tempbanner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        String now = TimeUtils.getDate(System.currentTimeMillis());
        ConfigurationSection c = data.getTempban(p);
        String reason = c.getString("reason");
        long t = c.getLong("date");
        String time = TimeUtils.get(t);

        String s = msg.getTempbanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%tempbanner%", tempbanner);
        String s3 = s2.replaceAll("%date%", now);
        String s4 = s3.replaceAll("%time%", time);
        String s5 = s4.replaceAll("%reason%", reason);
        String s6 = Msg.translate(s5);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s6);

        }
        plugin.getLogger().info(s6);

    }

    public void broadcastTempban(OfflinePlayer p, String tempbanner){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        String now = TimeUtils.getDate(System.currentTimeMillis());
        ConfigurationSection c = data.getTempban(p.getUniqueId());
        String reason = c.getString("reason");
        long t = c.getLong("date");
        String time = TimeUtils.get(t);

        String s = msg.getTempbanBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%tempbanner%", tempbanner);
        String s3 = s2.replaceAll("%date%", now);
        String s4 = s3.replaceAll("%time%", time);
        String s5 = s4.replaceAll("%reason%", reason);
        String s6 = Msg.translate(s5);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s6);

        }
        plugin.getLogger().info(s6);

    }

    // Tempmuting
    public void broadcastTempmute(Player p, String tempmuter){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        String now = TimeUtils.getDate(System.currentTimeMillis());
        ConfigurationSection c = data.getTempmute(p);
        String reason = c.getString("reason");
        long t = c.getLong("date");
        String time = TimeUtils.get(t);

        String s = msg.getTempmuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%tempmuter%", tempmuter);
        String s3 = s2.replaceAll("%date%", now);
        String s4 = s3.replaceAll("%time%", time);
        String s5 = s4.replaceAll("%reason%", reason);
        String s6 = Msg.translate(s5);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s6);

        }
        plugin.getLogger().info(s6);

    }

    public void broadcastTempmute(OfflinePlayer p, String tempmuter){

        msg = new MessagesYML(plugin);
        data = new DataAPI(plugin);
        String now = TimeUtils.getDate(System.currentTimeMillis());
        ConfigurationSection c = data.getTempmute(p.getUniqueId());
        String reason = c.getString("reason");
        long t = c.getLong("date");
        String time = TimeUtils.get(t);

        String s = msg.getTempmuteBroadcast();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%tempmuter%", tempmuter);
        String s3 = s2.replaceAll("%date%", now);
        String s4 = s3.replaceAll("%time%", time);
        String s5 = s4.replaceAll("%reason%", reason);
        String s6 = Msg.translate(s5);

        for(Player p1 : Bukkit.getOnlinePlayers()){

            p1.sendMessage(msg.prefix() + s6);

        }
        plugin.getLogger().info(s6);

    }

}
