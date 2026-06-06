package storage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import model.Patient;

public class FileHandler {
    public static void createPatientFile(){
        try{
            File db = new File("db");
            if (!(db.exists())) {
                db.mkdirs();
            }

            File patientFile = new File("db/patient.txt");
            patientFile.createNewFile();
        } catch(Exception e){
            System.out.println("An error has occurred while creating paitent.txt");
            e.printStackTrace();
        }
    }


    // Ref: https://davidvlijmincx.com/posts/read-file-from-resources/
    public static List<String> readPatientFile(){
        Path filePath = Path.of("db/patient.txt");
        // Handle error
        List<String> lines = new ArrayList<>();

        try {
            // Read lines directly into a list
            lines = Files.readAllLines(filePath);
            return lines;
        } catch (IOException e) {
            createPatientFile();
            return lines;
        }
    }

    public static void updatePatientFile(){
        Path filePath = Path.of("db/patient.txt");
        // Handle error
        List<Patient> lines = DataManager.paitentList;

        try {
            // Read lines directly into a list
            Files.writeString(filePath, "", StandardOpenOption.CREATE_NEW); // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/StandardOpenOption.html
            for(Patient line : lines){
                String data = line.id + "|" + line.name + "|" + line.age + "|" + line.phone + "|" + line.gender + "|" + line.symptom + "|" + line.bloodGroup + "\n";
                Files.writeString(filePath, data, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Exception : " + "|" + e);
        }
    }
}
