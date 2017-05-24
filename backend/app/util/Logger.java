package util;

public class Logger {

    public static void log(String text) {
        System.out.println(text);
    }

    public static void log(String ...texts) {
        for (String msg : texts) {
            log(msg);
        }
    }

}
