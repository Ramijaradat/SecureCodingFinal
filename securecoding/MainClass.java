package securecoding;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MainClass {

	// main method start
	public static void main(String[] args) {
		while (true) {
			main1();
		}
	}
	public static void main1() {
		String jobTitle = "0";
		String[] infoArr = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of your title " 
		+ "\n 1.Doctor " 
		+ "\n 2.Patient " 
		+ "\n 3.Registrar ");
		
			jobTitle = sc.next();

		if (jobTitle.equals("3")) {
			infoArr = User.checkUsernameAndPassword("Registrar", 4);

			if (infoArr != null) {
				Registrar.enterNewUser();
			}
		}

		else if (jobTitle.equals("1")) {
			infoArr = User.checkUsernameAndPassword("Doctor", 3);

			if (infoArr != null) {
				Doctor dr = new Doctor(infoArr[0], infoArr[2], Integer.parseInt(infoArr[3]), infoArr[4]);
				dr.whatToDo();
				
			}
		}
		else if (jobTitle.equals("2")) {
			infoArr = User.checkUsernameAndPassword("Patient", 5);
			if (infoArr != null) {
				Patient pt = new Patient(infoArr[0], infoArr[2], Integer.parseInt(infoArr[3]), infoArr[4]);
				pt.whatToDo();
			}
		}
		else {
			System.out.println("ENTER ONLY: 1, 2, OR 3.");
			System.out.println();
		}
	}
	// end of main function.
	
	// buffer writer method:
	static void bufferWriter(String entityType, String enteredData) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(entityType + ".txt", true));
			try {
				bw.write(enteredData + "\n");
				// System.out.println("Entered information was added successfully to the database.");
				System.out.println();
			} finally {
				bw.close();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}
//hash function
	public static String hashSHA256(String input) {
		try {
			// Create a MessageDigest object for SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Get the byte array of the input string
			byte[] encodedHash = digest.digest(input.getBytes(StandardCharsets.UTF_8));

			// Convert the byte array to a hexadecimal representation
			StringBuilder hexStringBuilder = new StringBuilder();
			for (byte b : encodedHash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexStringBuilder.append('0');
				}
				hexStringBuilder.append(hex);
			}

			return hexStringBuilder.toString();

		} catch (NoSuchAlgorithmException e) {
			// Handle the exception, e.g., print an error message or log it
			e.printStackTrace();
			return null; // Or throw an exception
		}
	}
}
