package ca.dylancalado.sortingalgorithms.unittests;

import ca.dylancalado.sortingalgorithms.sortingcode.MergeSort;
import java.util.Arrays;

/**
 *
 * @author Dylan
 */
public class TestMergeSort
{
    public static boolean testMergeSortMerge()
    {
        int[] expectedOutput = {9, 13};
        int[] parent = {13, 9};
        int[] left = {13};
        int[] right = {9};

        MergeSort.merge(parent, left, right);

        boolean match = Arrays.equals(parent, expectedOutput);
        for(int i = 0; i < parent.length; ++i)
        {
            System.out.print(parent[i] + ", ");
        }
        
        
        System.out.print("Merge sort merge test passed? ");
        return match;
    }
    
    public static void testAllMergeSortMethods()
    {
        /*System.out.println("Unit Tests Related to Selection Sort:\n");
        System.out.println(testSelectionSortSwap());
        System.out.println(testSelectionSortAscending());
        System.out.println(testSelectionSortDescending() + "\n");*/
    }
}
