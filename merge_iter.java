package Stacks;
/*
 * Java program for implementation of Merge Sort
 */

import java.util.Random;
public class merge_iter{
	
static int countMove = 0;
static int countCompare = 0;

void merge(int arr[], int l, int m, int r)
{
 
   int n1 = m - l + 1;
   int n2 = r - m;

   // Create temp arrays 
   int L[] = new int [n1];
   int R[] = new int [n2];

   //Copy data to temp arrays
   for (int i=0; i<n1; ++i){
      ++countCompare;
      ++countMove;
       L[i] = arr[l + i];
   }
   for (int j=0; j<n2; ++j){
      ++countCompare;
      ++countMove;
       R[j] = arr[m + 1+ j];
  }


   // Initial indexes of first and second subarrays
   int i = 0, j = 0;

   // Initial index of merged subarry array
   int k = l;
   while (i < n1 && j < n2)
   {
       if (L[i] <= R[j])
       {
           ++countCompare;
           arr[k] = L[i];
           i++;
       }
       else
       {
           ++countCompare;
           arr[k] = R[j];
           j++;
       }
       k++;
   }

   // Copy remaining elements of L if any 
   while (i < n1)
   {
       ++countCompare;
       arr[k] = L[i];
       i++;
       k++;
       ++countMove;
   }

   // Copy remaining elements of R[] if any 
   while (j < n2)
   {
       ++countCompare;
       arr[k] = R[j];
       j++;
       k++;
       ++countMove;
   }
}

// Main function that sorts arr[l..r] using merge()
void sort(int arr[], int l, int r)
{
   if (l < r)
   {
       ++countCompare;
       // Finds the middle point
       int m = (l+r)/2;

       // Sorts first and second halves
       sort(arr, l, m);
       sort(arr , m+1, r);
          ++countMove;
       // Merges the sorted halves
       merge(arr, l, m, r);
   }
}

// prints the array
static void printArray(int arr[])
{
   int n = arr.length;
   for (int i=0; i<n; ++i)
       System.out.print(arr[i] + " ");
       System.out.print("compares=" + countCompare+ " moves=" + countMove);
   System.out.println();
}

// Driver method
public static void main(String args[])
{
   int arr[] = new int[1000];
   for(int i=0;i<arr.length;i++){
   arr[i] = randomFill();
   }
   merge_iter object = new merge_iter();
   object.sort(arr, 0, arr.length-1);;
   printArray(arr);
}

	//random number generator
	public static int randomFill(){

Random rand = new Random();
int randomNum = rand.nextInt(1000) + 1;
return randomNum;
}

}