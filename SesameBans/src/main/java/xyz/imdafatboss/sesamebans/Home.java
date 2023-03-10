package xyz.imdafatboss.sesamebans;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandManager;
import xyz.imdafatboss.sesamebans.config.FileManager;
import xyz.imdafatboss.sesamebans.events.*;

import java.util.Arrays;

public class Home extends JavaPlugin implements Listener{

    FileManager fm = new FileManager(this);
    CommandManager cmd;

    @Override
    public void onEnable(){

        // Save default config files
        fm.getConfig("config.yml").saveDefaultConfig();
        fm.getConfig("messages.yml").saveDefaultConfig();
        fm.getConfig("data.yml").saveDefaultConfig();

        // Initialize
        cmd = new CommandManager(this);
        PluginManager pm = Bukkit.getServer().getPluginManager();

        // Manage all commands.
        cmd.registerCommands(this);
        getCommand("staffchat").setExecutor(cmd);
        getCommand("ban").setExecutor(cmd);
        getCommand("unban").setExecutor(cmd);
        getCommand("mute").setExecutor(cmd);
        getCommand("unmute").setExecutor(cmd);
        getCommand("kick").setExecutor(cmd);
        getCommand("tempban").setExecutor(cmd);
        getCommand("tempmute").setExecutor(cmd);
        getCommand("staffmode").setExecutor(cmd);
        getCommand("ipban").setExecutor(cmd);
        getCommand("unbanip").setExecutor(cmd);

        String[] scAliases = {"sc", "schat", "staffc"};
        getCommand("staffchat").setAliases(Arrays.asList(scAliases));
        getCommand("staffchat").setDescription("Communicate with the other staff on the server");

        String[] banAliases = {"banplayer", "banp"};
        getCommand("ban").setAliases(Arrays.asList(banAliases));
        getCommand("ban").setDescription("Ban a player");

        String[] unbanAliases = {"unbanplayer", "unbanp", "uban"};
        getCommand("unban").setAliases(Arrays.asList(unbanAliases));
        getCommand("unban").setDescription("Unban a player");

        String[] muteAliases = {"mutep", "muteplayer"};
        getCommand("mute").setAliases(Arrays.asList(muteAliases));
        getCommand("mute").setDescription("Mute a player");

        String[] unmuteAliases = {"unmutep", "unmuteplayer", "umute"};
        getCommand("unmute").setAliases(Arrays.asList(unmuteAliases));
        getCommand("unmute").setDescription("Unmute a player");

        String[] kickAliases = {"kickp", "kickplayer"};
        getCommand("kick").setAliases(Arrays.asList(kickAliases));
        getCommand("kick").setDescription("Kick a player");

        String[] tempbanAliases = {"tempbanp", "tempbanplayer", "bantemp"};
        getCommand("tempban").setAliases(Arrays.asList(tempbanAliases));
        getCommand("tempban").setDescription("Tempban a player");

        String[] tempmuteAliases = {"tempmutep", "tempmuteplayer", "mutetemp"};
        getCommand("tempmute").setAliases(Arrays.asList(tempmuteAliases));
        getCommand("tempmute").setDescription("Tempmute a player");

        String[] staffmodeAliases = {"staff", "modestaff"};
        getCommand("staffmode").setAliases(Arrays.asList(staffmodeAliases));
        getCommand("staffmode").setDescription("Enter into staff mode");

        String[] ipbanAliases = {"banip"};
        getCommand("ipban").setAliases(Arrays.asList(ipbanAliases));
        getCommand("ipban").setDescription("Ban a player through IPs");

        String[] unbanipAliases = {"ipunban"};
        getCommand("unbanip").setAliases(Arrays.asList(unbanipAliases));
        getCommand("unbanip").setDescription("Unban a player through IPs");

        // Events
        pm.registerEvents(new BanEvents(this), this);
        pm.registerEvents(new MuteEvents(this), this);
        pm.registerEvents(new TempbanEvents(this), this);
        pm.registerEvents(new TempmuteEvents(this), this);
        pm.registerEvents(new StaffModeEvents(this), this);

    }

}
