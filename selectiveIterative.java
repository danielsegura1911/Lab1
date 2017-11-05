package Stacks;
/*
Java program for implementation of Insertion Sort
*/
import java.util.Random;
public class selectiveIterative {
    
    static int countMove = 0;
    static int countCompare = 0;
	
	 void sort(int arr[])
	    {
	        int n = arr.length;
	 
	        // One by one move boundary of unsorted subarray
	        for (int i = 0; i < n-1; i++)
	        {
	            // Find the minimum element in unsorted array
	            int small = i;
	            for (int current = i+1; current < n; current++)
	                if (arr[current] < arr[small]){
	                    small = current;
	                    ++countMove;
	                    ++countCompare;
	                }
	 
	            // Swap the found minimum element with the first element
	            int temp = arr[small];
	            arr[small] = arr[i];
	            arr[i] = temp;
	            ++countCompare;
	        }
	    
	    }

	//prints array method
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " " );
            System.out.print("compares=" + countCompare+ " moves=" + countMove);
		System.out.println();
	}

	// test method
	public static void main(String args[])
	{	 
		int arr[] = new int[1000];
		
		for(int i=0;i<arr.length;i++)
    {
        arr[i] = randomFill();
    }

		selectiveIterative object = new selectiveIterative();	 
		object.sort(arr);
		
		printArray(arr);
	}
	//random number genertor method
	public static int randomFill(){

    Random rand = new Random();
    int randomNum = rand.nextInt(9999) + 1;
    return randomNum;
    }

}