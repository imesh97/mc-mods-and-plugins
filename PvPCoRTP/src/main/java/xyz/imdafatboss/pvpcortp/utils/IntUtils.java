package xyz.imdafatboss.pvpcortp.utils;

public class IntUtils {

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int getInt(String s){

        return Integer.parseInt(s);

    }

}
