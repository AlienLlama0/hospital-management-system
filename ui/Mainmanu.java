package ui;
import util.Input;

public class Mainmanu {
    public static void menu(){
        while(true){
        System.out.println("Enter your option");
        System.out.println("1.Patient");
        System.out.println("2.Doctor");
        System.out.println("3.Room");
        System.out.println("4.Appoinment");
        System.out.println("5.Bill");
        System.out.println("6.Admin");
        System.out.println("Enter 0 for exit.");

        int option = Integer.parseInt(Input.scanner.nextLine());
        if(option == 0) break;
        switch(option){
            case 1:
                patientMenu.menu();
                break;
            case 2:
                doctorMenu.menu();
                break;
            case 3:
                roomMenu.menu();
                break;
            default:
                System.out.println("Invalid option");

        }
        }
    }
}
