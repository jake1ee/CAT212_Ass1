import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RadixsortV2 {

    static int sortctr = 0;
    static int counter = 0;

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
        sortctr+=2;
        sortctr += 2;
        for(int i = 0; i < 10; i++) {
                sortctr += 2; //for loop : 1 comparison, 1 addition
            array[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
                sortctr +=2; //2 assignment;
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(arr));
            sortctr +=3; //1 assignment, 1 calling, 1 toString

        // Sort the array using the radix sort algorithm
            sortctr+=2; //1 calling, 1 .length
        Sorting(array, array2, arr, 1, 0, num.length());
    }

    // Radix sort algorithm for float array
    public static void radixSort(float[] arr) {

        // Print a message indicating that the algorithm is being executed
        System.out.println("\n\n--------------Radix Sort Algorithm for Floating Point Numbers--------------\n");

        // Create two arrays of array lists to hold the values in each digit place
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];
        sortctr++;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array2 = new ArrayList[10];
        sortctr++;

        // Get the number of digits to sort by
        int digit = getMaxDigit(arr);
        sortctr +=2; //1 assignment, 1 calling

        // Calculate the radix based on the number of digits
        int radix = (int)Math.pow(10, digit);
        sortctr +=3; //1 assignment, 1 pow(), 1 convertion

        // Convert the float array to an integer array by multiplying each value by the radix
        int[] intArr = new int[arr.length];
        sortctr+=2;
        sortctr +=3; //1 assignment, 1 .length, 1 compare
        for (int i = 0; i < arr.length; i++) 
        {
            sortctr +=3; //1 comparison, 1 .length, 1 addition
            intArr[i] = (int)(arr[i] * radix);
            sortctr +=2; //1 assignment, 1 converstion
        }


        sortctr +=2; //1 assignment, 1 compare
        // Initialize each array list in the arrays
        for(int i = 0; i < 10; i++) {
            sortctr +=2; //1 comparison, 1 addition
            array[i] = new ArrayList<Integer>();
            array2[i] = new ArrayList<Integer>();
            sortctr +=2; //assignment
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(intArr));
        sortctr +=3; //1 assignment, 1 toString, 1 calling

        // Sort the array using the radix sort algorithm
        Sorting(array, array2, intArr, 1, 0, num.length());
        sortctr +=2; //1 calling, 1 assignment

        sortctr +=3; //1 assignment, 1 .length, 1 comparison
        // Convert the sorted integer array back to a float array by dividing each value by the radix
        for(int i = 0; i < intArr.length; i++) 
        {
            sortctr +=3; //1 comparison, 1 .length, 1 addition
            arr[i] = intArr[i]/(float)radix;
            sortctr +=3; //1 assignment, 1 division, conversion
        }
    }

    // Get the maximum value in an integer array
    private static int getMax(int[] arr) {
        int mx = arr[0];
            sortctr ++ ; //1 assignment

            sortctr +=3; //1 assignment, 1 .length, 1 comparison
        for (int i = 1; i < arr.length; i++) {
            sortctr += 3; //1 comparison, 1 addition, 1 .length
            sortctr ++; //1 comparison
            if(arr[i] > mx)
                mx = arr[i];
                sortctr ++ ; //1 assignment
        }
        sortctr ++ ; //1 return
        return mx;
    }

     // method to get the maximum number of decimal places in a float array
    private static int getMaxDigit(float[] arr) {
        String value;
        int integerPlace, decimal, max = 1;
        sortctr ++; //1 assignment

        sortctr +=3; //1 assignment, 1 .length, 1 comparison
        for(int i = 0; i <arr.length; i++) 
        {
            sortctr += 3; //1 comparison, 1 addition, 1 .length
            value = Float.toString(Math.abs(arr[i]));
            sortctr +=3; //1 assignment, 1 toString, 1 abs
            integerPlace = value.indexOf(".");
            sortctr +=2; //1 assignment, 1 .indexOf
            decimal = value.length() - integerPlace - 1;
            sortctr +=3; //1 assignment, 1 .length, minus
            sortctr ++; //1 comparison, 1 max
            if(decimal>max)
            {
                max = decimal;
                sortctr ++; //1 assignment
            }

        }
        sortctr ++; //1 return
        return max;
    }

   private static void Sorting(ArrayList<Integer>[] arr1, ArrayList<Integer>[] arr2, int[] array, int exp, int row, int max)
{
    // Base case: if the current row number is equal to the maximum number of rows, sorting is complete
    sortctr ++; //1 comparison
    if (row == max)
    {
        int index = 0;
        sortctr++; //1 assignment
        // Copy the sorted elements from the second array list to the original array
        sortctr+=2; //1 ass, 1 comparison
        for (int i = 0; i < 10; i++)
        {
            sortctr +=2; //1 comparison, 1 addition
            sortctr += 4;// 2 assignment, 1 size(), 1 compare
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                sortctr +=3; //1 comparison, 1 addition, 1 .size
                sortctr +=2; //1 comparison, 1 .length
                if (index < array.length)
                    array[index++] = arr2[i].get(j);
                    sortctr +=2 ; //1 assignment, 1 .get
                sortctr ++ ; //1 comparison, 1 size
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
                    sortctr ++ ; //1 .clear
            }
        }
        sortctr ++; //1 return
        return;
    }

    // If the current row number is 0, sort the original array
    sortctr ++; //1 comparison
     if (row == 0)
    {
        // Add each element of the original array to the first array list based on the digit at the given radix position
        sortctr+=3; //1 ass, 1 compare, 1 .length
        for (int i = 0; i < array.length; i++)
        {
                sortctr +=3; //1 comparison, 1 addition, 1 .length
            int index = (array[i] / exp) % 10;
                sortctr += 3; // 1 assignment, 1 division, 1 modulus
            arr1[index].add(array[i]);
                sortctr ++; //1 addition call
        }
        // Call the Sorting() function recursively with the second array list as the first parameter
        sortctr +=3; //1 call, 1 mutiplication, 1 addition
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }

    // For all other row numbers, sort the second array list
    sortctr +=3; //2 comparison, 1 and 
     if (row >= 0 && row < max)
    {
        // Add each element of the second array list to the first array list based on the digit at the given radix position
        sortctr+=2; //1 assignment, 1 comparison
        for (int i = 0; i < 10; i++)
        {
            sortctr +=2; //1 comparison, 1 addition
            sortctr +=4; //2 assignment, 1 comparison, 1 size()
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                sortctr +=2; //1 comparison, 1 addition
                int index = (arr2[i].get(j) / exp) % 10;
                sortctr +=4; //1 assignment, 1 .get, 1 division, 1 exp
                arr1[index].add(arr2[i].get(j));
                sortctr +=2; //1 addition, 1 get
                sortctr +=2; //1 addition, 1 compare
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
                    sortctr ++; //1 clear
            }
        }
        // Call the Sorting() function recursively with the first array list as the first parameter
        sortctr +=3; //1 call, 1 mutiplication, 1 addition
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }
}

    public static boolean Arr_Acs(int[] arr)
    {
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i-1]>arr[i])
            return false;
        }
        return true;
    }

    public static boolean Arr_Acs(float [] arr)
    {
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i-1]>arr[i])
            return false;
        }
        return true;
    }

    public static void main(String [] args)
    {
        Scanner myObj = new Scanner(System.in);
        Random rdm = new Random();
        counter+=4;

        System.out.println("Please enter number of input for Intager array: ");
        int size = myObj.nextInt(); 
        counter +=2;
        // create an array of integers
        int [] input = new int[size];
        counter +=2;
        counter +=2; //1 assignment, 1 compare
        for(int i = 0; i < size; i++)
        {
            counter +=2; //1 addition, 1 compare
            input[i] =rdm.nextInt(1000);
            counter +=2; // 1 assignment, 1 function call
        }
        // call radixSort() function for the integer array
        counter ++ ; //1 calling
        radixSort(input);

        // print the sorted integer array
        System.out.println("Integer Array");
        for(int i = 0; i <input.length; i++)
        {
            System.out.print(input[i]+", ");
        }
        
        System.out.println("\n\nSteps for integer array : " + (sortctr+counter));
        counter = 4; sortctr = 0;
        System.out.println("Array Sorted Correctly: " + Arr_Acs(input));

        System.out.println("\nPlease enter number of input for Floating point array: ");
        int size2 = myObj.nextInt();
        counter +=2; // 1 assignment, 1 function call
        // create an array of floating point numbers
        float [] input2 = new float[size2];
        counter ++;
        counter +=2;
        for(int i = 0; i < size; i++)
        {
            input2[i] =rdm.nextFloat(100);
            counter +=2;
        }  

        // call radixSort() function for the floating point number array
        counter++;
        radixSort(input2);

        // print the sorted floating point number array
        System.out.println("\nFloating point array:");
        for(int i = 0; i <input2.length; i++)
        {
            System.out.print(input2[i]+", ");
        }

        System.out.println("\n\nSteps for floating point array : "  +(sortctr+counter));
        System.out.println("Array Sorted Correctly: " + Arr_Acs(input2));
        myObj.close();
    }
    
}