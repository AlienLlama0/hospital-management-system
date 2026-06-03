package storage;
import java.io.File;
import java.io.IOException;

public class FileHandler {
    public void patientFile(){
        try{
            File paitentFile = new File("paitent.txt");

            paitentFile.createNewFile();
        } catch(IOException e){
            System.out.println("An error has occurred while creating paitent.txt");
            e.printStackTrace();
        }
    }
}
