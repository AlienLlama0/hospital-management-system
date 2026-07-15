import storage.DataManager;
import storage.Connect;
import ui.doctorMenu;
import ui.patientMenu;

public class Main{
    public static void main(String[] args) {
        Connect.initialize();
        DataManager.loadData();
        doctorMenu.menu();
        
    }
}