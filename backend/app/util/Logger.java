package util;

public class Logger {

    public static void console(String text) {
        System.out.println(text);
    }

    public static void console(String ...texts) {
        for (String msg : texts) {
            console(msg);
        }
    }

}
