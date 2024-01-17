import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class User {
	private String name;


	User(String name) {
		if (name.length() > 40) {
			return;
		}
		this.setName(name);
		
	}


	static String [] checkUsernameAndPassword(String typeOfUser, int numOfAllowedAttempts) {
		if (numOfAllowedAttempts > 10) {
			System.out.println("NUMBER OF ALLOWED ATTEMPTS CANNOT BE MORE THAN TEN.");
			return null;
		}

		if (numOfAllowedAttempts <= 0) {
			System.out.println("You exceeded the allowed number of attempts");
			return null;
		}
		if (!(typeOfUser.equals("Registrar") || typeOfUser.equals("Doctor") || typeOfUser.equals("Patient"))) {
			System.out.println("WRONG USER TYPE");
			return null;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your name:");
		String name = sc.next();
		if (name.length() > 40) {
			System.out.println("NAME CANNOT BE WITH LENGTH MORE THAN 40 CHAR.");
			return null;
		}
		System.out.println("Enter Your Password:");
		String password = sc.next();
		if (password.length() > 30) {
			System.out.println("Password CANNOT BE WITH LENGTH MORE THAN 30 CHAR.");
			return null;
		}
		String passwordHashed=MainClass.hashSHA256(password);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(typeOfUser + ".txt"));
			try {
				String line;
				// reading the file line by line
				while ((line = br.readLine()) != null) {
					
					String x = line;
					String str[] = x.split(",");
					
					if (name.trim().equals(str[0].trim()) && passwordHashed.trim().equals(str[1].trim())) {
						System.out.println("You logged in successfully");
						System.out.println();
						MainClass.bufferWriter("Logs", "a User with username: "+name+ " entered the system as "+ typeOfUser+ " at: " + LocalTime.now() + "  "+ LocalDate.now());
						
						return str;
						}
					}
				}
			 finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurs.");
			System.out.println();
			return null;
		}
		
		numOfAllowedAttempts--;
		if (numOfAllowedAttempts > 0) {
			System.out.println("you enterd invalid password or username");
		System.out.println("You have only " + (numOfAllowedAttempts)
				+ " Attempts to enter valid " 
				+ "username and password");
		}
		MainClass.bufferWriter("Logs", "a User with username: "+name+ " and password: "+ password+ "  attempted to enter the system as "+ typeOfUser+ " at: " + LocalTime.now() + "  "+ LocalDate.now());
		
		return checkUsernameAndPassword(typeOfUser, numOfAllowedAttempts); 
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
