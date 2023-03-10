package xyz.imdafatboss.pvpcortp.cmd;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import xyz.imdafatboss.pvpcortp.Home;
import xyz.imdafatboss.pvpcortp.gui.RTPGui;

import java.util.ArrayList;
import java.util.List;

public class RTPCmd implements CommandExecutor{

    Home plugin;
    public RTPCmd(Home instance){

        this.plugin = instance;

    }
    RTPGui gui;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cLabel, String[] args){

        gui = new RTPGui(plugin);
        if(cmd.getName().equalsIgnoreCase("rtp")){

            if(sender instanceof Player){

                Player p = (Player) sender;
                p.openInventory(gui.rtpGUI());

            }

            else{

                plugin.getLogger().info("You must be a player to execute this command.");

            }

        }

        return false;

    }

    public void getCommands(){

        plugin.getCommand("rtp").setExecutor(this);

    }

    public void getAliases(){

        List<String> aliases = new ArrayList<String>();

        aliases.add("wild");
        plugin.getCommand("rtp").setAliases(aliases);

    }

}
