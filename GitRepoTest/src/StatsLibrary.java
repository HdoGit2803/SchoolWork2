/*
 * A Statistics Library with method that could be 
 * used to solved Homework problem
 */
import java.math.*;
import java.util.ArrayList;
public class StatsLibrary
{
	public StatsLibrary()
	{
		
	}
	
	/*
	 * take in an array of numbers than return their mean
	 * @param arr = the array of numbers taken in
	 * @param total = the total after all number in the array been added together
	 */
	public double mean(double[] arr)
	{
		double total = 0;
		for(int i = 0;i<arr.length;i++)
		{
			total += arr[i];
		}
		return total/arr.length;
	}
	
	/*
	 * take in an array of number then return the median
	 * @param arr = the array of number taken in
	 * @param med = the median
	 */
	public double median(double[] arr)
	{
		double med = 0;
		//figures out whether the array is even in size or odd then decide the median based on that
		if(arr.length%2==0)
		{
			med = (arr[arr.length/2] + arr[(arr.length/2) - 1])/2;
		}
		else
		{
			med = arr[arr.length/2];
		}
		return med;
	}
	
	/*
	 * takes in an array of numbers then return the mode
	 * return no mode if there are 2 or more numbers with the highest frequency
	 * @param arr = the array filled with numbers taken in
	 * @param index = index of where a number equal to the current mode is in the array
	 * @param count = count how many duplicate of a number in the array
	 * @param max = the current highest amount of duplicates in the array
	 * @param max2 = check if the current max is truly the highest frequency
	 */
	public String mode(double[] arr)
	{
		int index = 0;
		int count = 0;
		int max = 1;
		int max2 = 0;
		
		//goes through each element in the array
		for(int i = 0;i<arr.length;i++)
		{
			//look at the following elements in the array and look for duplicates
			for(int y = 0;y<arr.length;y++)
			{
				//if there a duplicate found then add 1 to count
				if(arr[y] == arr[i])
				{
					count++;
				}
			}
			/*
			 * if count is greater the current greatest max
			 * then index = i and max equal the current count
			 * else if the current count is equal to the current max and 
			 * the current number being counted is not the same as the current mode then
			 * max2 = count
			 */
			if(count>max)
			{
				index = i;
				max = count;
			}
			else if(count == max && arr[i] != arr[index])
			{
				max2 = count;
			}
			count = 0;
		}
		/*
		 * if max and max2 are the same then there no mode
		 * else return the mode
		 */
		if(max == max2)
		{
			return "No mode";
		}
		else
		{
			String temp = String.valueOf(arr[index]);
			return temp;
		}

	}
	
	
	public double standard(double[] arr)
	{
		double mean = 0;
		double calc = 0;
		
		for(int i =0;i<arr.length;i++)
		{
			mean += arr[i];
		}
		
		mean = mean/arr.length;
		
		for(int i =0;i<arr.length;i++)
		{
			calc += (arr[i] - mean)*(arr[i] - mean);
		}
		calc = calc/arr.length;
		return Math.sqrt(calc);
	}
	
	public ArrayList<Integer> intersection(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for(int i = 0;i<arr1.length;i++)
		{
			for(int y = 0;y<arr2.length;y++)
			{
				if(arr1[i]==arr2[y])
				{
					set.add(arr1[i]);
				}
			}
		}
		return set;
	}
	
	public ArrayList<Integer> union(int[] arr1,int[] arr2)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for(int i = 0;i<arr1.length;i++)
		{
			set.add(arr1[i]);
		}
		
		for(int i = 0;i<arr2.length;i++)
		{
			if(!set.contains(arr2[i]))
			{
				set.add(arr2[i]);
			}
		}
		
		return set;
	}
	
	public ArrayList<Integer> complement(int[] arr1,int[] whole)
	{
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		for(int i = 0;i<whole.length;i++)
		{
			boolean contain = true;
			for(int y = 0; y<arr1.length;y++)
			{
				if(whole[i] == arr1[y])
				{
					contain = false;
				}
			}
			if(contain)
			{
				set.add(whole[i]);
			}
		}
		return set;
	}

	
	
	public BigInteger permutation(int n, int r)
	{
		BigInteger factN = new BigInteger("1");
		BigInteger factNR = new BigInteger("1");
		
		for(int i = 1;i<=n;i++)
		{
			factN = factN.multiply(BigInteger.valueOf(i));
		}
		
		for(int i = 1;i<=(n-r);i++)
		{
			factNR = factNR.multiply(BigInteger.valueOf(i));
		}
		
		return factN.divide(factNR);
		
	}
	
	public BigInteger combination(int n, int r)
	{
		BigInteger factN = new BigInteger("1");
		BigInteger factNR = new BigInteger("1");
		BigInteger factR = new BigInteger("1");
		
		for(int i = 1;i<=n;i++)
		{
			factN = factN.multiply(BigInteger.valueOf(i));
		}
		
		for(int i = 1;i<=(n-r);i++)
		{
			factNR = factNR.multiply(BigInteger.valueOf(i));
		}
		
		for(int i = 1;i<=r;i++)
		{
			factR = factR.multiply(BigInteger.valueOf(i));
		}
		
		return factN.divide(factNR.multiply(factR));
		
	}
	
	public BigDecimal binomialExact(int n, int y, double p)
	{
		BigDecimal comp = new BigDecimal(combination(n,y));
		BigDecimal succ = new BigDecimal(p);
		succ = succ.pow(y);
		BigDecimal fail = new BigDecimal(1-p);
		
		fail = fail.pow((n-y));
		comp = comp.multiply(succ);
		comp = comp.multiply(fail);
		
		return comp.setScale(8,RoundingMode.CEILING);
	}
	
	public BigDecimal binomialAtLeast(int n, int y, double p)
	{
		BigDecimal out = new BigDecimal(0);
		
		for(int i = y; i<=n; i++)
		{
			BigDecimal comp = new BigDecimal(combination(n,i));
			BigDecimal succ = new BigDecimal(p);
			succ = succ.pow(i);
			BigDecimal fail = new BigDecimal(1-p);
			fail = fail.pow((n-i));
			comp = comp.multiply(succ);
			comp = comp.multiply(fail);
			out = out.add(comp);
		}
		return out.setScale(8,RoundingMode.CEILING);
		
		
	}
	
	public BigDecimal binomialAtMost(int n, int y, double p)
	{
		BigDecimal out = new BigDecimal(0);
		for(int i = y; i>=0; i--)
		{
			BigDecimal comp = new BigDecimal(combination(n,i));
			BigDecimal succ = new BigDecimal(p);
			succ = succ.pow(i);
			BigDecimal fail = new BigDecimal(1-p);
			fail = fail.pow((n-i));
			comp = comp.multiply(succ);
			comp = comp.multiply(fail);
			out = out.add(comp);
		}
		return out.setScale(8,RoundingMode.CEILING);
	}
	
	public BigDecimal geometric(double p,int y)
	{
		double q = 1-p;
		BigDecimal Geo = new BigDecimal(q);
		Geo = Geo.pow(y-1);
		Geo = Geo.multiply(BigDecimal.valueOf(p));
		return Geo.setScale(8,RoundingMode.CEILING);
		
	}

	
}
