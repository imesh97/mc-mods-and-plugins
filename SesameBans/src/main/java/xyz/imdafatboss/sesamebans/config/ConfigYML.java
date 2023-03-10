package xyz.imdafatboss.sesamebans.config;

import java.util.*;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.DataAPI;
import xyz.imdafatboss.sesamebans.utils.Msg;
import xyz.imdafatboss.sesamebans.utils.TimeUtils;

public class ConfigYML {

    Home plugin;
    public ConfigYML(Home instance){

        this.plugin = instance;

    }
    FileManager fm;
    DataAPI data;

    public FileManager.Config getConfig(){

        fm = new FileManager(plugin);
        return fm.getConfig("config.yml");

    }

    public String getPrefix(){

        return Msg.translate(getConfig().get().getString("prefix"));

    }

    public String prefix(){

        return getPrefix() + " ";

    }

    public String getDefaultKick(){

        return Msg.translate(getConfig().get().getString("default.kick"));

    }

    public String getStaffChatFormat(){

        return getConfig().get().getString("sc-format");

    }

    public String getStaffChat(String message, Player p){

        String s = getStaffChatFormat();
        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%message%", message);

        return Msg.translate(s2);

    }

    public String getStaffChat(String message, String p){

        String s = getStaffChatFormat();
        String s1 = s.replaceAll("%player%", p);
        String s2 = s1.replaceAll("%message%", message);

        return Msg.translate(s2);

    }

    public String getBanScreen(){

        return getConfig().get().getString("screen.ban");

    }

    public String banScreen(Player p){

        data = new DataAPI(plugin);
        String s = getBanScreen();
        ConfigurationSection c = data.getBan(p);

        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", c.getString("reason"));
        String s3 = Msg.translate(s2);

        return s3;

    }

    public String getTempbanScreen(){

        return getConfig().get().getString("screen.tempban");

    }

    public String tempbanScreen(Player p){

        data = new DataAPI(plugin);
        String s = getTempbanScreen();
        ConfigurationSection c = data.getTempban(p);
        String time = TimeUtils.get(c.getLong("date"));

        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", c.getString("reason"));
        String s3 = s2.replaceAll("%time%", time);
        String s4 = Msg.translate(s3);

        return s4;

    }

    public String getTempmuteScreen(){

        return getConfig().get().getString("screen.tempmute");

    }

    public String tempmuteScreen(Player p){

        data = new DataAPI(plugin);
        String s = getTempmuteScreen();
        ConfigurationSection c = data.getTempmute(p);
        String time = TimeUtils.get(c.getLong("date"));

        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", c.getString("reason"));
        String s3 = s2.replaceAll("%time%", time);
        String s4 = Msg.translate(s3);

        return s4;

    }

    public String getMuteScreen(){

        return getConfig().get().getString("screen.mute");

    }

    public String muteScreen(Player p){

        data = new DataAPI(plugin);
        String s = getMuteScreen();
        ConfigurationSection c = data.getMute(p);

        String s1 = s.replaceAll("%player%", p.getName());
        String s2 = s1.replaceAll("%reason%", c.getString("reason"));
        String s3 = Msg.translate(s2);

        return s3;

    }

    public int getTPRadius(){

        return getConfig().get().getInt("randomtp-radius");

    }

    public String getIPBanScreen(){

        return Msg.translate(getConfig().get().getString("screen.ipban"));

    }

}
