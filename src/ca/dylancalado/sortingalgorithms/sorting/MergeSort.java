package ca.dylancalado.sortingalgorithms.sorting;

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
        int[] left = Arrays.copyOfRange(p.getArray(), 0, (p.getArray().length/2));
        int[] right = Arrays.copyOfRange(p.getArray(), (p.getArray().length/2)+1, p.getArray().length);

        if (left.length > 1) 
        {
            p.setArray(left);
            MergeSort.sort(p);//Sort left array segment.
        }
        if (right.length > 1)
        {
            p.setArray(right);
            MergeSort.sort(p);//Sort right array segment.
        }
        
        merge(p.getArray(), left, right);
    }
    
    public static void merge(int[] array, int[] leftArray, int[] rightArray)
    {
        int l = 0;
        int r = 0; 
        int j = 0;
        
        while (l < leftArray.length && r < rightArray.length && j < array.length)//Check that left and right indices are within bounds.
        {
            if (leftArray[l] < rightArray[r])
            {
                array[j++] = leftArray[l++];
            }
            else
            {
                array[j++] = rightArray[r++];

            }
        }
        
        while (l < leftArray.length && j < array.length) 
        {
            array[j++] = leftArray[l++];
        }
        while (r < rightArray.length && j < array.length)
        {
            array[j++] = rightArray[r++];
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
