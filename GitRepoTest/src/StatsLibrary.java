import java.math.BigInteger;
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
	
}
