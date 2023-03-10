package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.MessagesYML;

public class IPUnbanCmd extends CommandFactory{

    Home plugin;
    public IPUnbanCmd(Home instance){

        super("unbanip", "sesamebans.unbanip", true);
        this.plugin = instance;

    }
    PlayerAPI papi;
    MessagesYML msg;

    @Override
    public void execute(CommandSender sender, String[] args){

        papi = new PlayerAPI(plugin);
        if(args.length == 0){

            sender.sendMessage(msg.prefix() + msg.getUsageUnbanIP());
            return;

        }
        else if(args.length >= 1){

            String a1 = args[0];
            if(Bukkit.getPlayer(a1) != null){

                Player p = Bukkit.getPlayer(a1);
                papi.unIPBanPlayer(p);
                return;

            }
            else{

                OfflinePlayer p = Bukkit.getOfflinePlayer(a1);
                papi.unIPBanPlayer(p);
                return;

            }

        }

    }

}
