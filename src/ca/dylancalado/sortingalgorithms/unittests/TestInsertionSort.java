package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.InsertionSort;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sortingcode.SortParameters;
import static ca.dylancalado.sortingalgorithms.sortingcode.SortType.INSERTION_SORT;
import java.util.Arrays;

/**
 * Unit tests related to insertion sort.
 * 
 * @author dylan
 */
public class TestInsertionSort 
{
    private static int[] testArray = {3, 6, 1, 10, 4, 8, 9, 2, 5, 7};
    
    public static boolean testInsertionSortAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, 10, ASCENDING, INSERTION_SORT);
        
        InsertionSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
            
        System.out.print("Insertion sort ascending test passed? ");
        return match;
    }  
    
    public static boolean testInsertionSortDescending()
    {
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, 10, DESCENDING, INSERTION_SORT);
        
        InsertionSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Insertion sort descending test passed? ");
        return match;
    }    
    
    public static void testAllInsertionSortMethods()
    {
        System.out.println("Unit Tests Related to Insertion Sort:\n");
        System.out.println(testInsertionSortAscending());
        System.out.println(testInsertionSortDescending() + "\n");
    }
}
