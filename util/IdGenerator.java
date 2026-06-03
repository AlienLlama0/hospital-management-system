package util;

public class IdGenerator {
    static int totalPaitent = 0;

    public static String generatePaitentId(){
        return "PAS-" + ++totalPaitent;
    }
}
