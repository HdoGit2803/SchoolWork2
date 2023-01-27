import java.lang.reflect.Array;

public class FunClass 
{

	public static void main(String[] args) 
	{
		System.out.println("Hello World");
		String x = "";
		int[] arr = {1,2,3,4,5};
		
		for(int i = arr.length-1;i>=0;i--)
		{
			x += arr[i];
		}
		
		System.out.println(x);

	}

}
