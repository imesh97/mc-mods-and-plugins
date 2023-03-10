package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;

public class IPBanCmd extends CommandFactory{

    Home plugin;
    public IPBanCmd(Home instance){

        super("ipban", "sesamebans.ipban", true);
        this.plugin = instance;

    }
    ConfigYML cfg;
    PlayerAPI papi;
    MessagesYML msg;

    @Override
    public void execute(CommandSender sender, String[] args){

        cfg = new ConfigYML(plugin);
        papi = new PlayerAPI(plugin);
        msg = new MessagesYML(plugin);
        if(args.length == 0){

            sender.sendMessage(msg.prefix() + msg.getUsageIPBan());
            return;

        }
        else if(args.length >= 1){

            String a1 = args[0];
            if(Bukkit.getPlayer(a1) != null){

                Player p = Bukkit.getPlayer(a1);
                papi.ipbanPlayer(p, sender);
                p.kickPlayer(msg.prefix() + cfg.getIPBanScreen());
                return;

            }
            else{

                OfflinePlayer p = Bukkit.getOfflinePlayer(a1);
                papi.ipbanPlayer(p, sender);
                return;

            }

        }

    }

}
