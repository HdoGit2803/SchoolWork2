import java.util.ArrayList;

public class SetOperation
{
	public SetOperation()
	{
		
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


}
