import enums.BloodGroup;
import model.Patient;
import storage.DataManager;
import storage.Connect;

public class Main{
    public static void main(String[] args) {
        Connect.initialize();
        System.out.println("Hello World!");
        DataManager.loadData();
        DataManager.showData();
    }
}