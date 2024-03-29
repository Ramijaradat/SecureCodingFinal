package securecoding;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Registrar {

	static String doctorOrPatient() {
		Scanner sc = new Scanner(System.in);
		System.out.println("You can add doctor or patient\n" + "Enter the number of the user you want to add\n"
				+ " 1.Doctor\n" + " 2.Patient");
		int typeOfUser = 9;
		try {
			typeOfUser = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("You Entered invalid input");
			return doctorOrPatient();
		}

		if (typeOfUser == 1) {
			return "Doctor";
		} else if (typeOfUser == 2) {
			return "Patient";
		} else {
			System.out.println("You Entered invalid input");
			return doctorOrPatient();
		}
	}

	static String getInfoOfPatientOrDoctor() {

		Scanner sc = new Scanner(System.in);
		String[] infoArr = new String[5];
		String name;
		String password;
		int age;
		String gender;
		System.out.println("Please enter his/her name:");
		name = sc.next();
		infoArr[0] = name;
		
		do {
			System.out.println("Please enter his/her password between 8 to 30 characters.");
			password = sc.next();
			 
		} while (!isValidPassword(password));
		password = MainClass.hashSHA256(password);
		infoArr[1] = password;
		System.out.println("Please enter his/her phone number");
		String phoneNumber = sc.next();
		infoArr[2] = phoneNumber;
		age = 0;
		do {
			System.out.println("Please enter his/her age");
			try {
				age = sc.nextInt();
				infoArr[3] = Integer.toString(age);
			} catch (InputMismatchException e) {
				System.out.println("you entered invalid age, try again");
				System.out.println();
				age = sc.nextInt();
				infoArr[3] = Integer.toString(age);
			}
		} while (age > 150 || age < 1);
		System.out.println("Please enter his/her gender: male, female");
		do {
			System.out.println("please enter only 'male' or 'female'");
			gender = sc.next().toLowerCase();
		} while (!gender.equals("male") && !gender.equals("female"));
		infoArr[4] = gender;

		StringBuilder all = new StringBuilder();
		for (String element : infoArr) {
			all.append(element).append(",");
		}
		String enteredData = all.toString().trim();
		return enteredData;
	}

	static void enterNewUser() {
		System.out.println("To add new user, Enter any key.\nTo log out enter 0.");
		String in = "";
		Scanner sc = new Scanner(System.in);
		try {
			in = sc.next();
		} catch (InputMismatchException e) {
			System.err.println(e);
		}
		if (in.equals("0")) {
			return;
		}
		String entityType = doctorOrPatient();
		String enteredData = getInfoOfPatientOrDoctor();
		MainClass.bufferWriter(entityType, enteredData);
		// enterNewUser();

	}

	public static boolean isValidPassword(String password) {
		// Regular expression to match the password policy:
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$";
		Pattern pattern = Pattern.compile(regex);

		if (pattern.matcher(password).matches()) {
			return true; // Password is valid
		} else {
			System.out.println("Password does not meet the policy requirements. Please ensure it:\n"
					+ "- Is between 8-30 characters long.\n"
					+ "- Contains at least one lowercase letter, one uppercase letter, one number, and one special character (@$!%*?&).\n"
					+ "- Does not contain spaces or other restricted characters.");
			return false; // Password is invalid
		}
	}
}
