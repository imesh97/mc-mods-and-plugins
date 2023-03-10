package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.ChatAPI;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.Msg;

public class KickCmd extends CommandFactory{

    Home plugin;
    public KickCmd(Home instance){

        super("kick", "sesamebans.kick", true);
        this.plugin = instance;

    }
    PlayerAPI papi;
    MessagesYML msg;
    ChatAPI chat;
    ConfigYML cfg;

    @Override
    public void execute(CommandSender sender, String[] args){

        papi = new PlayerAPI(plugin);
        msg = new MessagesYML(plugin);
        chat = new ChatAPI(plugin);
        cfg = new ConfigYML(plugin);
        if(args.length == 0){

            sender.sendMessage(msg.prefix() + msg.getUsageKick());
            return;

        }

        else if(args.length == 1){

            String a1 = args[0];
            Player p = Bukkit.getPlayer(a1);
            if(p != null){

                papi.kickPlayer(p);
                chat.broadcastKick(p, sender.getName(), cfg.getDefaultKick());
                return;

            }

            else{

                sender.sendMessage(msg.prefix() + msg.getPlayerOffline());
                return;

            }

        }

        else if(args.length > 1){

            String a1 = args[0];
            Player p = Bukkit.getPlayer(a1);
            if(p != null){

                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < args.length; i++){

                    sb.append(args[i]).append(" ");

                }
                String msg = sb.toString().trim();
                String reason = Msg.translate(msg);

                papi.kickPlayer(p, reason);
                chat.broadcastKick(p, sender.getName(), reason);
                return;

            }

            else{

                sender.sendMessage(msg.prefix() + msg.getPlayerOffline());
                return;

            }

        }

    }

}
