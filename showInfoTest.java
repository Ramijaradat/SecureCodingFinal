import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class showInfoTest {

	@Test
	public void test10() {
		Doctor objectTest = new Doctor("Ahmed", "0775198833", 33, "male");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		objectTest.showInfo();
		String output = out.toString().trim();
		String expected = "You are Doctor, and here is your infromation\n" + "Your name is: " + "Ahmed"
		+ "\nYour phone number is: " + "0775198833" 
		+ "\n Your age is: " + "33"
		+ "\nYour gender is:" + "male";
		assertEquals(expected, output);
	}
	@Test
	public void test11() {
		Patient objectTest = new Patient("Salma", "0775198844", 39, "female");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		objectTest.showInfo();
		String output = out.toString().trim();
		String expected = "you are a ptient, and the following is your information:\n" + "Your name is: " + "Salma"
		+ "\nYour phone number is: " + "0775198844" 
		+ "\n Your age is: " + "39"
		+ "\nYour gender is:" + "female";
		assertEquals(expected, output);
	}
}
