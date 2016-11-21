package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.QuickSort;

/**
 * Unit tests related to quick sort.
 * 
 * @author Dylan
 */
public class TestQuickSort 
{
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
