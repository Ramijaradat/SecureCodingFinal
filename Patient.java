import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Patient extends DoctorPatient {

	Patient(String name, String phoneNumber, int age, String gender) {
		super(name, phoneNumber, age, gender);
	}
	
void showInfo () {
	System.out.println("you are a ptient, and the following is your information:");
	super.showInfo();
	return;
}

	static boolean isPatientexist(String name) { 

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("Patient.txt"));
			try {
				String line;
				// reading the file line by line
				while ((line = br.readLine()) != null) {
					String x = line;
					String str[] = x.split(",");
					if (name.trim().equals(str[0].trim())) {
						return true;
					}

				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return false;
	}

	public void whatToDo() {
		System.out.println("Please choose number of the operation you want to conduct:" 
							+ "\n1. show your personal information: name, phone number, age, and gender." 
							+ "\n2. show your medical information: medical situation and medical treatment."
							+ "\n Or Enter 0 to Log Out");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		if (choice.trim().equals("1")) {
			showInfo();
		} else if (choice.trim().equals("2")) {
			showMedicalInfo();
		} else if (choice.trim().equals("0")) {
			return;
		} else {
			System.out.println("Wrong Input.");
			}
		whatToDo();
	}
	public void showMedicalInfo () { 
		boolean flag =false;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("PatientMedicalInfo.txt"));
			try {
				String line;
				// reading the file line by line
				while ((line = br.readLine()) != null) {
					String x = line;
					String str[] = x.split(",");
					if (this.getName().equals(str[0])) {
						flag=true;
						System.out.println("Name: " + str[0]+"\nMedical Situation: " + str[1] + "\nMedical Treatment: "+ str [2]);
					}
				}
				if (flag == false) {
					System.out.println("You don't have medical information entered previously!");
				}
			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("An error occours");
		}
		System.out.println();
		return;
	} 
}
