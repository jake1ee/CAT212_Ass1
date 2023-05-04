import java.util.ArrayList;

public class RadixsortV2 {

    // Radix sort algorithm for integer array
    public static void radixSort(int[] arr) {
        
        // Print a message indicating that the algorithm is being executed
        System.out.println("\n\n--------------Radix Sort Algorithm for Integer--------------\n");

        // Create two arrays of array lists to hold the values in each digit place
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array2 = new ArrayList[10];

        // Initialize each array list in the arrays
        for(int i = 0; i < 10; i++) {
            array[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(arr));

        // Sort the array using the radix sort algorithm
        Sorting(array, array2, arr, 1, 0, num.length());
    }

    // Radix sort algorithm for float array
    public static void radixSort(float[] arr) {

        // Print a message indicating that the algorithm is being executed
        System.out.println("\n\n--------------Radix Sort Algorithm for Floating Point Numbers--------------\n");

        // Create two arrays of array lists to hold the values in each digit place
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array2 = new ArrayList[10];

        // Get the number of digits to sort by
        int digit = getMaxDigit(arr);

        // Calculate the radix based on the number of digits
        int radix = (int)Math.pow(10, digit);

        // Convert the float array to an integer array by multiplying each value by the radix
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = (int)(arr[i] * radix);
        }

        // Initialize each array list in the arrays
        for(int i = 0; i < 10; i++) {
            array[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(intArr));

        // Sort the array using the radix sort algorithm
        Sorting(array, array2, intArr, 1, 0, num.length());

        // Convert the sorted integer array back to a float array by dividing each value by the radix
        for(int i = 0; i < intArr.length; i++) {
            arr[i] = intArr[i]/(float)radix;
        }
    }

    // Get the maximum value in an integer array
    private static int getMax(int[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > mx)
                mx = arr[i];
        }
        return mx;
    }

     // method to get the maximum number of decimal places in a float array
    private static int getMaxDigit(float[] arr) {
        String value;
        int integerPlace, decimal, max = 1;
        for(int i = 0; i <arr.length; i++) {
            value = Float.toString(Math.abs(arr[i]));
            integerPlace = value.indexOf(".");
            decimal = value.length() - integerPlace - 1;
            if(decimal>max)
                max = decimal;
        }
        return max;
    }

   private static void Sorting(ArrayList<Integer>[] arr1, ArrayList<Integer>[] arr2, int[] array, int exp, int row, int max)
{
    System.out.println(row); // Print the current row number (for debugging purposes)

    // Base case: if the current row number is equal to the maximum number of rows, sorting is complete
    if (row == max)
    {
        int index = 0;
        // Copy the sorted elements from the second array list to the original array
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                if (index < array.length)
                    array[index++] = arr2[i].get(j);
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
            }
        }
        return;
    }

    // If the current row number is 0, sort the original array
    else if (row == 0)
    {
        // Add each element of the original array to the first array list based on the digit at the given radix position
        for (int i = 0; i < array.length; i++)
        {
            int index = (array[i] / exp) % 10;
            arr1[index].add(array[i]);
        }
        // Call the Sorting() function recursively with the second array list as the first parameter
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }

    // For all other row numbers, sort the second array list
    else if (row >= 0 && row < max)
    {
        // Add each element of the second array list to the first array list based on the digit at the given radix position
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                int index = (arr2[i].get(j) / exp) % 10;
                arr1[index].add(arr2[i].get(j));
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
            }
        }
        // Call the Sorting() function recursively with the first array list as the first parameter
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }
}

    public static void main(String [] args)
    {
        // create an array of integers
        int [] input = {275, 87, 426, 61, 409, 170, 677, 503};

        // create an array of floating point numbers
        float [] input2 = {10.382f, 8.743f, 47.1654f, 28.9f, 53.2505f, 28.89f, 44.504f, 81.72f, 8.1198f, 10.897f};

        // call radixSort() function for the integer array
        radixSort(input);

        // call radixSort() function for the floating point number array
        radixSort(input2);

        // print the sorted integer array
        System.out.println("\nInteger Array");
        for(int i = 0; i <input.length; i++)
        {
            System.out.print(input[i]+", ");
        }

        // print the sorted floating point number array
        System.out.println("\nFloating point array");
        for(int i = 0; i <input2.length; i++)
        {
            System.out.print(input2[i]+", ");
        }
    }
}
