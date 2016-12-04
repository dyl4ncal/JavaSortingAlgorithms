package ca.dylancalado.sortingalgorithms.sorting;

import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;

/**
 * Logic for performing an insertion sort.
 * 
 * @author dylan
 */
public class InsertionSort implements SortFacade
{
    private static int value;
    private static int j;
    
    public static void sort(SortParameters p)
    {
        for(int i = 1; i < p.getArraySize(); ++i)
        {
            value = p.getArray()[i];
            j = i - 1;
            
            switch (p.getSortOrder())
            {
                case DESCENDING:
                    while (j >= 0 && p.getArray()[j] < value)
                    {
                        p.getArray()[j + 1] = p.getArray()[j];
                        --j;
                    }
                    break;
                default:
                    while (j >= 0 && p.getArray()[j] > value)
                    {
                        p.getArray()[j + 1] = p.getArray()[j];
                        --j;
                    }
                    break;
            }
            p.getArray()[j+1] = value;
        }
    } 
    
    //Modified Insertion Sort to work with hybrid sorts.
    public static void insertionSort(int[] list, SortOrder order, int left, int right)
    {
        for (int i = left; i < right; i++) 
        {
            int val = list[i];
            int j = i - 1;

            switch (order) 
            {
                case ASCENDING:
                    while (j >= 0 && list[j] > val)
                    {
                        list[j + 1] = list[j];
                        j--;
                    }
                    list[j + 1] = val;
                    break;
                case DESCENDING:
                    while (j >= 0 && list[j] < val)
                    {
                        list[j + 1] = list[j];
                        j--;
                    }
                    list[j + 1] = val;
                    break;
            }
        }
    }
}
