package xyz.imdafatboss.sesamebans.utils;

import java.util.*;

public class TimeUtils {

    public static String getMonth(int i){

        String s = "";

        if(i == 0){

            s = "January";

        }

        else if(i == 1){

            s = "February";

        }

        else if(i == 2){

            s = "March";

        }

        else if(i == 3){

            s = "April";

        }

        else if(i == 4){

            s = "May";

        }

        else if(i == 5){

            s = "June";

        }

        else if(i == 6){

            s = "July";

        }

        else if(i == 7){

            s = "August";

        }

        else if(i == 8){

            s = "September";

        }

        else if(i == 9){

            s = "October";

        }

        else if(i == 10){

            s = "November";

        }

        else if(i == 10){

            s = "December";

        }

        return s;

    }

    public static String getDate(long time){

        Calendar cal;
        String month;
        int monthInt;
        int day;
        int year;
        String date;

        cal = Calendar.getInstance();
        cal.setTimeInMillis(time);

        monthInt = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        year = cal.get(Calendar.YEAR);
        month = getMonth(monthInt);

        date = month + " " + day + ", " + year;

        return date;

    }

    public static String get(long time) {

        long left = time - System.currentTimeMillis();
        int seconds = (int) (left / 1000L) % 60;
        int minutes = (int) (left / 60000L % 60L);
        int hours = (int) (left / 3600000L % 24L);
        int days = (int) (left / 86400000L);
        if (days > 1)
            return days + "d " + hours + "h " + minutes + "m " + seconds + "s";
        if (hours > 1)
            return hours + "h " + minutes + "m " + seconds + "s";
        if (minutes > 1) {
            return minutes + "m " + seconds + "s";
        }
        return seconds + "s";

    }

}
