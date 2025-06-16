import java.util.Scanner;

public class QuickSort {
    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes the last element as the pivot,
    // places the pivot element at its correct position in the sorted array,
    // and places all smaller elements to the left of pivot and all greater elements
    // to the right
    static int partition(int[] arr, int low, int high) {
        // Choosing the pivot (last element)
        int pivot = arr[high];

        // Index of the smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        // Lopp through the array and compare each element with the pivot
        for (int j = low; j <= high - 1; j++) {

            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Swap the elements
            }
        }
        // Place the pivot at the correct position
        swap(arr, i + 1, high);
        return (i + 1); // Return the pivot index
    }

    // Main function that implememnts QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    static void quickSort(int[] arr, int low, int high){
        if(low < high){

            // pi is the partitioning index, arr[pi] is now at its correct position
            int pi = partition(arr, low, high);

            //Recursively sort elements before and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi + 1, high);
        }
    }

    //Function to print the sorted array
    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //Prompt user to input the number of elements
        System.out.print("Enter the number of elements: ");
        int N = scn.nextInt();

        //Create an array of size N
        int[] arr = new int[N];

        //Ask the user to input the elements of the array
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < N;i++){
            arr[i] = scn.nextInt();
        }

        //Function to call to perform quicksort
        quickSort(arr, 0, N -1);

        //Print the sorted array
        System.out.println("Sorted array: ");
        printArr(arr);
    }
}