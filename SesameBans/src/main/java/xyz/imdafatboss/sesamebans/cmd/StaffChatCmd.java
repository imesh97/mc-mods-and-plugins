package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.api.ChatAPI;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.ConfigYML;
import xyz.imdafatboss.sesamebans.config.MessagesYML;

public class StaffChatCmd extends CommandFactory{

    Home plugin;
    public StaffChatCmd(Home instance){

        super("staffchat", "sesamebans.staff", true);
        this.plugin = instance;

    }
    ConfigYML cfg;
    MessagesYML msg;
    ChatAPI chat;

    @Override
    public void execute(CommandSender sender, String[] args) {

        cfg = new ConfigYML(plugin);
        msg = new MessagesYML(plugin);
        chat = new ChatAPI(plugin);

        if(sender instanceof Player){

            Player p = (Player) sender;
            if(args.length == 0){

                sender.sendMessage(cfg.prefix() + msg.getUsageSc());

            }

            else if(args.length >= 1){

                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < args.length; i++){

                    sb.append(args[i]).append(" ");

                }
                String msg = sb.toString().trim();

                chat.sendStaffMessage(msg, p);

            }

        }

        else{

            String p = "CONSOLE";
            if(args.length == 0){

                sender.sendMessage(cfg.prefix() + msg.getUsageSc());

            }

            else if(args.length >= 1){

                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < args.length; i++){

                    sb.append(args[i]).append(" ");

                }
                String msg = sb.toString().trim();

                chat.sendStaffMessage(msg, p);

            }

        }

    }
}
