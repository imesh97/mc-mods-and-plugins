package xyz.imdafatboss.pvpcortp;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.imdafatboss.pvpcortp.cmd.RTPCmd;
import xyz.imdafatboss.pvpcortp.config.FileManager;
import xyz.imdafatboss.pvpcortp.events.RTPEvent;

public class Home extends JavaPlugin implements Listener{

    public static Permission permission = null;
    public static Economy economy = null;
    public static Chat chat = null;

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().
                getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }

    private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().
                getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().
                getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    FileManager fm = new FileManager(this);
    RTPCmd rtp;
    RTPEvent evt;

    @Override
    public void onEnable(){

        if (!setupEconomy() ) {
            getLogger().info(String.format("[%s] - Disabled due to no Vault dependency found!",
                    getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.setupChat();
        this.setupPermissions();

        fm.getConfig("config.yml").saveDefaultConfig();

        rtp = new RTPCmd(this);
        evt = new RTPEvent(this);
        getLogger().info("Created by imdafatboss");
        PluginManager pm = Bukkit.getPluginManager();

        rtp.getCommands();
        rtp.getAliases();

        pm.registerEvents(evt, this);

    }

}
