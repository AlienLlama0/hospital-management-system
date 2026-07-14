import enums.BloodGroup;
import model.Patient;
import storage.DataManager;
import ui.patientMenu;
import storage.Connect;
import service.patientService;


public class Main{
    public static void main(String[] args) {
        Connect.initialize();
        DataManager.loadData();
        patientMenu.menu();

        
    }
}