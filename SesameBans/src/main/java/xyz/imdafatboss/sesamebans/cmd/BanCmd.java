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
import xyz.imdafatboss.sesamebans.utils.Msg;

public class BanCmd extends CommandFactory{

    Home plugin;
    public BanCmd(Home instance){

        super("ban", "sesamebans.ban", true);
        this.plugin = instance;

    }
    ConfigYML cfg;
    MessagesYML msg;
    PlayerAPI papi;
    ChatAPI chat;

    @Override
    public void execute(CommandSender sender, String[] args){

        cfg = new ConfigYML(plugin);
        msg = new MessagesYML(plugin);
        papi = new PlayerAPI(plugin);
        chat = new ChatAPI(plugin);
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length <= 1) {

                p.sendMessage(cfg.prefix() + msg.getUsageBan());
                return;

            } else if (args.length >= 2) {

                String a1 = args[0];
                Player tar = Bukkit.getPlayer(a1);

                if (tar != null) {

                    if (!papi.isBanned(tar)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {

                            sb.append(args[i]).append(" ");

                        }
                        String msg = sb.toString().trim();
                        String reason = Msg.translate(msg);

                        papi.banPlayer(tar, reason);
                        chat.broadcastBan(tar, p.getName());
                        papi.kickPlayer(tar, cfg.banScreen(tar));
                        return;

                    } else {

                        p.sendMessage(cfg.prefix() + msg.getAlreadyBanned());
                        return;

                    }

                } else {

                    OfflinePlayer tarp = Bukkit.getOfflinePlayer(a1);
                    if (tarp != null) {

                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {

                            sb.append(args[i]).append(" ");

                        }
                        String msg = sb.toString().trim();
                        String reason = Msg.translate(msg);

                        papi.banOfflinePlayer(tarp, reason);
                        chat.broadcastBan(tarp, sender.getName());
                        return;

                    } else {

                        sender.sendMessage(cfg.prefix() + msg.getPlayerNotExist());
                        return;

                    }

                }

            }
        }
        else{

            if (args.length <= 1) {

                sender.sendMessage(cfg.prefix() + msg.getUsageBan());
                return;

            } else if (args.length >= 2) {

                String a1 = args[0];
                Player tar = Bukkit.getPlayer(a1);

                if (tar != null) {

                    if (!papi.isBanned(tar)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {

                            sb.append(args[i]).append(" ");

                        }
                        String msg = sb.toString().trim();
                        String reason = Msg.translate(msg);

                        papi.banPlayer(tar, reason);
                        chat.broadcastBan(tar, sender.getName());
                        papi.kickPlayer(tar, cfg.banScreen(tar));
                        return;

                    } else {

                        sender.sendMessage(cfg.prefix() + msg.getAlreadyBanned());
                        return;

                    }

                } else {

                    OfflinePlayer tarp = Bukkit.getOfflinePlayer(a1);
                    if (tarp != null) {

                        StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; i++) {

                            sb.append(args[i]).append(" ");

                        }
                        String msg = sb.toString().trim();
                        String reason = Msg.translate(msg);

                        papi.banOfflinePlayer(tarp, reason);
                        chat.broadcastBan(tarp, sender.getName());
                        return;

                    } else {

                        sender.sendMessage(cfg.prefix() + msg.getPlayerNotExist());
                        return;

                    }

                }

            }

        }

    }

}
