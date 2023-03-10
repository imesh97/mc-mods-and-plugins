package xyz.imdafatboss.sesamebans.utils;

public class IntUtils {

    public static boolean isInt(String s){

        try{

            Integer.parseInt(s);
            return true;

        }catch (Exception e){

            return false;

        }

    }

    public static int getInt(String s){

        try{

            return Integer.parseInt(s);

        }catch (Exception e){

            e.printStackTrace();

        }

        return 0;

    }

}
