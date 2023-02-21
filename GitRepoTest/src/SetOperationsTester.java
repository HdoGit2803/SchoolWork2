
public class SetOperationsTester
{

	public static void main(String[] args)
	{
		int[] setA = {1,2,3,4};
		int[] setB = {1,2,3,4,5,6};
		int[] whole = {1,2,3,4,5,6,7,8};
		
		SetOperations def = new SetOperations();
		
		System.out.println(def.intersection(setA, setB));
		System.out.println(def.union(setA, setB));
		System.out.println(def.complement(setA, whole));

	}

}
