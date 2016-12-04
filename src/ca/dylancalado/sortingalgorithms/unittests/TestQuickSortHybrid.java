package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sorting.QuickSortHybrid;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sorting.SortParameters;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.QUICK_SORT_HYBRID;
import java.util.Arrays;

/**
 * Unit tests related to quick sort hybrid.
 * 
 * @author Dylan
 */
public class TestQuickSortHybrid
{
    private static int[] testArray = {3, 6, 1, 9, 4, 8, 2, 10, 5, 7};
    
    public static boolean testQuickSortHybridAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, testArray.length, 16, 0, testArray.length-1, ASCENDING, QUICK_SORT_HYBRID);
        
        QuickSortHybrid.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
          for(int i = 0; i < testArray.length; ++i)
        {
            System.out.print(testArray[i] + " ");
        }
        System.out.print("Quick sort hybrid ascending test passed? ");
        return match;
    }
    
    public static boolean testQuickSortHybridDescending()
    {
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, testArray.length, 16, 0, testArray.length-1, DESCENDING, QUICK_SORT_HYBRID);
        
        QuickSortHybrid.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
         for(int i = 0; i < testArray.length; ++i)
        {
            System.out.print(testArray[i] + " ");
        }
        System.out.print("Quick sort hybrid descending test passed? ");
        return match;
    }
    
    public static void testAllQuickSortHybridMethods()
    {
        System.out.println("Unit Tests Related to Quick Sort Hybrid:\n");
        System.out.println(testQuickSortHybridAscending());
        System.out.println(testQuickSortHybridDescending() + "\n");
    }
}
