package Stacks;
/*
Java program for implementation of Insertion Sort
*/
import java.util.Random;
public class shell_iter {
    static int countMove = 0;
    static int countCompare = 0;
    int sort(int arr[])
    {
        int n = arr.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                ++countCompare;
                int temp = arr[i];
 
                // shifts earlier "gap-sorted" elements up until the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                    ++countCompare;
                    ++countMove;
                }
                // put temp (the original a[i]) in its correct location
                arr[j] = temp;
            }
        }
        return 0;
    }
	//prints the array 
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

		shell_iter object = new shell_iter();	 
		object.sort(arr);
		
		printArray(arr);
	}
	//random number generator function
	public static int randomFill(){

    Random rand = new Random();
    int randomNum = rand.nextInt(9999) + 1;
    return randomNum;
    }

}