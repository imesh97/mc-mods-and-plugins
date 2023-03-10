package xyz.imdafatboss.pvpcortp.config;

import xyz.imdafatboss.pvpcortp.Home;
import xyz.imdafatboss.pvpcortp.utils.IntUtils;
import xyz.imdafatboss.pvpcortp.utils.Msg;

public class ConfigYML {

    public enum Value{

        PREFIX, NEAR_COST, MEDIUM_COST, EXTREME_COST, NEAR_RANGE, MEDIUM_RANGE, EXTREME_RANGE,
        NEAR_PERM, MEDIUM_PERM, EXTREME_PERM, NOT_ENOUGH, NO_PERM, TP_MSG

    }

    Home plugin;
    Value val;
    public ConfigYML(Home instance, Value v){

        this.plugin = instance;
        this.val = v;

    }
    FileManager fm;

    public int getInt(){

        fm = new FileManager(plugin);

        if(fm.getConfig("config.yml") != null) {

            FileManager.Config cfg = fm.getConfig("config.yml");
            switch (val) {

                case NEAR_COST:

                    return cfg.get().getInt("neartp.cost");

                case NEAR_RANGE:

                    return cfg.get().getInt("neartp.range");

                case MEDIUM_COST:

                    return cfg.get().getInt("mediumtp.cost");

                case MEDIUM_RANGE:

                    return cfg.get().getInt("mediumtp.range");

                case EXTREME_COST:

                    return cfg.get().getInt("extremetp.cost");

                case EXTREME_RANGE:

                    return cfg.get().getInt("extremetp.range");

                default:

                    return 0;


            }

        }

        return 0;

    }

    public String getString(){

        fm = new FileManager(plugin);

        if(fm.getConfig("config.yml") != null) {

            FileManager.Config cfg = fm.getConfig("config.yml");
            switch (val) {

                case PREFIX:

                    return Msg.translate(cfg.get().getString("prefix"));

                case NEAR_PERM:

                    return Msg.translate(cfg.get().getString("neartp.perm"));

                case MEDIUM_PERM:

                    return Msg.translate(cfg.get().getString("mediumtp.perm"));

                case EXTREME_PERM:

                    return Msg.translate(cfg.get().getString("extremetp.perm"));

                case NO_PERM:

                    return Msg.translate(cfg.get().getString("no-perm"));

                case NOT_ENOUGH:

                    return Msg.translate(cfg.get().getString("not-enough"));

                case TP_MSG:

                    return Msg.translate(cfg.get().getString("tp-msg"));

                default:

                    return "The config.yml is invalid.";

            }

        }

        return null;

    }

}
