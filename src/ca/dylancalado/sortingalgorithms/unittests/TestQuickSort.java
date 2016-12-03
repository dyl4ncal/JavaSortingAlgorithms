package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sorting.QuickSort;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sorting.SortParameters;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.QUICK_SORT;
import java.util.Arrays;

/**
 * Unit tests related to quick sort.
 * 
 * @author Dylan
 */
public class TestQuickSort 
{
    private static int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
    
    public static boolean testQuickSortAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, testArray.length, 0, testArray.length-1, ASCENDING, QUICK_SORT);
        
        QuickSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        for(int i = 0; i < testArray.length; ++i)////////////////////////////////
        {
            System.out.print(testArray[i] + " ");
        }
        
        System.out.print("Quick sort ascending test passed? ");
        return match;
    }
    
    public static boolean testQuickSortDescending()
    {
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, 10, DESCENDING, QUICK_SORT);
        
        QuickSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        for(int i = 0; i < testArray.length; ++i)////////////////////////////////
        {
            System.out.print(testArray[i] + " ");
        }
        
        System.out.print("Quick sort descending test passed? ");
        return match;
    }
    
    public static boolean testQuickSortGetPivotValue()
    {
        int[] arr = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
        int expectedOutput = 4;
  
        int actualOutput = QuickSort.getPivotValue(arr[0], arr[(arr.length/2)-1], arr[arr.length-1]);

        boolean match = (actualOutput == expectedOutput);
        
        System.out.print("Quick sort get pivot value test passed? ");
        return match;
    }
    
    public static void testAllQuickSortMethods()
    {
        System.out.println("Unit Tests Related to Quick Sort:\n");
        System.out.println(testQuickSortGetPivotValue());
        System.out.println(testQuickSortAscending());
        System.out.println(testQuickSortDescending() + "\n");
    }
}
