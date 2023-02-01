
public class DoorGameTest
{

	public static void main(String[] args)
	{

		DoorGame def = new DoorGame();
		def.playGame();
		System.out.println("Number of win if chaged choice " + def.getChange());
		System.out.println("Number of win if choice stay " + def.getStay());

	}

}
