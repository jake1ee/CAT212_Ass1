import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RadixsortV2 {

    static int counter = 0;
    static int floatctr = 0;
    // Radix sort algorithm for integer array
    public static void radixSort(int[] arr) {
        
        // Print a message indicating that the algorithm is being executed
        System.out.println("\n\n--------------Radix Sort Algorithm for Integer--------------\n");

        // Create two arrays of array lists to hold the values in each digit place
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];
        counter++;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array2 = new ArrayList[10];
        counter++;

        // Initialize each array list in the arrays
        for(int i = 0; i < 10; i++) {
                counter += 3; //for loop : 1 comparison, 1 assignment, 1 addition
            array[i] = new ArrayList<Integer>();
                counter ++; //1 assignment;
            array2[i] = new ArrayList<Integer>();
                counter ++; //1 assignment;
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(arr));
            counter +=3; //1 assignment, 1 calling, 1 toString

        // Sort the array using the radix sort algorithm
            counter+=2; //1 calling, 1 .length
        Sorting(array, array2, arr, 1, 0, num.length());
    }

    // Radix sort algorithm for float array
    public static void radixSort(float[] arr) {

        // Print a message indicating that the algorithm is being executed
        System.out.println("\n\n--------------Radix Sort Algorithm for Floating Point Numbers--------------\n");

        // Create two arrays of array lists to hold the values in each digit place
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];
        floatctr++;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array2 = new ArrayList[10];
        floatctr++;

        // Get the number of digits to sort by
        int digit = getMaxDigit(arr);
        floatctr +=2; //1 assignment, 1 calling

        // Calculate the radix based on the number of digits
        int radix = (int)Math.pow(10, digit);
        floatctr +=2; //1 assignment, 1 pow()

        // Convert the float array to an integer array by multiplying each value by the radix
        int[] intArr = new int[arr.length];
        floatctr+=2;
        floatctr +=2; //1 assignment, 1 .length
        for (int i = 0; i < arr.length; i++) 
        {
            floatctr +=4; //1 comparison, 1 .length, 1 addition, 1 assignment
            intArr[i] = (int)(arr[i] * radix);
            floatctr ++; //1 assignment
        }

        // Initialize each array list in the arrays
        for(int i = 0; i < 10; i++) {
            floatctr +=3; //1 comparison, 1 assignment, 1 addition
            array[i] = new ArrayList<Integer>();
            floatctr ++; //1 assignment
            array2[i] = new ArrayList<Integer>();
            floatctr ++; //1 assignment
        }

        // Get the maximum value in the array and convert it to a string to find its length
        String num = Integer.toString(getMax(intArr));
        floatctr +=3; //1 assignment, 1 toString, 1 calling

        // Sort the array using the radix sort algorithm
        Sorting(array, array2, intArr, 1, 0, num.length());
        floatctr +=2; //1 calling, 1 assignment

        // Convert the sorted integer array back to a float array by dividing each value by the radix
        for(int i = 0; i < intArr.length; i++) 
        {
            floatctr +=4; //1 comparison, 1 .length, 1 assignment, 1 addition
            arr[i] = intArr[i]/(float)radix;
            floatctr +=2; //1 assignment, 1 division
        }
    }

    // Get the maximum value in an integer array
    private static int getMax(int[] arr) {
        int mx = arr[0];
            counter ++ ; //1 assignment
        for (int i = 1; i < arr.length; i++) {
            counter += 4; //1 comparison, 1 assignment, 1 addition, 1 .length
            counter ++; //1 comparison
            if(arr[i] > mx)
                mx = arr[i];
                counter ++ ; //1 assignment
        }
        counter ++ ; //1 return
        return mx;
    }

     // method to get the maximum number of decimal places in a float array
    private static int getMaxDigit(float[] arr) {
        String value;
        int integerPlace, decimal, max = 1;
        floatctr ++; //1 assignment
        for(int i = 0; i <arr.length; i++) 
        {
            counter += 4; //1 comparison, 1 assignment, 1 addition, 1 .length
            value = Float.toString(Math.abs(arr[i]));
            floatctr +=3; //1 assignment, 1 toString, 1 abs
            integerPlace = value.indexOf(".");
            floatctr +=2; //1 assignment, 1 .indexOf
            decimal = value.length() - integerPlace - 1;
            floatctr +=2; //1 assignment, 1 .length
            floatctr +=2; //1 comparison, 1 max
            if(decimal>max)
            {
                max = decimal;
                floatctr ++; //1 assignment
            }

        }
        floatctr ++; //1 return
        return max;
    }

   private static void Sorting(ArrayList<Integer>[] arr1, ArrayList<Integer>[] arr2, int[] array, int exp, int row, int max)
{
    System.out.println(row); // Print the current row number (for debugging purposes)

    // Base case: if the current row number is equal to the maximum number of rows, sorting is complete
    counter ++; //1 comparison
    floatctr ++; //1 comparison
    if (row == max)
    {
        int index = 0;
        counter++; //1 assignment
        floatctr ++; //1 assignment
        // Copy the sorted elements from the second array list to the original array
        for (int i = 0; i < 10; i++)
        {
            counter +=3; //1 comparison, 1 assignment, 1 addition
            floatctr +=3; //1 comparison, 1 assignment, 1 addition
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                counter +=4; //1 comparison, 1 assignment, 1 addition, 1 .size
                floatctr +=4; //1 comparison, 1 assignment, 1 addition, 1 .size
                counter +=2; //1 comparison, 1 .length
                floatctr +=2; //1 comparison, 1 .length
                if (index < array.length)
                    array[index++] = arr2[i].get(j);
                    counter +=2 ; //1 assignment, 1 .get
                    floatctr +=2 ; //1 assignment, 1 .get
                counter ++ ; //1 comparison, 1 size
                floatctr ++ ; //1 comparison, 1 size
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
                    counter ++ ; //1 .clear
                    floatctr ++ ; //1 .clear
            }
        }
        counter ++; //1 return
        floatctr ++; //1 return 
        return;
    }

    // If the current row number is 0, sort the original array
    counter ++; //1 comparison
    floatctr ++; //1 comparison
     if (row == 0)
    {
        // Add each element of the original array to the first array list based on the digit at the given radix position
        for (int i = 0; i < array.length; i++)
        {
                counter +=4; //1 comparison, 1 assignment, 1 addition, 1 .length
                floatctr +=4; //1 comparison, 1 assignment, 1 addition, 1 .length
            int index = (array[i] / exp) % 10;
                counter += 4; // 1 assignment, 1 division, 1 exp(), 1 modulus
                floatctr += 4; // 1 assignment, 1 division, 1 exp(), 1 modulus
            arr1[index].add(array[i]);
                counter ++; //1 addition call
                floatctr ++; //1 addition call
        }
        // Call the Sorting() function recursively with the second array list as the first parameter
        counter +=7; //1 calling, 1 exp, 1 mul, 2 assignment, 1 addition, 1 max
        floatctr +=7; //1 calling, 1 exp, 1 mul, 2 assignment, 1 addition, 1 max
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }

    // For all other row numbers, sort the second array list
    counter +=2; //1 comparison, 1 max
    floatctr +=2; //1 comparison, 1 max
     if (row >= 0 && row < max)
    {
        // Add each element of the second array list to the first array list based on the digit at the given radix position
        for (int i = 0; i < 10; i++)
        {
            counter +=3; //1 comparison, 1 assignment, 1 addition
            floatctr +=3; //1 comparison, 1 assignment, 1 addition
            for (int j = 0, size = arr2[i].size(); j < size; j++)
            {
                counter +=4; //1 comparison, 1 assignment, 1 addition, 1 .size
                floatctr +=4; //1 comparison, 1 assignment, 1 addition, 1 .size
                int index = (arr2[i].get(j) / exp) % 10;
                counter +=5; //1 assignment, 1 .get, 1 division, 1 exp, 1 modulus
                floatctr +=5; //1 assignment, 1 .get, 1 division, 1 exp, 1 modulus
                arr1[index].add(arr2[i].get(j));
                counter +=2; //1 addition, 1 get
                floatctr +=2; //1 addition, 1 get
                counter +=2; //1 addition, 1 assignment
                floatctr +=2; //1 addition, 1 assignment
                if (j + 1 == size)
                    arr2[i].clear(); // Clear the second array list after copying all its elements
                    counter ++; //1 clear
                    floatctr ++; //1 clear
            }
        }
        // Call the Sorting() function recursively with the first array list as the first parameter
            counter += 7; //1 calling, 1 exp, 1 mul, 2 assignment, 1 addition, 1 max
            floatctr += 7; //1 calling, 1 exp, 1 mul, 2 assignment, 1 addition, 1 max
        Sorting(arr2, arr1, array, exp *= 10, row += 1, max);
    }
}

    public boolean Arr_Acs(int[] arr)
    {
        for(int i = 1; i<=arr.length; i++)
        {
            if(arr[i-1]>arr[i])
            return false;
        }
        return true;
    }

    public boolean Arr_Acs(Float [] arr)
    {
        for(int i = 1; i<=arr.length; i++)
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

        System.out.println("Please enter number of input for Intager array: ");
        int size = myObj.nextInt(); 
        // create an array of integers
        int [] input = new int[size];
        for(int i = 0; i < size; i++)
        {
            input[i] =rdm.nextInt(100);
        }
        counter ++; //1 assignment

        System.out.println("Please enter number of input for Floating point array: ");
        int size2 = myObj.nextInt();
        // create an array of floating point numbers
        float [] input2 = new float[size2];
        for(int i = 0; i < size; i++)
        {
            input2[i] =rdm.nextFloat(100);
        }
        floatctr ++; //1 assignment

        // call radixSort() function for the integer array
        counter ++ ; //1 calling
        radixSort(input);

        // call radixSort() function for the floating point number array
        floatctr ++; //1 calling
        radixSort(input2);

        // print the sorted integer array
        System.out.println("\nInteger Array");
        for(int i = 0; i <input.length; i++)
        {
            counter+=4; //1 comparison, 1 assignment, 1 addition, 1 .length
            System.out.print(input[i]+", ");
        }
        
        System.out.println("\nSteps for integer array : " + counter);

        // print the sorted floating point number array
        System.out.println("\nFloating point array");
        for(int i = 0; i <input2.length; i++)
        {
            floatctr+=4; //1 comparison, 1 assignment, 1 addition, 1 .length
            System.out.print(input2[i]+", ");
        }

        System.out.println("\nSteps for floating point array : " + floatctr);
        myObj.close();
    }
    
}