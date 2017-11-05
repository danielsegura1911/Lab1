package Stacks;

//Java program for implementation of Insertion Sort
import java.util.Random;

public class InsertionSort{
 static int countMove = 0;
 static int countCompare = 0;
	//Function to sort array using insertion sort
	void sort(int arr[])
	{
	   
		int n = arr.length;
		for (int i=1; i<n; ++i)
		{
			int key = arr[i];
			int j = i-1;
			++countCompare;
			while (j>=0 && arr[j] > key)
			{
				arr[j+1] = arr[j];
				j = j-1;
				++countMove;
				++countCompare;
			}
			arr[j+1] = key;
		}
	}

	//prints array
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " " );
         System.out.print("compares=" + countCompare+ "moves=" + countMove);
		System.out.println();
	}

	// test method
	public static void main(String args[])
	{	 
		int arr[] = new int[10];
		
		for(int i=0;i<arr.length;i++)
 {
     arr[i] = randomFill();
 }

		InsertionSort object = new InsertionSort();	 
		object.sort(arr);
		
		printArray(arr);
	}
	
	//random number generator
	public static int randomFill(){

 Random rand = (new Random()).nextInt();
 int randomNum = rand.nextInt(999) + 1;
 return randomNum;
 }
	
}