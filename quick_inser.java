package Stacks;
/*
Java program for implementation of Quick Sort
**/
import java.util.Random;
public class quick_inser{
    static int countMove =0;
    static int countCompare= 0;
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++countCompare;
                ++countMove;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        ++countMove;
        ++countCompare;
 
        return i+1;
    }
 
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            ++countCompare;
 
            // Recursively sort elements of teh partitions
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    
	// prints array method
	static void printArray(int arr[])
	{
		for (int i=0; i<arr.length; ++i)
			System.out.print(arr[i] + " " );
            System.out.print("compares=" + countCompare+ " moves=" + countMove);
		System.out.println();
	}

	// test method
	public static void main(String args[])
	{	 
		int arr[] = new int[1000];
		int n = arr.length;
		for(int i=0;i<n;i++){
        arr[i] = randomFill();
    }
		quick_inser object = new quick_inser();
		object.sort(arr, 0, n-1);
		
		printArray(arr);
	}
	
	//random number generator method
	public static int randomFill(){

    Random rand = new Random();
    int randomNum = rand.nextInt(1000) + 1;
    return randomNum;
    }

}
