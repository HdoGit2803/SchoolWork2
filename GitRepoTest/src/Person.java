/*
 * program that calculate the chances of 2 student in a classroom of x size having the same birthday
 * after y trials
 * where x and y are based on user input
 */
import java.util.Random;
public class Person
{
	private double match;
	private double run;
	private int student;

	/*
	 * @param student = the # of students in the class
	 * @param run = the # of trials being done
	 * @param match = the number of matches 1 per trial starts
	 */
	public Person(int stu,int ru)
	{
		match = 0;
		run = ru;
		student = stu;
	}
	
	/*
	 * method to tally if a class of x student will have 2 people with matching birthday
	 * out of y trials
	 * @param bDay = an array that represent students in the class and their birthdays
	 */
	public void birthday()
	{
		Random rand = new Random();
		//for loop the goes for however many trails needed determined by @run
		for(int i = 0;i<=run;i++)
		{
			//create an array that represent the number of student in the class
			int[] bDay =  new int[student];
			//randomly assign each element that represent a different student with a birthday
			for(int n = 0;n<student;n++)
			{
				bDay[n] = rand.nextInt(365);
			}
			
			//loop that look at each element in the array
				for(int y = 0;y<student;y++)
				{
					//loop that looks at all the following elements in the array
					for(int x = y+1;x<student;x++)
					{
						/*
						 * if the current element y has the same birthday as one of the following element x
						 * then match+1 then end the current run of this trial since we only need 1 match
						 */
						if(bDay[y] == bDay[x])
						{
							match++;	
							y = student;
							x = student;
						}
					}
				}
			}
	}
	
	//calculate the probability of 2 people in a class having the same birthday then return that #
	public double prob()
	{
		return (match/run)*100;
	}
}
