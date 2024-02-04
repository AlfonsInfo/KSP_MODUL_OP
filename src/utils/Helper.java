package utils;

public class Helper {

    private Helper() {
    }

    public static void log(String activity, String location) {
        String  logMessage= activity +" " + "(" + location + ")".toUpperCase();
        System.out.println(logMessage);
    }

    public static String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 3) {
            StackTraceElement currentMethod = stackTrace[2];
            return currentMethod.getMethodName();
        } else {
            return "UnknownMethod";
        }
    }
}
