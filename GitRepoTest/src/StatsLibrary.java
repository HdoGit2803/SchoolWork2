import java.math.*;
import java.util.ArrayList;
public class StatsLibrary
{
	public StatsLibrary()
	{
		
	}
	public double mean(double[] find)
	{
		double total = 0;
		for(int i = 0;i<find.length;i++)
		{
			total += find[i];
		}
		return total/find.length;
	}
	
	public double median(double[] find)
	{
		double med = 0;
		if(find.length%2==0)
		{
			med = (find[find.length/2] + find[(find.length/2) - 1])/2;
		}
		else
		{
			med = find[find.length/2];
		}
		return med;
	}
	
	public String mode(double[] find)
	{
		int index = 0;
		int count = 0;
		int max = 1;
		int max2 = 0;
		for(int i = 0;i<find.length;i++)
		{
			for(int y = 0;y<find.length;y++)
			{
				if(find[y] == find[i])
				{
					count++;
				}
			}
			if(count>max)
			{
				index = i;
				max = count;
			}
			else if(count == max && find[i] != find[index])
			{
				max2 = count;
			}
			count = 0;
		}
		if(max == max2)
		{
			return "No mode";
		}
		else
		{
			String temp = String.valueOf(find[index]);
			return temp;
		}

	}
	
	public double standard(double[] find)
	{
		double mean = 0;
		double calc = 0;
		
		for(int i =0;i<find.length;i++)
		{
			mean += find[i];
		}
		
		mean = mean/find.length;
		
		for(int i =0;i<find.length;i++)
		{
			calc += (find[i] - mean)*(find[i] - mean);
		}
		calc = calc/find.length;
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
