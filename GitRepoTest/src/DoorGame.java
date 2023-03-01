/*
 * program that calculate the chances of winning a game where there are 3 doors
 * 1 door is the winning door other are losing doors
 * choose 1 then the host opens one of the losing doors 
 * then the player has a choice of changing his answer or not
 * calculate the probability of winning if the player changed his answer and if he had not
 */
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
	
	/*
	 * method to simulate door game 10000 times tallying how many times won if a person stayed or changed his choice
	 * represent the doors in the game by designating them a number from 0-2
	 * @param choice = choice of the player
	 * @param win = the winning door
	 * @param lose1 and lose2 = the 2 losing doors
	 * @param open = the door that the host open
	 * @param temp = a temp holder to represent the plater old choice if he decides to change
	 */
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
			//generate the winning door by assigning it a number 0-2
			win = rand.nextInt(3);
			
			//generate a losing door number 0-2 while the losing door # the same as the winning door # generate losing door again
			lose1 = rand.nextInt(3);
			while(lose1 == win)
			{
				lose1 = rand.nextInt(3);
			}
			
			//generate a # 0-2 for the second lost door while loop so that it not the same # as the other 2 doors
			lose2 = lose1;
			while(lose2 == lose1 || lose2 == win)
			{
				lose2 = rand.nextInt(3);
			}
			
			//generate a number 0-2 and that is the choice of the door chosen
			choice = rand.nextInt(3);
			/*
			 * if the current chosen door is the same as the winning door then tally 1 win for staying
			 * since in this scenario the player will not change his choice there no need
			 * to have the program open a door yet
			 */
			if(choice == win)
			{
				stayW++;
			}
			
			
			//part 2 of the same program now assume that the player will now choose to change his choice
			temp = choice;
			open = choice;
			//open a door while making sure it not the winning door or the chosen door
			while(open == choice || open == win)
			{
				open = rand.nextInt(3);
			} 
			
			//changes the door chosen while loop to assure that the changed choice is not the same # as the open door or the current choice
			while(choice == open || choice == temp)
			{
				choice = rand.nextInt(3);
			}

			//if the choice # after changing choice is the same as the winning number tally 1 win for change
			if(choice == win)
			{
				changeW++;
			}

		}
	}
	
	//return the probability of winning if the player had changed their choice
	public double getChange()
	{
		return (changeW/10000)*100;
	}
	
	//return chance of winning if you chosen to not change your choice
	public double getStay()
	{
		return (stayW/10000)*100;
	}
	
	
}
