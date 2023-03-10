package xyz.imdafatboss.pvpcortp.utils;

import org.bukkit.entity.Player;
import xyz.imdafatboss.pvpcortp.Home;

public class Economy {

    public static double getMoney(Player player){

        return Home.economy.getBalance(player);

    }

    public static void addMoney(Player player, int money){

        Home.economy.depositPlayer(player, money * 1.0);

    }

    public static void removeMoney(Player player, int money){

        Home.economy.withdrawPlayer(player, money * 1.0);

    }

    public static boolean hasEnough(Player player, int value){

        return value * 1.0 <= Home.economy.getBalance(player);

    }

}
