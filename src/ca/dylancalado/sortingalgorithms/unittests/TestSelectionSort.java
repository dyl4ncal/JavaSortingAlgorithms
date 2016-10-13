package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.SelectionSort;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.ASCENDING;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.DESCENDING;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.SELECTION_SORT;
import java.util.Arrays;

/**
 * Unit tests related to selection sort.
 * 
 * @author dylan
 */
public class TestSelectionSort
{
    public static boolean testSelectionSortAscending()
    {
        int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, 10, ASCENDING, SELECTION_SORT);
        
        SelectionSort.sort(p);
        
        if(Arrays.equals(testArray, expectedOutput))
        {
            System.out.print("Selection sort ascending test passed? ");
            return true;
        }
        else
        {
            System.out.print("Selection sort ascending test passed? ");
            return false;
        }
    }
    
    public static boolean testSelectionSortDescending()
    {
        int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, 10, DESCENDING, SELECTION_SORT);
        
        SelectionSort.sort(p);
        
        if(Arrays.equals(testArray, expectedOutput))
        {
            System.out.print("Selection sort descending test passed? ");
            return true;
        }
        else
        {
            System.out.print("Selection sort descending test passed? ");
            return false;
        }
    }
    
    public static boolean testSwap()
    {
        int[] testArray = {9, 4};
        int[] expectedOutput = {4,9};
        int a = 1;
        int b = 0;
        SelectionSort.swap(testArray, a, b);
       
        if(Arrays.equals(testArray, expectedOutput))
        {
            System.out.print("Swap test passed? ");
            return true;
        }
        else
        {
            System.out.print("Swap test passed? ");
            return false;
        }
    }
    
    public static void testAllSelectionSortMethods()
    {
        System.out.println(testSwap());
        System.out.println(testSelectionSortAscending());
        System.out.println(testSelectionSortDescending());
    }
}
