package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sorting.MergeSort;
import static ca.dylancalado.sortingalgorithms.sorting.SortOrder.*;
import ca.dylancalado.sortingalgorithms.sorting.SortParameters;
import static ca.dylancalado.sortingalgorithms.sorting.SortType.MERGE_SORT;
import java.util.Arrays;

/**
 *
 * @author Dylan
 */
public class TestMergeSort
{
    private static int[] testArray = {3, 6, 1, 9, 4, 8, 2, 10, 5, 7};
    
    public static boolean testMergeSortAscending()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        SortParameters p = new SortParameters(testArray, testArray.length, ASCENDING, MERGE_SORT);
        
        MergeSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);

        System.out.print("Merge sort ascending test passed? ");
        return match;
    }
    
    public static boolean testMergeSortDescending()
    {
        int[] expectedOutput = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SortParameters p = new SortParameters(testArray, testArray.length, DESCENDING, MERGE_SORT);
        
        MergeSort.sort(p);
        
        boolean match = Arrays.equals(testArray, expectedOutput);
        
        System.out.print("Merge sort descending test passed? ");
        return match;
    }
    
    public static boolean testMergeSortMerge()
    {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6};
        int[] parent = {4, 5, 6, 1, 2, 3};
        int[] left = {4, 5, 6};
        int[] right = {1, 2, 3};
        SortParameters p = new SortParameters(parent, parent.length, ASCENDING, MERGE_SORT);
        
        MergeSort.merge(parent, left, right, p);

        boolean match = Arrays.equals(parent, expectedOutput);
        
        System.out.print("Merge sort merge test passed? ");
        return match;
    }
    
    public static void testAllMergeSortMethods()
    {
        System.out.println("Unit Tests Related to Merge Sort:\n");
        System.out.println(testMergeSortMerge());
        System.out.println(testMergeSortAscending());
        System.out.println(testMergeSortDescending() + "\n");
    }
}
