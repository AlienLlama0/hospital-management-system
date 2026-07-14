package storage;
import java.util.ArrayList;
import java.util.List;
import model.Patient;
import model.Doctor;

public class DataManager {
    public static List<Patient> patientList = new ArrayList<>();
    public static List<Doctor> doctorList = new ArrayList<>();

    public static void loadData(){
        PatientRepository.loadPaitents();
        DoctorRepository.loadDoctor();
    }
}
