package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.QuickSort;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.QUICK_SORT;
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
        SortParameters p = new SortParameters(testArray, 10, ASCENDING, QUICK_SORT);
        
        QuickSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Quick sort ascending test passed? ");
        return match;
    }
    public static boolean testQuickSortGetPivotValue()
    {
        int expectedOutput = 12;
        int a = 12;
        int b = 5;
        int c = 22;
        
        int actualOutput = QuickSort.getPivotValue(a, b, c);
       
        boolean match = (actualOutput == expectedOutput);
       
        System.out.print("Quick sort get pivot value test passed? ");
        return match;
    }
    
    public static void testAllQuickSortMethods()
    {
        /*System.out.println("Unit Tests Related to Selection Sort:\n");
        System.out.println(testSelectionSortSwap());
        System.out.println(testSelectionSortAscending());
        System.out.println(testSelectionSortDescending() + "\n");*/
    }
}
