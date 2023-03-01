import java.util.Random;

public class Person
{
	private double match;
	private double run;
	private int student;

	public Person(int stu,int ru)
	{
		match = 0;
		run = ru;
		student = stu;
	}
	
	public void birthday()
	{
		Random rand = new Random();
		for(int i = 0;i<=run;i++)
		{
			int[] bDay =  new int[student];
			for(int n = 0;n<student;n++)
			{
				bDay[n] = rand.nextInt(365);
			}
			
				for(int y = 0;y<student;y++)
				{
					for(int x = y+1;x<student;x++)
					{
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
	
	public double prob()
	{
		return (match/run)*100;
	}
}
