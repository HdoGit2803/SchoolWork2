import java.math.BigInteger;
public class StatlLibraryTester
{
	public static void main(String[] arg)
	{
		StatsLibrary def = new StatsLibrary();
		System.out.println(def.binomialExact(10, 7, .7));
		System.out.println(def.binomialAtLeast(10, 9, 0.3));
		System.out.println(def.binomialAtMost(5, 1, 0.3));
		System.out.println(def.permutation(10, 9));
		System.out.println(def.combination(10, 9));
		System.out.println(def.geometric(.3, 9));
		
	}
}
