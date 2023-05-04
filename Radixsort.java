import java.util.ArrayList;

public class Radixsort {

    public static void radixSort(int[] arr) {
        System.out.println("\n\n--------------Radix Sort Algoritm for Integer--------------\n");

       String num = Integer.toString(getMax(arr));
       int max = num.length(), exp = 1;

       for(int i = 0; i < max; i++)
       {
            Sorting(arr, exp*=10);
            System.out.println("("+ (i+1) +") Iteration");
            for (int j = 0; j <arr.length; j++)
                System.out.print(arr[j]+", ");
            System.out.println("\n");
       }

       System.out.println("Array Sorted: ");
       for (int i = 0; i < arr.length; i++)
        System.out.print(arr[i]+", ");

    }

    public static void radixSort(float[] arr)
    {
        System.out.println("\n\n--------------Radix Sort Algoritm for Floating Number--------------\n");

       int digit = getMaxDigit(arr);
       int radix = (int)Math.pow(10, digit);
       int[] intArr = new int[arr.length];

       for (int i = 0; i < arr.length; i++)
        intArr[i] = (int)(arr[i] * radix);
            

       String num = Integer.toString(getMax(intArr));
       int max = num.length(), exp = 1;

       for(int i = 0; i < max; i++)
       {
            Sorting(intArr, exp*=10);
            System.out.println("("+ (i+1) +") Iteration");
            for (int j = 0; j <intArr.length; j++)
                System.out.print(intArr[j]+", ");
            System.out.println("\n");
       }

       System.out.println("Array Sorted: ");
       for (int i = 0; i < intArr.length; i++)
       {
        arr[i] = intArr[i] / (float)radix;
        System.out.print(arr[i]+", ");
       }
            

    }

    private static int getMax(int[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(arr[i]> mx)
                mx = arr[i];
        }
        return mx;
    }

    private static int getMaxDigit(float[] arr) {
        String value;
        int integerPlace, decimal, max = 1;
        for(int i = 0; i <arr.length; i++)
        {
            value = Float.toString(Math.abs(arr[i]));
            integerPlace = value.indexOf(".");
            decimal = value.length() - integerPlace - 1;
            if(decimal>max)
                max = decimal;
        }
        return max;
    }

    private static void Sorting(int[] arr, int exp)
    {
        if(exp <=0)
            return;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] array = new ArrayList[10];

        for(int i = 0; i<10; i++)
        {
            array[i]= new ArrayList<Integer>();
        }

        for(int i = 0; i<arr.length; i++)
        {
            int index = (arr[i]/exp)%10;
            array[index].add(arr[i]);
        }
        
        int index = 0;
        for(int i = 0; i< 10; i ++)
        {
            for(int j = 0, size = array[i].size(); j<size; j++)
            {
                if(index<arr.length)
                    arr[index++]= array[i].get(j);
            }
        }
    }

   public static void main(String [] args)
   {
    int [] input = {275, 87, 426, 61, 409, 170, 677, 503};
    float [] input2 = {10.382f, 8.743f, 47.1654f, 28.9f, 53.2505f, 28.89f, 44.504f, 81.72f, 8.1198f, 10.897f};
    radixSort(input);
    radixSort(input2);
   }
}