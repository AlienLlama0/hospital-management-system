import storage.DataManager;
import storage.FileHandler;

public class Main{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        DataManager.loadData();
        DataManager.showData();
        FileHandler.updatePatientFile();
    }
}