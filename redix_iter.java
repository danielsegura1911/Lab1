package Stacks;
/*
 * Java program for implementation of Radix Sort
 * 
 */

import java.io;
import java.util;
import java.util.Random;
    public class redix_iter{
        
    static int countMove = 0;//keeps track of amount of time data is moved
    static int countCompare = 0;// tracks  amount of times data is compared
    
	// A utility function to get maximum value in array
	static int getMax(int arr[], int n)
	{
		int mx = arr[0];
		for (int i = 1; i < n; i++){
		    ++countCompare;
			if (arr[i] > mx){
				mx = arr[i];
		}
	}
		return mx;
	}

	// counts sort of array according to exp
	static void countSort(int arr[], int n, int exp)
	{
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count,0);

		// Stores count of occurrences in count
		for (i = 0; i < n; i++){
			count[ (arr[i]/exp)%10 ]++;
			++countMove;
			++countCompare;
	}

		// Changes count[i] so that count now contains the position of the output
		for (i = 1; i < 10; i++){
			count[i] += count[i - 1];
			++countCompare;
			++countMove;
		}

		// Builds the output array
		for (i = n - 1; i >= 0; i--)
		{
			output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
			count[ (arr[i]/exp)%10 ]--;
			++countMove;
			++countCompare;
		}

		// Copy the output array so that the array now contains sorted numbers
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}


	static void redix_iter(int arr[], int n) //main radix function
	{
		// Finds the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that instead
		// of passing digit number, exp is passed. exp is 10^i
		// where i is current digit number
		for (int exp = 1; m/exp > 0; exp *= 10){
			countSort(arr, n, exp);
			++countCompare;
		}
	}

	// A utility function to print an array
	static void print(int arr[], int n)
	{
		for (int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
			 System.out.print("compares=" + countCompare+ " moves=" + countMove);
	}


	/*test function*/
	public static void main (String[] args)
	{
	    int arr[] = new int[1000];
	    for(int i=0;i<arr.length;i++)
	    arr[i] = randomFill();
	    
		int n = arr.length;
		
		   redix_iter(arr, n);
		print(arr, n);
	}
	//random number generater
	public static int randomFill(){

    Random rand = new Random();
    int randomNum = rand.nextInt(999) + 1;
    return randomNum;
    }
}