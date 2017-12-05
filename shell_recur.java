package Stacks;

public class shell_recur {
	
	int [] arrayOne =  {1,5,2,6,5,5,3,9,11,17,4};
		
		public void recursiveShell(int[] arrayOne, int k, int inc, int temp, int j)
	    {
	        if(inc >= arrayOne.length)
	        {
	            return;
	        }
	        if(inc < arrayOne.length)
	        {
	            for(int i = inc; i < arrayOne.length; i++)
	            {
	                temp = arrayOne[i];
	                j = i;
	                while( j >= inc && arrayOne[j-inc] > temp)
	                {
	                    arrayOne[j] = arrayOne[j-inc];
	                    j = j - inc;
	                }
	                arrayOne[j] = temp;
	            }
	            
	            k = (2 * k) + 1;
	            inc = k;
	            recursiveShell(arrayOne, k, inc, temp, j);
	        }
	    }
