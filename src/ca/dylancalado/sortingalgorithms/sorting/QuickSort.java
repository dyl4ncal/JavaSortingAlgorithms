package ca.dylancalado.sortingalgorithms.sorting;

import static java.lang.Integer.*;
import java.util.Arrays;

/**
 * Logic for performing a quick sort.
 * 
 * @author Dylan
 */
public class QuickSort implements SortFacade
{
    private static int pivotPosition;
    
    public static void sort(SortParameters p)
    {
        int[] array = p.getArray();
        int i = p.getLeftIndex();
        int j = p.getRightIndex();
        int pivotValue; 
        
        if(array.length % 2 != 0)
        {
            pivotValue = getPivotValue(array[p.getLeftIndex()], array[(array.length/2-1)], array[array.length-1]);//If array has odd number of elements.
        }
        else
        {
            pivotValue = getPivotValue(array[p.getLeftIndex()], array[(array.length/2)], array[array.length-1]);//If array has even number of elements.
        }
        
        System.out.println("PivotValue: " + pivotValue);
        while(i <= j)
        {
            while(array[i] < pivotValue)
            {
                i++;
            }
            while(array[j] > pivotValue)
            {
                j--;
            }
            if(i <= j)
            {
                SelectionSort.swap(array, i, j);
                i++;
                j--;
            }
        }
        pivotPosition = i;
        
        if(p.getLeftIndex() < j)
        {
            System.out.println("QS Left Called");
            p.setLeftIndex(0);
            p.setRightIndex(pivotPosition-1);
            p.setArray(Arrays.copyOfRange(array, 0, pivotPosition));
            QuickSort.sort(p);
        }
        if(p.getRightIndex() > i)
        {
            System.out.println("QS Right Called");
            p.setLeftIndex(pivotPosition);
            p.setRightIndex(array.length-1);
            p.setArray(Arrays.copyOfRange(array, pivotPosition-1, array.length-1));
            QuickSort.sort(p);
        }
    }
    
    public static int getPivotValue(int first, int middle, int last)
    {
        int pivot = max(min(first,middle), min(max(first,middle),last));

        return pivot;
    }
}
