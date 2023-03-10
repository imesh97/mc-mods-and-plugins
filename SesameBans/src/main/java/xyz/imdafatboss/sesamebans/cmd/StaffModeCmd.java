package xyz.imdafatboss.sesamebans.cmd;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.imdafatboss.sesamebans.Home;
import xyz.imdafatboss.sesamebans.cmd.mgt.CommandFactory;
import xyz.imdafatboss.sesamebans.config.MessagesYML;
import xyz.imdafatboss.sesamebans.utils.StaffMode;

public class StaffModeCmd extends CommandFactory{

    Home plugin;
    public StaffModeCmd(Home instance){

        super("staffmode", "sesamebans.staffmode", false);
        this.plugin = instance;

    }
    MessagesYML msg;

    @Override
    public void execute(CommandSender sender, String[] args){

        msg = new MessagesYML(plugin);
        Player p = (Player) sender;
        if(!StaffMode.staffmode.contains(p)){

            StaffMode.staffmode.add(p);
            Inventory inv = p.getInventory();
            ItemStack[] armor = p.getInventory().getArmorContents();

            StaffMode.inventory.remove(p);
            StaffMode.armor.remove(p);

            StaffMode.inventory.put(p, inv);
            StaffMode.armor.put(p, armor);

            p.getInventory().clear();
            p.getInventory().setItem(0, StaffMode.getFlyFeather());
            p.getInventory().setItem(1, StaffMode.getThroughCompass());
            p.getInventory().setItem(3, StaffMode.getRandomTP());
            p.getInventory().setItem(4, StaffMode.getVanisher());
            p.getInventory().setItem(6, StaffMode.getInvseeBook());
            p.getInventory().setItem(7, StaffMode.getFreezeBlock());

            p.sendMessage(msg.prefix() + msg.getActivatedStaffMode());
            return;

        }
        StaffMode.staffmode.remove(p);
        Inventory inv = StaffMode.inventory.get(p);
        ItemStack[] armor = StaffMode.armor.get(p);

        p.getInventory().clear();
        for(int i = 0; i < inv.getSize(); i++){

            if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR) { continue; }

            ItemStack is = inv.getItem(i);
            p.getInventory().addItem(is);
            p.updateInventory();

        }
        p.getInventory().setArmorContents(armor);
        p.updateInventory();

        p.sendMessage(msg.prefix() + msg.getDeactivatedStaffMode());

    }

}
