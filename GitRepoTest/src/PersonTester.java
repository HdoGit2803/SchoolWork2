import java.util.Scanner;

public class PersonTester
{
	public static void main(String[] arg)
	{
		int student;
		int run;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter # of Students");
		student = sc.nextInt();
		System.out.println("Enter # of runs");
		run = sc.nextInt();
		
		Person per = new Person(student, run);
		per.birthday();
		System.out.print("Probability of 2 student sharing a birthday: " +per.prob()+"%");
	}
}
