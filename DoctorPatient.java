
public class DoctorPatient extends User {

	private String phoneNumber;
	private int age;
	private String gender;

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() > 10) {
			return;
		}
		this.phoneNumber = phoneNumber;
	}
	DoctorPatient(String name, String phoneNumber, int age, String gender) {
		super(name);
		this.setPhoneNumber(phoneNumber);
		this.age=age;
		if (gender.length() < 10) {
		this.gender=gender;
		}
	}
	void showInfo () {
		System.out.println("Your name is: " + this.getName()
				+ "\nYour phone number is: " + this.getPhoneNumber() 
				+ "\n Your age is: " + this.age 
				+ "\nYour gender is:" + this.gender);
		System.out.println();
	}
}
