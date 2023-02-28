
public class DoorGameTest
{

	public static void main(String[] args)
	{

		DoorGame def = new DoorGame();
		def.playGame();
		System.out.println("Percent of win if chaged choice: " + def.getChange() + "%");
		System.out.println("Percent of win if choice stayed: " + def.getStay() + "%");

	}

}
