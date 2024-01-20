package securecoding;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class checkUsernameAndPasswordTest {

//	@Test
//	public void test1() {
//		String input = "1";
//		InputStream in = new ByteArrayInputStream(input.getBytes());
//		System.setIn(in);
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//		System.setOut(new PrintStream(outContent));
//		String expected = "Enter Your name:";
//		
//	MainClass.main(null);
//	
//	String Actual = outContent.toString().trim();
//	
//	assertEquals(Actual, expected);
//	}
	@Test
	public void test1() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String expected = "NUMBER OF ALLOWED ATTEMPTS CANNOT BE MORE THAN TEN.";
		
	User.checkUsernameAndPassword("Doctor", 11);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test2() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String expected = "You exceeded the allowed number of attempts";
		
	User.checkUsernameAndPassword("Doctor", 0);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test3() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "ramimohammadMahmoudjaradatGggggggggggggggGggffvrfffffffvvvvvvvvvvvvvvffffffffffffffffffffffffffuuuuuffff\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nNAME CANNOT BE WITH LENGTH MORE THAN 40 CHAR.";
		
	User.checkUsernameAndPassword("Doctor", 3);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test4() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "rami\n12345678901234567890123456789009\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nEnter Your Password:\nPassword CANNOT BE WITH LENGTH MORE THAN 30 CHAR.";
		
	User.checkUsernameAndPassword("Registrar", 3);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test5() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "Rami\nJaradat\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nEnter Your Password:\nYou logged in successfully";
		
	User.checkUsernameAndPassword("Registrar", 1);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test6() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "Rami\nJaradaat\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nEnter Your Password:\n\nYou exceeded the allowed number of attempts";
		
	User.checkUsernameAndPassword("Registrar", 1);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test7() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "Raami\nJaradat\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nEnter Your Password:\n\nYou exceeded the allowed number of attempts";
		
	User.checkUsernameAndPassword("Registrar", 1);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test8() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "Rami\nJaradat\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "WRONG USER TYPE";
		
	User.checkUsernameAndPassword("Registrrrar", 1);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
	@Test
	public void test9() {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		String input = "Raami\nJaradat\n";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		String expected = "Enter Your name:\nEnter Your Password:\n\nYou exceeded the allowed number of attempts";
		
	User.checkUsernameAndPassword("Patient", 1);
	
	String Actual = outContent.toString().trim();
	
	assertEquals(Actual, expected);
	}
}
