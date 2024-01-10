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

		if (numOfAllowedAttempts == 0) {
			return null;
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your name:");
		String name = sc.next();
		System.out.println("Enter Your Password:");
		String password = sc.next();
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
			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("An error occurs.");
			System.out.println();
			MainClass.main(null);
		}
		
		numOfAllowedAttempts--;
		System.out.println("you enterd invalid password or username\n" + "You have only " + (numOfAllowedAttempts)
				+ " Attempts to enter valid " 
				+ "username and password");
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
