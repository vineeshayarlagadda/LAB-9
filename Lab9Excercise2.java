package streams;

import java.util.Scanner;

interface AddSpaces {
	public String spacesAdded(String str);
}

public class Lab9Excercise2 {

	public static void main(String[] args) {
		Lab9Excercise2 obj = new Lab9Excercise2();
		obj.generateSpace();

	}
	
	public void generateSpace() {
		AddSpaces a = (s)->{
			char c[]= s.toCharArray();
			StringBuffer s1 = new StringBuffer();
			for(char i:c) {
				s1.append(i);
				s1.append(' ');
			}
			String s2 = s1.toString();
			return s2;
		};
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:\n");
		String str = new String(sc.nextLine());
		String result = a.spacesAdded(str);
		System.out.println("Result : "+result);
	}

}
