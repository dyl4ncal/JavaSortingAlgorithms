package ca.dylancalado.sortingalgorithms.sorting;

import ca.dylancalado.sortingalgorithms.experiments.MemoryUsage;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import java.util.Arrays;

/**
 * Logic for performing a merge sort.
 * 
 * @author Dylan
 */
public class MergeSort implements SortInterface
{
    public static void sort(SortParameters p)
    {   
        int[] array = p.getArray();
        int[] left = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right = Arrays.copyOfRange(array, array.length/2, array.length);
       
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
 
        merge(array, left, right, p);
        MemoryUsage.memoryUsageAfterSort();
    }
    
    public static void merge(int[] array, int[] leftArray, int[] rightArray, SortParameters p)
    {
        int l = 0;
        int r = 0; 
        int j = 0;

        switch (p.getSortOrder())
        {
            case ASCENDING:
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
                break;
            case DESCENDING:
                while (l < leftArray.length && r < rightArray.length && j < array.length)
                {
                    if (leftArray[l] > rightArray[r])
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
                break;
        }
    }
}
