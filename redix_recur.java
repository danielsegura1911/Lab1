package Stacks;

public class redix_recur {
	public static void main(String[] args)
    {
        int [] arrayTwo = {10,55,732,555,82,302,4};
        int exp = 1;
        int n = arrayTwo.length;
        int m = arrayTwo[0];
           
        for (int i = 1; i < n; i++)
            if (arrayTwo[i] > m)
                m = arrayTwo[i];
    }
        public void recursiveRS(int[] arrayTwo, int[] arrayOne,int exp, int m, int n)
    	{
            while(exp > 0)
    		{
    			if (m / exp < 0)
    				return;
    			else
    			{
                
                    for (int i = 0; i < n; i++)
                        arrayTwo[(arrayTwo[i] / exp) % 10]++;
                    for (int j = 1; j < 10; j++)
                        arrayTwo[j] += arrayTwo[j - 1];
                    for (int k = n - 1; k >= 0; k--)
                        arrayOne[--arrayTwo[(arrayTwo[k] / exp) % 10]] = arrayTwo[k];
                    for (int a = 0; a < n; a++)
                        arrayTwo[a] = arrayOne[a];
                    exp *= 10; 
                    recursiveRS(arrayTwo, arrayOne,exp, m, n);
    			}
    		}
        }
        
}
