package Stacks;

public class selectiveRecursive {
    // Return minimum index
    static int minIndex(int a[], int i, int j)
    {
        if (i == j)
            return i;       
        int k = minIndex(a, i + 1, j);// Find minimum of remaining elements
        return (a[i] < a[k])? i : k; // Return minimum of current and remaining.
    }
      
    // Recursive selection sort. n is size of a[] and index is index of starting element.
    static void recurSelectionSort(int a[], int n, int index)
    {
          
        // Return when starting and size are same
        if (index == n)
           return;
      
        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);
      
        // Swapping when index nd minimum index are not same
        if (k != index){
           // swap
           int temp = a[k];
           a[k] = a[index];
           a[index] = temp;
        }
        // Recursively calling selection sort function
        recurSelectionSort(a, n, index + 1);
    }
}
