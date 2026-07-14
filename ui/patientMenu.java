package ui;
import util.Input;
import service.patientService;

public class patientMenu {
    public static void menu(){
        while(true){
        System.out.println("Enter your option: ");
        System.out.println("1.Create");
        System.out.println("2.Update");
        System.out.println("3.Search");
        System.out.println("4.Delete");
        System.out.println("Enter 0 for exit.");
        int option = Integer.parseInt(Input.scanner.nextLine());
        if(option == 0) break;
        switch(option){
            case 1:
                patientService.create();
                break;
            case 2:
                patientService.update();
                break;
            case 3:
                patientService.read();
                break;
            case 4:
                patientService.delete();
                break;
            default:
                System.out.println("Invalid input!!!!!!!!!!");
        }
    }
    }
}
