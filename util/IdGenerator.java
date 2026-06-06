package util;

public class IdGenerator {
    static int totalPaitent = 0;
    static int totalDoctors = 0;
    static int totalNurse = 0;
    static int totalAdmin = 0;

    public static String generatePaitentId(){
        return "PAS-" + totalPaitent++;
    }

    public static String generatedDoctorId(){
        return "DOC-" + totalDoctors++;
    }

    public static String generateNurseId(){
        return "NUS-" + totalNurse++;
    }

    public static String generateAdminId(){
        return "ADM-" + totalAdmin++;
    }
}
