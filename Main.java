import enums.BloodGroup;
import model.Patient;
import storage.DataManager;
import storage.Connect;
import service.patientService;


public class Main{
    public static void main(String[] args) {
        Connect.initialize();
        System.out.println("Hello World!");
        DataManager.loadData();
        patientService.create();
        DataManager.showData();
    }
}