package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.ChatAPI;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.MessagesYML;

public class UnbanCmd extends CommandFactory{

    Home plugin;
    public UnbanCmd(Home instance){

        super("unban", "sesamebans.unban", true);
        this.plugin = instance;

    }
    PlayerAPI papi;
    MessagesYML msg;
    ChatAPI chat;

    @Override
    public void execute(CommandSender sender, String[] args){

        papi = new PlayerAPI(plugin);
        msg = new MessagesYML(plugin);
        chat = new ChatAPI(plugin);

        CommandSender p = sender;
        if(args.length == 0){

            p.sendMessage(msg.prefix() + msg.getUsageUnban());
            return;

        }
        else if(args.length >= 1){

            String a1 = args[0];
            Player tar = Bukkit.getPlayer(a1);
            if(tar != null){

                if(papi.isBanned(tar)){

                    papi.unbanPlayer(tar);
                    chat.broadcastUnban(tar, p.getName());
                    return;

                }

                else{

                    p.sendMessage(msg.prefix() + msg.getNotBanned());
                    return;

                }

            }

            else{

                OfflinePlayer tarp = Bukkit.getOfflinePlayer(a1);
                if(tarp != null){

                    if(papi.isBanned(tarp)){

                        papi.unbanOfflinePlayer(tarp);
                        chat.broadcastUnban(tarp, p.getName());
                        return;

                    }

                    else{

                        p.sendMessage(msg.prefix() + msg.getNotBanned());
                        return;

                    }

                }

                else{

                    p.sendMessage(msg.prefix() + msg.getPlayerNotExist());
                    return;

                }

            }

        }

    }

}
