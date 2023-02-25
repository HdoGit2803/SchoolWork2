import java.util.Random;

public class DoorGame
{
	private double changeW;
	private double stayW;
	
	public DoorGame()
	{
		changeW = 0;
		stayW = 0;
	}
	
	public void playGame()
	{
		int choice;
		int temp;
		int win;
		int lose1;
		int lose2;
		int open;
		Random rand = new Random();
		for(int i = 0;i<=10000;i++)
		{
			win = rand.nextInt(3);
			lose1 = rand.nextInt(3);
			while(lose1 == win)
			{
				lose1 = rand.nextInt(3);
			}
			lose2 = lose1;
			while(lose2 == lose1 || lose2 == win)
			{
				lose2 = rand.nextInt(3);
			}
			
			choice = rand.nextInt(3);
			if(choice == win)
			{
				stayW++;
			}
			
			temp = choice;
			open = choice;
			while(open == choice || open == win)
			{
				open = rand.nextInt(3);
			} 
			while(choice == open || choice == temp)
			{
				choice = rand.nextInt(3);
			}

			if(choice == win)
			{
				changeW++;
			}

		}
	}
	
	public double getChange()
	{
		return (changeW/10000)*100;
	}
	public double getStay()
	{
		return (stayW/10000)*100;
	}
	
	
}
