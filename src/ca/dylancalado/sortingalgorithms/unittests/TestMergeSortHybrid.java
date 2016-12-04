package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sorting.MergeSortHybrid;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sorting.SortParameters;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.MERGE_SORT_HYBRID;
import java.util.Arrays;

/**
 *
 * @author Dylan
 */
public class TestMergeSortHybrid
{
    private static int[] testArray = {3, 6, 1, 9, 4, 8, 2, 10, 5, 7};
    
    public static boolean testMergeSortHybridAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, testArray.length, ASCENDING, MERGE_SORT_HYBRID);
        
        MergeSortHybrid.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);

        System.out.print("Merge sort hybrid ascending test passed? ");
        return match;
    }
    
    public static boolean testMergeSortHybridDescending()
    {
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, testArray.length, DESCENDING, MERGE_SORT_HYBRID);
        
        MergeSortHybrid.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Merge sort hybrid descending test passed? ");
        return match;
    }
    
    public static void testAllMergeSortHybridMethods()
    {
        System.out.println("Unit Tests Related to Merge Sort Hybrid:\n");
        System.out.println(testMergeSortHybridAscending());
        System.out.println(testMergeSortHybridDescending() + "\n");
    }
}
