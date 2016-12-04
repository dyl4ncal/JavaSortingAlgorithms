package ca.dylancalado.sortingalgorithms.sorting;

import java.util.Arrays;

/**
 * Logic for performing a merge sort hybrid.
 * 
 * @author Dylan
 */
public class MergeSortHybrid implements SortInterface
{
    public static void sort(SortParameters p)
    {
        int[] array = p.getArray();
        int[] left = Arrays.copyOfRange(array, 0, array.length/2);
        int[] right = Arrays.copyOfRange(array, array.length/2, array.length);

        if (left.length > p.getHybridThreshold()) 
        {
            p.setArray(left);
            MergeSort.sort(p);//left,threshold
        }
        else
        {
            p.setArray(left);
            p.setArraySize(p.getArray().length);
            InsertionSort.sort(p);//left
        }
        
        if (right.length > p.getHybridThreshold())
        {
            p.setArray(right);
            MergeSort.sort(p);//right,threshold 
        }
        else
        {
            p.setArray(right);
            p.setArraySize(p.getArray().length);
            InsertionSort.sort(p);//right
        }

        MergeSort.merge(array, left, right, p);
    }
}
