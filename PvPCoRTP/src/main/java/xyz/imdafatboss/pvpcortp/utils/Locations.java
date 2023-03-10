package xyz.imdafatboss.pvpcortp.utils;

import org.bukkit.Location;
import org.bukkit.World;

import java.util.Random;

public class Locations {

    public static Location newLocation(World world, int range){

        Random r = new Random();
        int x = r.nextInt(range) + 1;
        int y = 150;
        int z = r.nextInt(range) + 1;

        Location loc = new Location(world, x, y, z);
        return loc;

    }

}
