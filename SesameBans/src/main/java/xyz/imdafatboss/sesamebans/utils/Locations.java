package xyz.imdafatboss.sesamebans.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class Locations {

    public static void randomPlayer(Player player){

        ArrayList<Player> players = new ArrayList<Player>();
        for (Player e : Bukkit.getOnlinePlayers()){

            if(!e.getName().equals(player.getName())) {

                players.add(e);

            }
        }
        Player randomPlayer = players.get(new Random().nextInt(players.size()));
        player.teleport(randomPlayer.getLocation());

    }


}
