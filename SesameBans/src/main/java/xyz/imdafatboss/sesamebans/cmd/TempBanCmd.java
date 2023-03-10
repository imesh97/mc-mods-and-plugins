package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.ChatAPI;
import xyz.imdafatboss.sesamebans.api.PlayerAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.IntUtils;
import xyz.imdafatboss.sesamebans.utils.Msg;

public class TempBanCmd extends CommandFactory{

    Home plugin;
    public TempBanCmd(Home instance){

        super("tempban", "sesamebans.tempban", true);
        this.plugin = instance;

    }
    MessagesYML msg;
    PlayerAPI papi;
    ChatAPI chat;
    ConfigYML cfg;

    @Override
    public void execute(CommandSender sender, String[] args){

        msg = new MessagesYML(plugin);
        papi = new PlayerAPI(plugin);
        chat = new ChatAPI(plugin);
        cfg = new ConfigYML(plugin);
        if(args.length < 3){

            sender.sendMessage(msg.prefix() + msg.getUsageTempBan());
            return;

        }

        else if(args.length >= 3){

            String a1 = args[0];
            Player tar = Bukkit.getPlayer(a1);
            if(tar != null){

                String a2 = args[1];
                if(IntUtils.isInt(a2)){

                    int sec = IntUtils.getInt(a2);

                    StringBuilder sb = new StringBuilder();
                    for(int i = 2; i < args.length; i++){

                        sb.append(args[i]).append(" ");

                    }
                    String msg = sb.toString().trim();
                    String reason = Msg.translate(msg);

                    papi.tempBanPlayer(tar, sec, reason);
                    chat.broadcastTempban(tar, sender.getName());
                    papi.kickPlayer(tar, cfg.tempbanScreen(tar));
                    return;

                }
                else{

                    sender.sendMessage(msg.prefix() + msg.getSpecifyProperTime());
                    return;

                }

            }
            else{

                OfflinePlayer tarp = Bukkit.getOfflinePlayer(a1);
                if(tarp != null){

                    String a2 = args[1];
                    if(IntUtils.isInt(a2)){

                        int sec = IntUtils.getInt(a2);

                        StringBuilder sb = new StringBuilder();
                        for(int i = 2; i < args.length; i++){

                            sb.append(args[i]).append(" ");

                        }
                        String msg = sb.toString().trim();
                        String reason = Msg.translate(msg);

                        papi.tempBanPlayer(tarp, sec, reason);
                        chat.broadcastTempban(tarp, sender.getName());
                        return;

                    }
                    else{

                        sender.sendMessage(msg.prefix() + msg.getSpecifyProperTime());
                        return;

                    }

                }
                else{

                    sender.sendMessage(msg.prefix() + msg.getPlayerNotExist());
                    return;

                }

            }

        }

    }

}
