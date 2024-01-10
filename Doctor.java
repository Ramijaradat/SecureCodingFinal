import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;

public class Doctor extends DoctorPatient {
	

	Doctor(String name, String phoneNumber, int age, String gender) {
		super(name, phoneNumber, age, gender);
	}

	void showInfo() {
		System.out.println("You are Doctor, and here is your infromation");
		super.showInfo();
		return;
		
	}

	void whatToDo() {
		int choice = 9;
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Please, enter number of operation you want to carry out:"
					+ "\n1. Show your information: name, phonenumber, age, and gender."
					+ "\n2. Enter medical information of a specific patient by his/her name: "
					+ "medical situation and medical treatment."
					+ "\n Or Enter 0 to Log Out");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println(e);
			}
			if (choice == 1) {
				showInfo();
			} else if (choice == 2) {
				enterMedicalInfo();
			} else if (choice == 0) {
				 MainClass.main(null);
			} else {
				System.out.println("Wrong Input.");
				}
			whatToDo();
		
	}

	void enterMedicalInfo() {
		System.out.println("You Are going to enter sensitive information, hence we should authenticate your identity");
		String [] str = User.checkUsernameAndPassword("Doctor", 3);
		if (str==null) {
			return;
		}
		String patientName;
		Scanner sc = new Scanner(System.in);
		String medicalSituation;
		String medicalTreatment;
		String[] infoArr = new String[3];
		do {
			System.out.println("please enter his/her name: \n Or Enter 0 to exit.");
			patientName = sc.next();
			if (patientName.trim().equals("0")) {
				return;
			}
			if (!Patient.isPatientexist(patientName)) {
				System.out.println("Name Does Not Exist!");
			} else {
				infoArr[0] = patientName;
			}
		} while (!Patient.isPatientexist(patientName));

		System.out.println("Enter his/her medical situation:");
		medicalSituation = sc.next();
		infoArr[1] = medicalSituation;
		System.out.println("Enter his/her medical treatment:");
		medicalTreatment = sc.next();
		infoArr[2] = medicalTreatment;
		StringBuilder all = new StringBuilder();
		for (String element : infoArr) {
			all.append(element).append(",");
		}
		String enteredData = all.toString().trim();
		MainClass.bufferWriter("PatientMedicalInfo", enteredData);
		
		MainClass.bufferWriter("Logs", "The Doctor with name " + this.getName() + " and phone number " + this.getPhoneNumber() +" entered the medical info for the patient "+patientName  + " as follows: 1- medical treatment: " + medicalTreatment + " 2-medical situation: "+ medicalSituation +" at time:"+ LocalTime.now() +"   "+ LocalDate.now());
		return;
	}
}
