package streams;

interface Validation{
	public boolean isValid(String userName, String password);
}
public class Lab9Excercise3 {

	public static void main(String[] args) {
		Lab9Excercise3 obj = new Lab9Excercise3();
		obj.createValidation();

	}
	
	public void createValidation() {
		Validation v = (userName, password)-> userName.equals("Vineesha")&&
				password.equals("abc");
		boolean result = v.isValid("Vineesha", "abc");
		System.out.println("Validation : "+result);
		
	}
}