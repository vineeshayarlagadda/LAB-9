package streams;

import java.util.Scanner;

interface Power{
	public double doPower(int x, int y);
}
public class Lab9Excercise1 {

	public static void main(String[] args) {
		Lab9Excercise1 obj = new Lab9Excercise1();
		obj.doPower();
	}
	void doPower() {
		Power p = (x,y) -> Math.pow(x, y);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the x value:");
		int x = sc.nextInt();
		System.out.println("Enter the y value:");
		int y = sc.nextInt();
		double res = p.doPower(x,y);
		System.out.println(res);
		
	}

}