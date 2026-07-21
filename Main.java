import storage.DataManager;
import storage.Connect;
import ui.Mainmanu;
import ui.doctorMenu;
import ui.patientMenu;

public class Main{
    public static void main(String[] args) {
        Connect.initialize();
        DataManager.loadData();
        Mainmanu.menu();
        
    }
}