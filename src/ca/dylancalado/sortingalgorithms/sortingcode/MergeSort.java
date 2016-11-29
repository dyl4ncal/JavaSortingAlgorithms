package ca.dylancalado.sortingalgorithms.sortingcode;

import java.util.Arrays;

/**
 * Logic for performing a merge sort.
 * 
 * @author Dylan
 */
public class MergeSort implements SortFacade
{
    public static void sort(SortParameters p)
    {
        int [] inputArray = p.getArray();
        
        int[] left = Arrays.copyOfRange(inputArray, 0, (inputArray.length / 2) - 1);
        int[] right = Arrays.copyOfRange(inputArray, (inputArray.length / 2), inputArray.length - 1);

        if (left.length > 1) 
        {
            
            MergeSort.sort(p);//Sort left array segment.
        }
        if (right.length > 1)
        {
            MergeSort.sort(p);//Sort right array segment.
        }

        merge(p.getArray(), left, right);
    }
    
    public static void merge(int[] array, int[] leftArray, int[] rightArray)
    {
        int l = 0;
        int r = 0; 
        int j = 0;
        
        while (l < leftArray.length && r < rightArray.length)//Check that left and right indices are within bounds.
        {
            if (leftArray[l] <= rightArray[r])
            {
                array[j] = leftArray[l];
                ++l;
                ++j;
            }
            else
            {
                array[j] = rightArray[r];
                ++r;
                ++j;
            }
        }
        while (l < leftArray.length) 
        {
            array[j] = leftArray[l];
            ++l;
            ++j;
        }
        while (r < leftArray.length)
        {
            array[j] = rightArray[r];
            ++r;
            ++j;
        }
    }
    
    /*public static void merge(int[] array, int[] leftArray, int[] rightArray)
    {
        int l = 0;
        int r = 0;
        
        for(int i = 0; i < array.length; ++i)
        {
            if (l < leftArray.length && r < rightArray.length)
            {
                if (leftArray[l] < rightArray[r])
                {
                    array[i++] = leftArray[l++];
                }
                else if (leftArray[l] > rightArray[r])
                {
                    array[i++] = rightArray[r++];
                }
                else 
                {
                    array[i++] = leftArray[l++];
                    array[i++] = rightArray[r++];
                }
            }
        }
    }*/
}
