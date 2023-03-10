package xyz.imdafatboss.sesamebans.cmd.mgt;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.cmd.*;
import xyz.imdafatboss.sesamebans.config.MessagesYML;

import java.util.*;

public class CommandManager implements CommandExecutor {

    Home plugin;
    public CommandManager(Home instance){

        this.plugin = instance;

    }
    MessagesYML msg;

    private List<CommandFactory> commands = new ArrayList<CommandFactory>();

    public void registerCommand(CommandFactory cmd) {

        commands.add(cmd);

    }

    public void registerCommands(Home jp){

        registerCommand(new StaffChatCmd(jp));
        registerCommand(new BanCmd(jp));
        registerCommand(new UnbanCmd(jp));
        registerCommand(new MuteCmd(jp));
        registerCommand(new UnmuteCmd(jp));
        registerCommand(new KickCmd(jp));
        registerCommand(new TempBanCmd(jp));
        registerCommand(new TempMuteCmd(jp));
        registerCommand(new StaffModeCmd(jp));
        registerCommand(new IPBanCmd(jp));
        registerCommand(new IPUnbanCmd(jp));

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        msg = new MessagesYML(plugin);
        for (CommandFactory cmds : commands) {

            if (cmds.getName().equalsIgnoreCase(cmd.getName())){

                if(sender instanceof Player) {

                    if(cmds.getPermission() != null) {

                        if (sender.hasPermission(cmds.getPermission())) {

                            cmds.execute(sender, args);

                        }

                        else{

                            sender.sendMessage(msg.prefix() + msg.getNoPerm());

                        }

                    }

                    else{

                        cmds.execute(sender, args);

                    }

                }

                else{

                    if(cmds.allowsConsole()){

                        cmds.execute(sender, args);

                    }

                    else{

                        sender.sendMessage(msg.prefix() + msg.getPlayerOnlyCmd());

                    }

                }

            }

        }

        return false;

    }

}