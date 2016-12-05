package ca.dylancalado.sortingalgorithms.sorting;

import ca.dylancalado.sortingalgorithms.experiments.MemoryUsage;
import static ca.dylancalado.sortingalgorithms.sorting.QuickSort.getPivotValue;

/**
 * Logic for performing a quick sort hybrid.
 * 
 * @author Dylan
 */
public class QuickSortHybrid implements SortInterface
{
    public static void sort(SortParameters p)
    {
        int[] array = p.getArray();
        int left = p.getLeftIndex();
        int right = p.getRightIndex();
        int i = p.getLeftIndex();
        int j = p.getRightIndex();
        
        int pivotValue = getPivotValue(array, i, j);
        
        while(i <= j)
        {
            switch (p.getSortOrder()) 
            {
                case ASCENDING:
                    while (array[i] < pivotValue)
                    {
                        i++;
                    }
                    while (array[j] > pivotValue)
                    {
                        j--;
                    }
                    if (i <= j) 
                    {
                        SelectionSort.swap(array, i, j);
                        i++;
                        j--;
                    }
                    break;
                case DESCENDING:
                    while (array[i] > pivotValue)
                    {
                        i++;
                    }
                    while (array[j] < pivotValue)
                    {
                        j--;
                    }
                    if (i <= j) 
                    {
                        SelectionSort.swap(array, i, j);
                        i++;
                        j--;
                    }
                    break;
            }        
        }
        p.setPivotPosition(i);
        
        if(p.getPivotPosition()-left < p.getHybridThreshold())
        {
            InsertionSort.insertionSort(p.getArray(), p.getSortOrder(), left, p.getPivotPosition()-1);
        }
        else
        {
            p.setLeftIndex(left);
            p.setRightIndex(p.getPivotPosition()-1);
            QuickSort.sort(p);
        }
        
        if(right-p.getPivotPosition() < p.getHybridThreshold())
        {
            InsertionSort.insertionSort(p.getArray(), p.getSortOrder(), p.getPivotPosition(), right);
        }
        else
        {
            p.setLeftIndex(p.getPivotPosition());
            p.setRightIndex(right);
            QuickSort.sort(p);
        }
        MemoryUsage.memoryUsageAfterSort();
    }
}
